import org.apache.zookeeper.*;
import java.io.*;
import java.util.*;

public class ZooWatcher implements Watcher {
    private static final String NODE_PATH = "/a";
    private static final String PYTHON_PATH = "python";
    private static final String SCRIPT_PATH = "src/display_children.py";
    private static final String TREE_DATA_PATH = "src/treeData.txt";
    private static final String TREE_SCRIPT_PATH = "src/display_tree.py";

    private final ZooKeeper zooKeeper;
    private final String[] executableArgs;
    private Process executable = null;
    private int descendantCounter = 0;

    public ZooWatcher(String host, String[] appArgs) throws IOException, KeeperException, InterruptedException {
        zooKeeper = new ZooKeeper(host, 3000, event -> {});
        this.executableArgs = appArgs;
        waitForNode();
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        if (args.length < 2) {
            System.out.println("Required host and application path");
        } else {
            String host = args[0];
            String[] executableArgs = Arrays.copyOfRange(args, 1, args.length);
            ZooWatcher zooWatcher = new ZooWatcher(host, executableArgs);
            PrintStream out = new PrintStream(new FileOutputStream("zk_logs.log"));
            System.setOut(out);
            zooWatcher.run();
        }
    }

    public void run() throws IOException, KeeperException, InterruptedException {
        Thread.sleep(3000);
        zooKeeper.addWatch(NODE_PATH, AddWatchMode.PERSISTENT_RECURSIVE);
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = inputReader.readLine().trim();
            switch (input) {
                case "printTree":
                    saveTreeData(NODE_PATH);
                    displayTree();
                    break;
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void process(WatchedEvent event) {
        String path = event.getPath();
        if (path != null && path.equals(NODE_PATH)) {
            try {
                switch (event.getType()) {
                    case NodeDeleted:
                        terminateExecutable();
                        System.out.println("Deleted node ");
                        waitForNode();
                        descendantCounter = 0;
                        break;
                    case NodeChildrenChanged:
                        System.out.println("Node children changed ");
                        countDescendants(NODE_PATH);
                        waitForNode();
                        break;
                    case NodeCreated:
                        System.out.println("Created node ");
                        waitForNode();
                        runExecutable();
                        break;
                }
            } catch (KeeperException | InterruptedException e) {
                handleException(e);
            }
        }
    }

    private void waitForNode() throws KeeperException, InterruptedException {
        zooKeeper.exists(NODE_PATH, this, null, null);
        if (zooKeeper.exists(NODE_PATH, false) != null)
            watchDescendants(NODE_PATH);
    }

    private void watchDescendants(String path) throws KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren(path, this);
        for (String child : children) {
            watchDescendants(path + "/" + child);
        }
    }

    private void countDescendants(String path) throws KeeperException, InterruptedException {
        try {
            List<String> children = zooKeeper.getChildren(path, false);
            for (String child : children) {
                countDescendants(path + "/" + child);
            }
            if (path.equals(NODE_PATH)) {
                if (descendantCounter == 1) {
                    System.out.printf(("Path %s has 1 descendant%n"), NODE_PATH);
                } else {
                    System.out.printf("Path %s has %d descendants%n", NODE_PATH, descendantCounter);
                }
                runPythonScript(descendantCounter);
                descendantCounter = 0;
            } else {
                descendantCounter++;
            }
        } catch (KeeperException e) {
            handleException(e);
            waitForNode();
        }
    }

    private void runPythonScript(int childrenCount) {
        try {
            String[] command = new String[]{PYTHON_PATH, SCRIPT_PATH, String.valueOf(childrenCount)};
            System.out.println("Running command: " + String.join(" ", command));
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException e) {
            System.out.println("Failed to launch the Python script");
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void terminateExecutable() {
        if (isExecutableRunning()) {
            executable.destroy();
        }
    }

    private boolean isExecutableRunning() {
        return executable != null && executable.isAlive();
    }

    private void runExecutable() {
        try {
            if (!isExecutableRunning()) {
                executable = Runtime.getRuntime().exec(executableArgs);
            }
        } catch (IOException e) {
            System.out.println("Failed to launch the application");
        }
    }

    private void saveTreeData(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TREE_DATA_PATH))) {
            printTreeToFile(path, writer);
        } catch (IOException | KeeperException | InterruptedException e) {
            handleException(e);
        }
    }

    private void printTreeToFile(String path, BufferedWriter writer) throws IOException, KeeperException, InterruptedException {
        List<String> children = zooKeeper.getChildren(path, false);
        writer.write(path);
        writer.newLine();
        for (String child : children) {
            printTreeToFile(path + "/" + child, writer);
        }
    }

    private void displayTree() {
        try {
            String[] command = new String[]{PYTHON_PATH, TREE_SCRIPT_PATH, TREE_DATA_PATH};
            System.out.println("Running command: " + String.join(" ", command));
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            printProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            System.out.println("Failed to launch the Python script");
            e.printStackTrace();
        }
    }

    private void printProcessOutput(Process process) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        int exitCode = process.waitFor();
        System.out.println("Script exited with code: " + exitCode);
    }

    private void handleException(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
        e.printStackTrace();
    }
}
