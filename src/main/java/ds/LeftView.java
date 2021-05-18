package ds;

// _ _ _
// / / /
// / / /


public class LeftView {
    static int MAX_LEVEL = -1;

    private static void printBottomLeftView(Node<Integer> node, int level) {
        if (node == null) {
            return;
        }
        if (level > MAX_LEVEL) {
            System.out.println(node.data);
            MAX_LEVEL = level;
        }
        printBottomLeftView(node.left, level + 1);
        printBottomLeftView(node.right, level + 1);
    }


    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(10);
        root.left = new Node<Integer>(5);
        root.right = new Node<Integer>(23);
        root.left.left = new Node<Integer>(2);
        root.right.left = new Node<Integer>(16);

        TreeVisitor treeVisitor = new TreeVisitor();
        treeVisitor.visit(root);

        printBottomLeftView(root, 0);
    }
}
