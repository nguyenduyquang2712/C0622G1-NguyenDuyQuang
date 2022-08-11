package ss10_dsa_list.exercises.model;

import java.util.Arrays;

public class Mylist<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public Mylist() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Mylist(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapacity() {
        if (size > elements.length) {
            int biggerSize = size * 2 + 1;
            elements = Arrays.copyOf(elements, biggerSize);
        }
    }

    public void add(E e) {
        size += 1;
        ensureCapacity();
        elements[size - 1] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
    public int getSize(){
        return size;
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public boolean contains(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) {
                return true;}
        return false;
    }
    public void add(int index, E e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = e;
        size++;
    }
    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException ("index " + index + " out of bounds");}
        E e = (E) elements[index];

        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return e;
    }

    public Mylist<E> clone() {
       Mylist<E> y = new Mylist<>();
        y.elements = Arrays.copyOf(elements, size);
        y.size = this.size;
        return y;
    }

    @Override
    public String toString() {
        return "Mylist{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

}
