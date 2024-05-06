package model.basic.collection;

import model.basic.Node;

import java.util.NoSuchElementException;

public class Queue<T> {

    Node<T> head;
    Node<T> tail;

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void enqueue(T value) {
        Node node = new Node();
        node.setData(value);

        if (head == null) {
            head = node;
            tail = node;
            node.setNext(null);
        } else {
            if (head == tail && head != null) {
                tail = node;
                head.setNext(tail);
                tail.setNext(null);
            } else {
                tail.setNext(node);
                node.setNext(null);
                tail = node;
            }
        }
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");

        Node<T> temp = head;
        if (head == tail && head != null) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }
        return temp.getData();
    }

    public void list() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData().toString());
            temp = temp.getNext();
        }
    }

    public int size() {
        if (isEmpty()) return 0;

        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
