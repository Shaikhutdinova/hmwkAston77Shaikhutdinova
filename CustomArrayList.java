package main.java;

import java.io.Serializable;
import java.util.*;

public class CustomArrayList<E extends Comparable<E>> implements Cloneable, Serializable {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elementData;

    public CustomArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public CustomArrayList(Collection<? extends E> c) {
        Object[] temp = c.toArray();
        if ((size = temp.length) != 0) {
            elementData = Arrays.copyOf(temp, size, Object[].class);
        } else {
            elementData = new Object[]{};
        }
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = elementData.length - 1; i >= 0; i--) {
            elementData[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    public int indexOfRange(Object o, int start, int end) {
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    public void add(int index, E element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elementData.length) {
            grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, (size - index));
        elementData[index] = element;
        size++;
    }

    public boolean add(E element) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = element;
        size++;
        return true;
    }

    private Object[] grow() {
        return elementData = grow(size);
    }

    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        Object[] a = c.toArray();
        if (a.length > (elementData.length - size)) {
            elementData = grow(size + a.length);
        }
        System.arraycopy(a, 0, elementData, size, a.length);
        size += a.length;
        return true;
    }

    public Object[] grow(int minCapacity) {
        if (elementData != null || elementData.length > 0) {
            int newDefaultCapacity = elementData.length * 3 / 2 + 1;
            int newCapacity = newDefaultCapacity >= minCapacity ? newDefaultCapacity : minCapacity;
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    public E remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E removeValue = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, (size - index - 1));
        elementData[size - 1] = null;
        size--;
        return removeValue;
    }

    public boolean remove(Object o) {
        if (elementData == null || elementData.length < 1 || o == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        Quicksort<E> quicksort = new Quicksort<>();
        quicksort.sort(elementData, 0, size - 1, c);
    }
}
