// Singly linked list implementation in Java
class UserNoSuchElementException extends RuntimeException {
    UserNoSuchElementException() {
        super();
    }
}

class UserIndexOutOfBoundsException extends RuntimeException {
    UserIndexOutOfBoundsException(String desc) {
        super(desc);
    }
}

class UserLinkedList<E> {

    private int index;
    private Node<E> head;
    private Node<E> tail;

    class Node<E> {
        E ele;
        Node<E> next;

        Node(E ele) {
            this.ele = ele;
        }
    }

    public int size() {
        return this.index;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void add(E ele) {
        Node<E> newNode = new Node<E>(ele);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        index++;
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        Node<E> curr = head;
        String output = "[";

        while (curr.next != null) {
            output = output + curr.ele + ", ";
            curr = curr.next;
        }

        output = output + curr.ele + "]";

        return output;
    }

    public E getFirst() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        return head.ele;
    }

    public E getLast() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        return tail.ele;
    }

    public void addFirst(E ele) {

        Node<E> newNode = new Node<E>(ele);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }

        index++;
    }

    public void addLast(E ele) {
        add(ele);
    }

    public void checkIndex(int index) {

        if (index < 0 || index >= this.index) {
            throw new UserIndexOutOfBoundsException(
                "Invalid index : " + index
            );
        }
    }

    public E get(int index) {

        checkIndex(index);

        Node<E> curr = head;

        for (int i = 1; i <= index; i++) {
            curr = curr.next;
        }

        return curr.ele;
    }

    public E set(int index, E newEle) {

        checkIndex(index);

        Node<E> curr = head;

        for (int i = 1; i <= index; i++) {
            curr = curr.next;
        }

        E temp = curr.ele;
        curr.ele = newEle;

        return temp;
    }

    public E remove(int index) {

        checkIndex(index);

        if (index == 0) {
            E temp = head.ele;
            head = head.next;
            this.index--;

            if (this.index == 0) {
                tail = null;
            }

            return temp;
        }

        Node<E> curr = head;

        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        Node<E> tempNode = curr.next;
        curr.next = tempNode.next;

        if (index == this.index - 1) {
            tail = curr;
        }

        this.index--;

        return tempNode.ele;
    }

    public int indexOf(Object ele) {

        if (isEmpty()) {
            return -1;
        }

        Node<E> curr = head;
        int idx = 0;

        while (curr != null) {

            if (ele == null) {
                if (curr.ele == null) {
                    return idx;
                }
            } else if (ele.equals(curr.ele)) {
                return idx;
            }

            curr = curr.next;
            idx++;
        }

        return -1;
    }

    public int lastIndexOf(Object ele) {

        if (isEmpty()) {
            return -1;
        }

        Node<E> curr = head;
        int idx = 0;
        int lastIndex = -1;

        while (curr != null) {

            if (ele == null) {
                if (curr.ele == null) {
                    lastIndex = idx;
                }
            } else if (ele.equals(curr.ele)) {
                lastIndex = idx;
            }

            curr = curr.next;
            idx++;
        }

        return lastIndex;
    }

    public boolean removeFirstOccurrence(Object ele) {

        if (isEmpty()) {
            return false;
        }

        int indx = indexOf(ele);

        if (indx != -1) {
            remove(indx);
            return true;
        }

        return false;
    }

    public boolean removeLastOccurrence(Object ele) {

        if (isEmpty()) {
            return false;
        }

        int indx = lastIndexOf(ele);

        if (indx != -1) {
            remove(indx);
            return true;
        }

        return false;
    }

    public UserLinkedList<E> reversed() {

        if (isEmpty()) {
            return new UserLinkedList<E>();
        }

        UserLinkedList<E> newList = new UserLinkedList<E>();

        for (int i = 0; i < this.size(); i++) {
            E ele = get(i);
            newList.addFirst(ele);
        }

        return newList;
    }
}

public class UserLinkedListDriver {

    public static void main(String[] args) {

        UserLinkedList<Integer> list1 = new UserLinkedList<Integer>();

        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        list1.add(123);

        System.out.println("List 1 : " + list1);
        System.out.println("Size : " + list1.size());
        System.out.println("Is Empty : " + list1.isEmpty());

        System.out.println("First Element : " + list1.getFirst());
        System.out.println("Last Element : " + list1.getLast());

        list1.addFirst(5);
        System.out.println("After addFirst : " + list1);

        list1.addLast(60);
        System.out.println("After addLast : " + list1);

        System.out.println("Element at index 3 : " + list1.get(3));

        System.out.println("Old value at index 2 : " + list1.set(2, 25));
        System.out.println("After set : " + list1);

        System.out.println("Index of 40 : " + list1.indexOf(40));
        System.out.println("Last Index of 40 : " + list1.lastIndexOf(40));

        System.out.println("Removed element : " + list1.remove(3));
        System.out.println("After remove : " + list1);

        System.out.println(
            "Remove First Occurrence of 40 : " +
            list1.removeFirstOccurrence(40)
        );
        System.out.println("After removeFirstOccurrence : " + list1);

        list1.add(40);
        list1.add(40);

        System.out.println("List after adding duplicates : " + list1);

        System.out.println(
            "Remove Last Occurrence of 40 : " +
            list1.removeLastOccurrence(40)
        );
        System.out.println("After removeLastOccurrence : " + list1);

        UserLinkedList<Integer> list2 = new UserLinkedList<Integer>();

        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        list2.add(50);
        list2.add(60);

        System.out.println();
        System.out.println("List 2 : " + list2);

        UserLinkedList<Integer> revList = list2.reversed();

        System.out.println("Reversed List : " + revList);
    }
}