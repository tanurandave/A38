

class UserEmtyStackException extends RuntimeException {
    UserEmtyStackException() {
        super();
    }
}

class UserVector<E> {
    private E[] arr;
    private int indx;

    public UserVector() {
        arr = (E[]) new Object[10];
    }

    public int size() {
        return indx;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int capacity() {
        return arr.length;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > arr.length) {
            int newCapacity = arr.length * 2;

            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            E[] newArr = (E[]) new Object[newCapacity];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }
    }

    public void addElement(E obj) {
        if (size() == capacity()) {
            ensureCapacity(size() + 1);
        }

        arr[indx++] = obj;
    }

    public E removeElementAt(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        E obj = arr[index];

        for (int i = index; i < size() - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[--indx] = null;

        return obj;
    }

    public boolean removeElement(Object obj) {
        int index = indexOf(obj);

        if (index >= 0) {
            removeElementAt(index);
            return true;
        }

        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size(); i++) {
            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            } else if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }

    public E elementAt(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return arr[index];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        String op = "[";

        for (int i = 0; i < size() - 1; i++) {
            op += arr[i] + ", ";
        }

        op += arr[size() - 1] + "]";

        return op;
    }
}

class UserStack<E> {

    private UserVector<E> vector;

    public UserStack() {
        vector = new UserVector<E>();
    }

    public E push(E obj) {
        vector.addElement(obj);
        return obj;
    }

    public E pop() {
        if (empty()) {
            throw new UserEmtyStackException();
        }

        return vector.removeElementAt(vector.size() - 1);
    }

    public E peek() {
        if (empty()) {
            throw new UserEmtyStackException();
        }

        return vector.elementAt(vector.size() - 1);
    }

    public boolean empty() {
        return vector.isEmpty();
    }

    public int search(Object obj) {
        int position = 1;

        for (int i = vector.size() - 1; i >= 0; i--) {

            E element = vector.elementAt(i);

            if (obj == null) {
                if (element == null) {
                    return position;
                }
            } else if (obj.equals(element)) {
                return position;
            }

            position++;
        }

        return -1;
    }

    @Override
    public String toString() {
        return vector.toString();
    }
}

public class DriverExampleStack {

    public static void main(String[] args) {

        UserStack<Integer> stack = new UserStack<Integer>();

        System.out.println("Initial Stack: " + stack);

        System.out.println("Push: " + stack.push(10));
        System.out.println("Push: " + stack.push(20));
        System.out.println("Push: " + stack.push(30));
        System.out.println("Push: " + stack.push(40));

        System.out.println("Stack: " + stack);

        System.out.println("Peek: " + stack.peek());

        System.out.println("Search 30: " + stack.search(30));
        System.out.println("Search 10: " + stack.search(10));
        System.out.println("Search 50: " + stack.search(50));

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Stack after pop: " + stack);

        System.out.println("Is Empty: " + stack.empty());

        System.out.println("Peek: " + stack.peek());
    }
}