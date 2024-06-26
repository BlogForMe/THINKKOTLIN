package thinkjava.Generics.Exercise;

/**
 * Created by Administrator on 2017/1/9.
 */
public class E05_LinkedList {
    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack();
        for (String s : "phasers on stun!".split(" "))
            lss.push(s);
        String s;
        while ((s = lss.pop()) != null)
            System.out.println(s);
    }
}

class LinkedStack<T> {

    private class Node {
        T item;
        Node next;

        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }


}
