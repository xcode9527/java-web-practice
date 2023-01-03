package com.xcode.icu.common;

public class Node<T> {

    private T val;

    private Node next;

    public Node (T val) {
        this.val = val;
    }

    public Node (T val,Node node) {
        this.val = val;
        this.next = node;
    }

    public void val(T val) {
        this.val = val;
    }

    public void next(Node node) {
        this.next = node;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

}
