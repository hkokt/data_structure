package model.basic.collection;

import model.basic.Node;

import java.util.NoSuchElementException;

public class List<T> {
    private Node<T> head;

    public List() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> temp = head;
        int count = 0;
        while (count < index) {
            temp = temp.getNext();
            count++;
        }

        return temp;
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>();
        node.setData(value);
        node.setNext(head);
        head = node;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>();
        node.setData(value);
        node.setNext(null);
        if (isEmpty()) {
            head = node;
        } else {
            Node<T> last = getNode(size() - 1);
            last.setNext(node);
        }
    }

    public void add(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            addFirst(value);
        } else {
            Node<T> node = new Node<>();
            node.setData(value);
            Node<T> previous = getNode(index - 1);
            node.setNext(previous.getNext());
            previous.setNext(node);
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        head = head.getNext();
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (size() == 1) {
            head = null;
        } else {
            Node<T> penultimate = getNode(size() - 2);
            penultimate.setNext(null);
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            removeFirst();
        } else {
            Node<T> previous = getNode(index - 1);
            Node<T> current = getNode(index);
            previous.setNext(current.getNext());
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<T> temp = getNode(index);
        return temp.getData();
    }
}