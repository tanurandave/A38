import java.util.*;

class UserNoSuchElementException extends RuntimeException {
    UserNoSuchElementException() {
        super();
    }
}

class UserIndexOutOfBoundsException extends RuntimeException {
    UserIndexOutOfBoundsException(String msg) {
        super(msg);
    }
}

class DoublyLinkedList<E> {

    private int idx;
    private Node<E> head;
    private Node<E> tail;

    class Node<E> {
        E ele;
        Node<E> prev;
        Node<E> next;

        Node(E ele) {
            this.ele = ele;
        }
    }

    public int size() {
        return this.idx;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        return this.head.ele;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        return this.tail.ele;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        String op = "[";
        Node<E> curr = head;

        while (curr.next != null) {
            op += curr.ele + ", ";
            curr = curr.next;
        }

        op += curr.ele + "]";

        return op;
    }

    public void add(E ele) {
        Node<E> newNode = new Node<E>(ele);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        this.idx++;
    }

    public void addLast(E ele) {
        add(ele);
    }

    public void addFirst(E ele) {
        Node<E> newNode = new Node<E>(ele);

        if (isEmpty()) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        this.idx++;
    }

    public void add(int index, E ele) {

        if (index < 0 || index > size()) {
            throw new UserIndexOutOfBoundsException(
                "Invalid Index : " + index
            );
        }

        if (index == 0) {
            addFirst(ele);
            return;
        }

        if (index == size()) {
            addLast(ele);
            return;
        }

        Node<E> newNode = new Node<E>(ele);
        Node<E> curr = head;

        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next.prev = newNode;
        curr.next = newNode;
        newNode.prev = curr;

        this.idx++;
    }

    public E removeFirst() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        E temp = getFirst();

        if (size() == 1) {
            head = null;
            tail = null;
            idx--;
            return temp;
        }

        head = head.next;
        head.prev = null;

        this.idx--;

        return temp;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        E temp = getLast();

        if (size() == 1) {
            head = null;
            tail = null;
            idx--;
            return temp;
        }

        tail = tail.prev;
        tail.next = null;

        this.idx--;

        return temp;
    }

    public E remove(int index) {

        if (index < 0 || index >= size()) {
            throw new UserIndexOutOfBoundsException(
                "Invalid index : " + index
            );
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size() - 1) {
            return removeLast();
        }

        Node<E> curr = head;

        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        E temp = curr.next.ele;

        Node<E> tempNode = curr.next;

        curr.next = curr.next.next;
        curr.next.prev = curr;

        tempNode.next = null;
        tempNode.prev = null;

        this.idx--;

        return temp;
    }
}

class DriverExampleLinkedList2 {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list =
                new DoublyLinkedList<Integer>();

        System.out.println("Initial List:");
        System.out.println(list);

        System.out.println("\nIs list empty?");
        System.out.println(list.isEmpty());

        System.out.println("\nAdding elements using add():");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println(list);

        System.out.println("\nSize:");
        System.out.println(list.size());

        System.out.println("\nFirst element:");
        System.out.println(list.getFirst());

        System.out.println("\nLast element:");
        System.out.println(list.getLast());

        System.out.println("\nAdding element using addFirst():");
        list.addFirst(5);
        System.out.println(list);

        System.out.println("\nAdding element using addLast():");
        list.addLast(50);
        System.out.println(list);

        System.out.println("\nAdding element at index 3:");
        list.add(3, 25);
        System.out.println(list);

        System.out.println("\nSize after additions:");
        System.out.println(list.size());

        System.out.println("\nRemove first:");
        System.out.println(list.removeFirst());
        System.out.println(list);

        System.out.println("\nRemove last:");
        System.out.println(list.removeLast());
        System.out.println(list);

        System.out.println("\nRemove element at index 2:");
        System.out.println(list.remove(2));
        System.out.println(list);

        System.out.println("\nFirst element after operations:");
        System.out.println(list.getFirst());

        System.out.println("\nLast element after operations:");
        System.out.println(list.getLast());

        System.out.println("\nFinal size:");
        System.out.println(list.size());

        System.out.println("\nIs list empty?");
        System.out.println(list.isEmpty());
    }
}