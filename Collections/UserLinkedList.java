package Collections;

import java.util.Arrays;
import java.util.Objects;

class UserNoSuchElementException extends RuntimeException {

    public UserNoSuchElementException() {
        super();
    }

    public UserNoSuchElementException(String desc) {
        super(desc);
    }
}

class UserIndexOutOfBoundsException extends RuntimeException {

    public UserIndexOutOfBoundsException() {
        super();
    }

    public UserIndexOutOfBoundsException(String desc) {
        super(desc);
    }
}

public class UserLinkedList<E> {

    class Node<T> {
        T ele;
        Node<T> next;

        Node(T ele) {
            this.ele = ele;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public int size() {
        return this.size;
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

        size++;
    }

    public void add(int index, E ele) {

        checkAddIndex(index);

        if (index == size) {
            add(ele);
            return;
        }

        Node<E> newNode = new Node<E>(ele);

        if (index == 0) {
            newNode.next = head;
            head = newNode;

            if (tail == null) {
                tail = newNode;
            }
        } else {

            Node<E> curr = head;

            for (int i = 1; i < index; i++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;
        }

        size++;
    }

    public void addFirst(E ele) {
        add(0, ele);
    }

    public void addLast(E ele) {
        add(ele);
    }

    public E get(int index) {

        checkIndex(index);

        Node<E> curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.ele;
    }

    public E set(int index, E ele) {

        checkIndex(index);

        Node<E> curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        E oldEle = curr.ele;
        curr.ele = ele;

        return oldEle;
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

    public E removeFirst() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        E ele = head.ele;

        head = head.next;
        size--;

        if (size == 0) {
            tail = null;
        }

        return ele;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        if (size == 1) {
            return removeFirst();
        }

        Node<E> curr = head;

        while (curr.next != tail) {
            curr = curr.next;
        }

        E ele = tail.ele;

        tail = curr;
        tail.next = null;

        size--;

        return ele;
    }

    public E remove(int index) {

        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node<E> curr = head;

        for (int i = 1; i < index; i++) {
            curr = curr.next;
        }

        Node<E> tempNode = curr.next;

        curr.next = tempNode.next;

        tempNode.next = null;

        size--;

        return tempNode.ele;
    }

    public boolean remove(Object ele) {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        if (Objects.equals(head.ele, ele)) {
            removeFirst();
            return true;
        }

        Node<E> curr = head;

        while (curr.next != null) {

            if (Objects.equals(curr.next.ele, ele)) {

                if (curr.next == tail) {
                    removeLast();
                } else {
                    Node<E> tempNode = curr.next;

                    curr.next = tempNode.next;

                    tempNode.next = null;

                    size--;
                }

                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    public void clear() {

        head = null;
        tail = null;
        size = 0;
    }

    public boolean contains(Object ele) {

        if (isEmpty()) {
            return false;
        }

        Node<E> curr = head;

        for (int i = 0; i < size; i++) {

            if (Objects.equals(curr.ele, ele)) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    public int indexOf(Object ele) {

        if (isEmpty()) {
            return -1;
        }

        Node<E> curr = head;

        for (int i = 0; i < size; i++) {

            if (Objects.equals(curr.ele, ele)) {
                return i;
            }

            curr = curr.next;
        }

        return -1;
    }

    public int lastIndexOf(Object ele) {

        if (isEmpty()) {
            return -1;
        }

        Node<E> curr = head;
        int index = -1;

        for (int i = 0; i < size; i++) {

            if (Objects.equals(curr.ele, ele)) {
                index = i;
            }

            curr = curr.next;
        }

        return index;
    }

    public void addAll(UserLinkedList<E> newList) {

        if (newList == null || newList.isEmpty()) {
            return;
        }

        for (int i = 0; i < newList.size(); i++) {
            E ele = newList.get(i);
            add(ele);
        }
    }

    public void addAll(int index, UserLinkedList<E> newList) {

        checkAddIndex(index);

        if (newList == null || newList.isEmpty()) {
            return;
        }

        if (index == size) {
            addAll(newList);
            return;
        }

        for (int i = 0; i < newList.size(); i++) {
            E ele = newList.get(i);
            add(index + i, ele);
        }
    }

    public boolean removeAll(Object ele) {

        if (isEmpty()) {
            return false;
        }

        boolean removed = false;

        while (contains(ele)) {
            remove(ele);
            removed = true;
        }

        return removed;
    }

    public boolean removeAll(UserLinkedList<E> newList) {

        if (newList == null || newList.isEmpty()) {
            return false;
        }

        boolean removed = false;

        for (int i = 0; i < newList.size(); i++) {

            E ele = newList.get(i);

            while (contains(ele)) {
                remove(ele);
                removed = true;
            }
        }

        return removed;
    }

    public UserLinkedList<E> subList(int fromIndex, int toIndex) {

        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new UserIndexOutOfBoundsException(
                    "Invalid index : fromIndex = " + fromIndex
                            + ", toIndex = " + toIndex
            );
        }

        UserLinkedList<E> newList = new UserLinkedList<>();

        for (int i = fromIndex; i < toIndex; i++) {
            E ele = get(i);
            newList.add(ele);
        }

        return newList;
    }

    public Object[] toArray() {

        Object[] arr = new Object[size];

        Node<E> curr = head;

        for (int i = 0; i < size; i++) {
            arr[i] = curr.ele;
            curr = curr.next;
        }

        return arr;
    }

    public void reverse() {

        if (size <= 1) {
            return;
        }

        Node<E> prev = null;
        Node<E> curr = head;

        tail = head;

        while (curr != null) {

            Node<E> next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }

        head = prev;
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new UserIndexOutOfBoundsException(
                    "Invalid index = " + index
            );
        }
    }

    private void checkAddIndex(int index) {

        if (index < 0 || index > size) {
            throw new UserIndexOutOfBoundsException(
                    "Invalid index = " + index
            );
        }
    }

    @Override
    public String toString() {

        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        Node<E> curr = head;

        while (curr != null) {

            sb.append(curr.ele);

            if (curr.next != null) {
                sb.append(", ");
            }

            curr = curr.next;
        }

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {

        UserLinkedList<Integer> list = new UserLinkedList<>();

        System.out.println("===== add(E) =====");
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("List = " + list);

        System.out.println("\n===== size() =====");
        System.out.println("Size = " + list.size());

        System.out.println("\n===== isEmpty() =====");
        System.out.println("Is empty = " + list.isEmpty());

        System.out.println("\n===== addFirst() =====");
        list.addFirst(5);
        System.out.println("List = " + list);

        System.out.println("\n===== addLast() =====");
        list.addLast(40);
        System.out.println("List = " + list);

        System.out.println("\n===== add(index, element) =====");
        list.add(2, 15);
        System.out.println("List = " + list);

        System.out.println("\n===== get(index) =====");
        System.out.println("Element at index 2 = " + list.get(2));

        System.out.println("\n===== getFirst() =====");
        System.out.println("First = " + list.getFirst());

        System.out.println("\n===== getLast() =====");
        System.out.println("Last = " + list.getLast());

        System.out.println("\n===== set(index, element) =====");
        System.out.println("Old value = " + list.set(2, 18));
        System.out.println("List = " + list);

        System.out.println("\n===== contains() =====");
        System.out.println("Contains 20 = " + list.contains(20));
        System.out.println("Contains 100 = " + list.contains(100));

        System.out.println("\n===== indexOf() =====");
        System.out.println("Index of 20 = " + list.indexOf(20));

        list.add(20);

        System.out.println("\n===== lastIndexOf() =====");
        System.out.println("Last index of 20 = " + list.lastIndexOf(20));

        System.out.println("\n===== remove(Object) =====");
        System.out.println("Removed = " + list.remove((Object) 20));
        System.out.println("List = " + list);

        System.out.println("\n===== remove(index) =====");
        System.out.println("Removed = " + list.remove(2));
        System.out.println("List = " + list);

        System.out.println("\n===== removeFirst() =====");
        System.out.println("Removed = " + list.removeFirst());
        System.out.println("List = " + list);

        System.out.println("\n===== removeLast() =====");
        System.out.println("Removed = " + list.removeLast());
        System.out.println("List = " + list);

        UserLinkedList<Integer> list2 = new UserLinkedList<>();

        list2.add(100);
        list2.add(200);
        list2.add(300);

        System.out.println("\n===== list2 =====");
        System.out.println("List2 = " + list2);

        System.out.println("\n===== addAll() =====");
        list.addAll(list2);
        System.out.println("List = " + list);

        UserLinkedList<Integer> list3 = new UserLinkedList<>();

        list3.add(400);
        list3.add(500);

        System.out.println("\n===== addAll(index, list) =====");
        list.addAll(1, list3);
        System.out.println("List = " + list);

        System.out.println("\n===== subList() =====");
        UserLinkedList<Integer> subList = list.subList(1, 4);
        System.out.println("SubList = " + subList);

        System.out.println("\n===== toArray() =====");
        Object[] arr = list.toArray();
        System.out.println("Array = " + Arrays.toString(arr));

        System.out.println("\n===== reverse() =====");
        list.reverse();
        System.out.println("List = " + list);

        System.out.println("\n===== removeAll(Object) =====");
        list.add(100);
        list.add(100);
        System.out.println("Before = " + list);
        System.out.println("Removed = " + list.removeAll((Object) 100));
        System.out.println("After = " + list);

        System.out.println("\n===== removeAll(UserLinkedList) =====");

        UserLinkedList<Integer> removeList = new UserLinkedList<>();

        removeList.add(400);
        removeList.add(500);

        System.out.println("Remove List = " + removeList);
        System.out.println("Removed = " + list.removeAll(removeList));
        System.out.println("List = " + list);

        System.out.println("\n===== clear() =====");
        list.clear();
        System.out.println("List = " + list);

        System.out.println("\n===== Final Result =====");
        System.out.println("Size = " + list.size());
        System.out.println("Is Empty = " + list.isEmpty());
    }
}