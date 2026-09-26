


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomArrayList<E> implements Iterable<E> {

    private Object[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    // 1. Default Constructor
    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // 2. Constructor with Initial Capacity
    public CustomArrayList(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException(
                "Illegal Capacity: " + capacity
            );
        }

        elements = new Object[capacity];
    }

    // 3. Constructor with Collection
    public CustomArrayList(Collection<? extends E> collection) {

        elements = collection.toArray();

        size = elements.length;

        if (elements.length == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        }
    }

    // 4. Add Element
    public boolean add(E element) {

        ensureCapacity(size + 1);

        elements[size] = element;

        size++;

        return true;
    }

    // 5. Add Element at Specific Index
    public void add(int index, E element) {

        checkPositionIndex(index);

        ensureCapacity(size + 1);

        System.arraycopy(
            elements,
            index,
            elements,
            index + 1,
            size - index
        );

        elements[index] = element;

        size++;
    }

    // 6. Add All Elements
    public boolean addAll(Collection<? extends E> collection) {

        Object[] newElements = collection.toArray();

        int newSize = newElements.length;

        if (newSize == 0) {
            return false;
        }

        ensureCapacity(size + newSize);

        System.arraycopy(
            newElements,
            0,
            elements,
            size,
            newSize
        );

        size += newSize;

        return true;
    }

    // 7. Add All Elements at Index
    public boolean addAll(
            int index,
            Collection<? extends E> collection) {

        checkPositionIndex(index);

        Object[] newElements = collection.toArray();

        int newSize = newElements.length;

        if (newSize == 0) {
            return false;
        }

        ensureCapacity(size + newSize);

        System.arraycopy(
            elements,
            index,
            elements,
            index + newSize,
            size - index
        );

        System.arraycopy(
            newElements,
            0,
            elements,
            index,
            newSize
        );

        size += newSize;

        return true;
    }

    // 8. Get Element
    @SuppressWarnings("unchecked")
    public E get(int index) {

        checkElementIndex(index);

        return (E) elements[index];
    }

    // 9. Set Element
    public E set(int index, E element) {

        checkElementIndex(index);

        @SuppressWarnings("unchecked")
        E oldElement = (E) elements[index];

        elements[index] = element;

        return oldElement;
    }

    // 10. Remove Element by Index
    public E remove(int index) {

        checkElementIndex(index);

        @SuppressWarnings("unchecked")
        E removedElement = (E) elements[index];

        int numberOfElements =
                size - index - 1;

        if (numberOfElements > 0) {

            System.arraycopy(
                elements,
                index + 1,
                elements,
                index,
                numberOfElements
            );
        }

        elements[--size] = null;

        return removedElement;
    }

    // 11. Remove Element by Object
    public boolean remove(Object object) {

        int index = indexOf(object);

        if (index >= 0) {

            remove(index);

            return true;
        }

        return false;
    }

    // 12. Remove All Elements
    public void clear() {

        Arrays.fill(elements, 0, size, null);

        size = 0;
    }

    // 13. Contains Element
    public boolean contains(Object object) {

        return indexOf(object) >= 0;
    }

    // 14. Index Of Element
    public int indexOf(Object object) {

        if (object == null) {

            for (int i = 0; i < size; i++) {

                if (elements[i] == null) {
                    return i;
                }
            }

        } else {

            for (int i = 0; i < size; i++) {

                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    // 15. Last Index Of Element
    public int lastIndexOf(Object object) {

        if (object == null) {

            for (int i = size - 1; i >= 0; i--) {

                if (elements[i] == null) {
                    return i;
                }
            }

        } else {

            for (int i = size - 1; i >= 0; i--) {

                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    // 16. Check Empty
    public boolean isEmpty() {

        return size == 0;
    }

    // 17. Get Size
    public int size() {

        return size;
    }

    // 18. Get Array
    public Object[] toArray() {

        return Arrays.copyOf(elements, size);
    }

    // 19. Generic Array Conversion
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] array) {

        if (array.length < size) {

            return (T[]) Arrays.copyOf(
                elements,
                size,
                array.getClass()
            );
        }

        System.arraycopy(
            elements,
            0,
            array,
            0,
            size
        );

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    // 20. Ensure Capacity
    private void ensureCapacity(int minimumCapacity) {

        if (minimumCapacity > elements.length) {

            int newCapacity =
                    elements.length
                    + (elements.length / 2);

            if (newCapacity < minimumCapacity) {
                newCapacity = minimumCapacity;
            }

            if (newCapacity == 0) {
                newCapacity = DEFAULT_CAPACITY;
            }

            elements = Arrays.copyOf(
                elements,
                newCapacity
            );
        }
    }

    // 21. Trim To Size
    public void trimToSize() {

        if (size < elements.length) {

            elements = Arrays.copyOf(
                elements,
                size
            );
        }
    }

    // 22. Capacity
    public int capacity() {

        return elements.length;
    }

    // 23. Contains All
    public boolean containsAll(
            Collection<?> collection) {

        for (Object object : collection) {

            if (!contains(object)) {
                return false;
            }
        }

        return true;
    }

    // 24. Remove All Matching Elements
    public boolean removeAll(
            Collection<?> collection) {

        Objects.requireNonNull(collection);

        boolean modified = false;

        for (int i = size - 1; i >= 0; i--) {

            if (collection.contains(elements[i])) {

                remove(i);

                modified = true;
            }
        }

        return modified;
    }

    // 25. Retain Only Matching Elements
    public boolean retainAll(
            Collection<?> collection) {

        Objects.requireNonNull(collection);

        boolean modified = false;

        for (int i = size - 1; i >= 0; i--) {

            if (!collection.contains(elements[i])) {

                remove(i);

                modified = true;
            }
        }

        return modified;
    }

    // 26. Iterator
    @Override
    public Iterator<E> iterator() {

        return new Iterator<E>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {

                return cursor < size;
            }

            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return get(cursor++);
            }

            @Override
            public void remove() {

                if (cursor == 0) {
                    throw new IllegalStateException();
                }

                CustomArrayList.this.remove(--cursor);
            }
        };
    }

    // 27. To String
    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {

            result.append(elements[i]);

            if (i < size - 1) {
                result.append(", ");
            }
        }

        result.append("]");

        return result.toString();
    }

    // 28. Check Element Index
    private void checkElementIndex(int index) {

        if (index < 0 || index >= size) {

            throw new IndexOutOfBoundsException(
                "Index: " + index
                + ", Size: " + size
            );
        }
    }

    // 29. Check Position Index
    private void checkPositionIndex(int index) {

        if (index < 0 || index > size) {

            throw new IndexOutOfBoundsException(
                "Index: " + index
                + ", Size: " + size
            );
        }
    }

    // 30. Main Method
    public static void main(String[] args) {

        CustomArrayList<Integer> list =
                new CustomArrayList<>();

        // Add
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("List: " + list);

        // Add at Index
        list.add(1, 15);

        System.out.println("After Add: " + list);

        // Get
        System.out.println("Get Index 2: " + list.get(2));

        // Set
        list.set(2, 25);

        System.out.println("After Set: " + list);

        // Contains
        System.out.println("Contains 20: " + list.contains(20));

        // Index Of
        System.out.println("Index Of 20: " + list.indexOf(20));

        // Size
        System.out.println("Size: " + list.size());

        // Remove By Index
        list.remove(1);

        System.out.println("After Remove Index: " + list);

        // Remove By Object
        list.remove(Integer.valueOf(30));

        System.out.println("After Remove Object: " + list);

        // Add All
        list.addAll(Arrays.asList(40, 50, 60));

        System.out.println("After Add All: " + list);

        // Iterator
        System.out.print("Using Iterator: ");

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {

            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        // Is Empty
        System.out.println("Is Empty: " + list.isEmpty());

        // Capacity
        System.out.println("Capacity: " + list.capacity());

        // Trim To Size
        list.trimToSize();

        System.out.println("After Trim Capacity: " + list.capacity());

        // Clear
        list.clear();

        System.out.println("After Clear: " + list);

        System.out.println("Is Empty: " + list.isEmpty());
    }
}