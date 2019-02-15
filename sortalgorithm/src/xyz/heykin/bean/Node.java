package xyz.heykin.bean;

/**
 * @Program: sortalgorithm
 * @Description:
 * @Author: <a href="http://heykin.xyz">heykin</a>
 * @Create: 2019-01-23 21:04
 * @Since: 1.0
 **/
public class Node {

    private int v;

    private Node next;

    private int count;

    public Node(int v, Node next, int count) {
        this.v = v;
        this.next = next;
        this.count = count;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
