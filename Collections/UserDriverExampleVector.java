class UserVector<E> {

    private E[] arr;
    private int indx;
    private boolean flag;
    private int increCap;


    // Default constructor
    public UserVector() {
        arr = (E[]) new Object[10];
    }


    // Parameterized constructor
    public UserVector(int newCapacity) {
        this(newCapacity, 0);
    }


    // Parameterized constructor with increment capacity
    public UserVector(int newCapacity, int increCap) {
        this.flag = true;
        this.increCap = increCap;
        arr = (E[]) new Object[newCapacity];
    }


    // 1. trimToSize()
    public void trimToSize() {

        if (size() < arr.length) {

            E[] newArr = (E[]) new Object[size()];

            for (int i = 0; i < size(); i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }
    }


    // 2. ensureCapacity()
    public void ensureCapacity(int minCapacity) {

        if (minCapacity > arr.length) {

            int newCap;

            if (flag) {
                newCap = Math.max(minCapacity, arr.length + increCap);
            } 
            else {
                newCap = Math.max(minCapacity, arr.length * 2);
            }

            // Handles case when capacity is 0
            if (newCap == 0) {
                newCap = minCapacity;
            }

            E[] newArr = (E[]) new Object[newCap];

            for (int i = 0; i < size(); i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
        }
    }


    // 3. capacity()
    public int capacity() {
        return arr.length;
    }


    // 4. size()
    public int size() {
        return indx;
    }


    // 5. isEmpty()
    public boolean isEmpty() {
        return size() == 0;
    }


    // 6. contains()
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }


    // 7. indexOf()
    public int indexOf(Object obj) {

        for (int i = 0; i < size(); i++) {

            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            }
            else if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }


    // 8. lastIndexOf()
    public int lastIndexOf(Object obj) {

        for (int i = size() - 1; i >= 0; i--) {

            if (obj == null) {
                if (arr[i] == null) {
                    return i;
                }
            }
            else if (obj.equals(arr[i])) {
                return i;
            }
        }

        return -1;
    }


    // 9. elementAt(int index)
    public E elementAt(int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return arr[index];
    }


    // 10. firstElement()
    public E firstElement() {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[0];
    }


    // 11. lastElement()
    public E lastElement() {

        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return arr[size() - 1];
    }


    // 12. setElementAt()
    public void setElementAt(E obj, int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        arr[index] = obj;
    }


    // 13. removeElementAt()
    public void removeElementAt(int index) {

        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // Shift elements to left
        for (int i = index; i < size() - 1; i++) {
            arr[i] = arr[i + 1];
        }

        // Remove duplicate reference
        arr[size() - 1] = null;

        indx--;
    }


    // 14. insertElementAt()
    public void insertElementAt(E obj, int index) {

        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        // Increase capacity if required
        if (size() == capacity()) {
            ensureCapacity(size() + 1);
        }

        // Shift elements to right
        for (int i = size(); i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = obj;
        indx++;
    }


    // 15. addElement()
    public void addElement(E obj) {

        if (size() == capacity()) {
            ensureCapacity(size() + 1);
        }

        arr[indx++] = obj;
    }


    // 16. removeElement()
    public boolean removeElement(Object obj) {

        int index = indexOf(obj);

        if (index >= 0) {
            removeElementAt(index);
            return true;
        }

        return false;
    }


    // toString()
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
class UserDriverExampleVector {

    public static void main(String[] args) {

        UserVector<Integer> list =
                new UserVector<Integer>(5, 5);

        // addElement()
        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.addElement(20);

        System.out.println("List : " + list);
        System.out.println("Capacity : " + list.capacity());
        System.out.println("Size : " + list.size());


        // 1. trimToSize()
        list.trimToSize();
        System.out.println("After trimToSize : " + list);
        System.out.println("Capacity : " + list.capacity());


        // 2. ensureCapacity()
        list.ensureCapacity(10);
        System.out.println("After ensureCapacity(10)");
        System.out.println("Capacity : " + list.capacity());


        // 3. capacity()
        System.out.println("Capacity : " + list.capacity());


        // 4. size()
        System.out.println("Size : " + list.size());


        // 5. isEmpty()
        System.out.println("Is Empty : " + list.isEmpty());


        // 6. contains()
        System.out.println("Contains 20 : " + list.contains(20));


        // 7. indexOf()
        System.out.println("Index of 20 : " + list.indexOf(20));


        // 8. lastIndexOf()
        System.out.println(
                "Last index of 20 : " + list.lastIndexOf(20));


        // 9. elementAt()
        System.out.println(
                "Element at index 1 : " + list.elementAt(1));


        // 10. firstElement()
        System.out.println(
                "First Element : " + list.firstElement());


        // 11. lastElement()
        System.out.println(
                "Last Element : " + list.lastElement());


        // 12. setElementAt()
        list.setElementAt(50, 1);
        System.out.println("After setElementAt : " + list);


        // 13. removeElementAt()
        list.removeElementAt(1);
        System.out.println("After removeElementAt : " + list);


        // 14. insertElementAt()
        list.insertElementAt(100, 1);
        System.out.println("After insertElementAt : " + list);


        // 15. addElement()
        list.addElement(200);
        System.out.println("After addElement : " + list);


        // 16. removeElement()
        list.removeElement(30);
        System.out.println("After removeElement(30) : " + list);
    }
}