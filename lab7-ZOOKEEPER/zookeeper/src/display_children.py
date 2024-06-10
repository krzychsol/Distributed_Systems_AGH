import sys
from tkinter import Tk, Label


def main():
    if len(sys.argv) != 2:
        print("Usage: python display_children.py <children_count>")
        sys.exit(2)

    children_count = sys.argv[1]

    root = Tk()
    root.title("ZooKeeper Children Count")

    message = f"Path /a has {children_count} {'descendant' if children_count == '1' else 'descendants'}"
    label = Label(root, text=message, padx=100, pady=50)
    label.pack()

    root.mainloop()


if __name__ == "__main__":
    main()
