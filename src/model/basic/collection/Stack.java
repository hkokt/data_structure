package model.basic.collection;

import model.basic.Node;

import java.util.NoSuchElementException;

public class Stack<T> {
    private Node<T> top;

    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T data = top.getData();
        top = top.getNext();
        return data;
    }

    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        return top.getData();
    }

    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
