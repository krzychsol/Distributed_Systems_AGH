import networkx as nx
import matplotlib.pyplot as plt
import sys

def draw_tree(tree_data):
    G = nx.DiGraph()
    for node in tree_data:
        parent = '/'.join(node.split('/')[:-1])
        if parent:
            G.add_edge(parent, node)

    pos = nx.spring_layout(G)
    nx.draw(G, pos, with_labels=True, arrows=False)
    plt.show()

def main():
    if len(sys.argv) != 2:
        print("Usage: python draw_tree.py <tree_data.txt>")
        return

    tree_data_path = sys.argv[1]
    with open(tree_data_path, 'r') as f:
        tree_data = [line.strip() for line in f]

    draw_tree(tree_data)

if __name__ == "__main__":
    main()
