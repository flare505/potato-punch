package ds;

public class Node<T> implements Visitable{
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
        left = right = null;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}