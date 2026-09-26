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
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        idx++;
    }

    public void addLast(E ele) {
        add(ele);
    }

    public void addFirst(E ele) {
        Node<E> newNode = new Node<E>(ele);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        idx++;
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

        Node<E> curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        Node<E> newNode = new Node<E>(ele);

        newNode.prev = curr.prev;
        newNode.next = curr;

        curr.prev.next = newNode;
        curr.prev = newNode;

        idx++;
    }

    public boolean addAll(Collection<? extends E> collection) {

        boolean modified = false;

        for (E ele : collection) {
            addLast(ele);
            modified = true;
        }

        return modified;
    }

    public boolean addAll(int index, Collection<? extends E> collection) {

        if (index < 0 || index > size()) {
            throw new UserIndexOutOfBoundsException(
                    "Invalid Index : " + index
            );
        }

        int currentIndex = index;

        for (E ele : collection) {
            add(currentIndex, ele);
            currentIndex++;
        }

        return !collection.isEmpty();
    }

    public boolean contains(E ele) {

        Node<E> curr = head;

        while (curr != null) {

            if (Objects.equals(curr.ele, ele)) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    public boolean containsAll(Collection<?> collection) {

    for (Object ele : collection) {

        Node<E> curr = head;
        boolean found = false;

        while (curr != null) {

            if (Objects.equals(curr.ele, ele)) {
                found = true;
                break;
            }

            curr = curr.next;
        }

        if (!found) {
            return false;
        }
    }

    return true;
}

    public boolean retainAll(Collection<?> collection) {

        boolean modified = false;

        Node<E> curr = head;

        while (curr != null) {

            Node<E> next = curr.next;

            if (!collection.contains(curr.ele)) {
                unlink(curr);
                modified = true;
            }

            curr = next;
        }

        return modified;
    }

    public DoublyLinkedList<E> reversed() {

        DoublyLinkedList<E> reversedList =
                new DoublyLinkedList<E>();

        Node<E> curr = tail;

        while (curr != null) {
            reversedList.addLast(curr.ele);
            curr = curr.prev;
        }

        return reversedList;
    }

    public E get(int index) {

        checkElementIndex(index);

        Node<E> curr = getNode(index);

        return curr.ele;
    }

    public E set(int index, E ele) {

        checkElementIndex(index);

        Node<E> curr = getNode(index);

        E oldElement = curr.ele;

        curr.ele = ele;

        return oldElement;
    }

    public E removeFirst() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        E temp = head.ele;

        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        idx--;

        return temp;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new UserNoSuchElementException();
        }

        E temp = tail.ele;

        if (size() == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        idx--;

        return temp;
    }

    public E remove(int index) {

        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        if (index == size() - 1) {
            return removeLast();
        }

        Node<E> curr = getNode(index);

        E temp = curr.ele;

        unlink(curr);

        return temp;
    }

    public boolean remove(Object ele) {

        Node<E> curr = head;

        while (curr != null) {

            if (Objects.equals(curr.ele, ele)) {
                unlink(curr);
                return true;
            }

            curr = curr.next;
        }

        return false;
    }

    public boolean removeAll(Collection<?> collection) {

        boolean modified = false;

        Node<E> curr = head;

        while (curr != null) {

            Node<E> next = curr.next;

            if (collection.contains(curr.ele)) {
                unlink(curr);
                modified = true;
            }

            curr = next;
        }

        return modified;
    }

    public void clear() {

        Node<E> curr = head;

        while (curr != null) {

            Node<E> next = curr.next;

            curr.prev = null;
            curr.next = null;

            curr = next;
        }

        head = null;
        tail = null;
        idx = 0;
    }

    private Node<E> getNode(int index) {

        if (index < size() / 2) {

            Node<E> curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr;

        } else {

            Node<E> curr = tail;

            for (int i = size() - 1; i > index; i--) {
                curr = curr.prev;
            }

            return curr;
        }
    }

    private void unlink(Node<E> node) {

        Node<E> previous = node.prev;
        Node<E> next = node.next;

        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
        }

        if (next == null) {
            tail = previous;
        } else {
            next.prev = previous;
        }

        node.prev = null;
        node.next = null;

        idx--;
    }

    private void checkElementIndex(int index) {

        if (index < 0 || index >= size()) {
            throw new UserIndexOutOfBoundsException(
                    "Invalid Index : " + index
            );
        }
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

        System.out.println("\nAdding multiple elements using addAll():");

        ArrayList<Integer> list2 =
                new ArrayList<Integer>();

        list2.add(60);
        list2.add(70);
        list2.add(80);

        System.out.println("Collection: " + list2);

        list.addAll(list2);

        System.out.println("After addAll():");
        System.out.println(list);

        System.out.println("\nAdding multiple elements at index 2:");

        ArrayList<Integer> list3 =
                new ArrayList<Integer>();

        list3.add(100);
        list3.add(200);

        list.addAll(2, list3);

        System.out.println(list);

        System.out.println("\nget(2):");
        System.out.println(list.get(2));

        System.out.println("\nset(2, 999):");

        System.out.println("Old value: " + list.set(2, 999));

        System.out.println("Updated list:");
        System.out.println(list);

        System.out.println("\nContains 30:");
        System.out.println(list.contains(30));

        System.out.println("\nContains 500:");
        System.out.println(list.contains(500));

        ArrayList<Integer> containsList =
                new ArrayList<Integer>();

        containsList.add(30);
        containsList.add(40);

        System.out.println("\nContains all " + containsList + ":");
        System.out.println(list.containsAll(containsList));

        System.out.println("\nReversed list:");

        DoublyLinkedList<Integer> reversed =
                list.reversed();

        System.out.println(reversed);

        System.out.println("\nRemove first:");

        System.out.println(list.removeFirst());
        System.out.println(list);

        System.out.println("\nRemove last:");

        System.out.println(list.removeLast());
        System.out.println(list);

        System.out.println("\nRemove element at index 2:");

        System.out.println(list.remove(2));
        System.out.println(list);

        System.out.println("\nRemove object 30:");

        System.out.println(list.remove(Integer.valueOf(30)));
        System.out.println(list);

        ArrayList<Integer> retainList =
                new ArrayList<Integer>();

        retainList.add(20);
        retainList.add(40);
        retainList.add(60);

        System.out.println("\nBefore retainAll():");
        System.out.println(list);

        System.out.println("\nRetain only " + retainList + ":");

        System.out.println(list.retainAll(retainList));

        System.out.println(list);

        ArrayList<Integer> addList =
                new ArrayList<Integer>();

        addList.add(1000);
        addList.add(2000);
        addList.add(3000);

        System.out.println("\nAdding again using addAll():");

        list.addAll(addList);

        System.out.println(list);

        ArrayList<Integer> removeList =
                new ArrayList<Integer>();

        removeList.add(1000);
        removeList.add(2000);

        System.out.println("\nremoveAll():");

        System.out.println(list.removeAll(removeList));

        System.out.println(list);

        System.out.println("\nFinal Size:");
        System.out.println(list.size());

        System.out.println("\nFinal Is Empty:");
        System.out.println(list.isEmpty());

        System.out.println("\nClear:");

        list.clear();

        System.out.println(list);

        System.out.println("\nIs Empty after clear:");
        System.out.println(list.isEmpty());
    }
}