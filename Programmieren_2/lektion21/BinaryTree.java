package de.thws.lektion21;
public class BinaryTree<T> {
    private Node<T> root;
    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void add(T data) {
        root = addRecursive(root, data);
    }
    private Node<T> addRecursive(Node<T> current, T data) {
        if (current == null) {
            return new Node<>(data);
        }
        // Hier können Sie die Logik für die Anordnung der Elemente anpassen
        if (data.hashCode() < root.data.hashCode()) {
            root.left = addRecursive(root.left, data);
        } else if (data.hashCode() > root.data.hashCode()) {
            root.right = addRecursive(root.right, data);
        }
        return current;
    }
    public void printTree() {
        printTreeRecursive(root);
    }
    private void printTreeRecursive(Node<T> current) {
        if (current != null) {
            printTreeRecursive(current.left);
            System.out.println(current.data);
            printTreeRecursive(current.right);
        }
    }
}
