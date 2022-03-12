package ru.didyk.list;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class MyVersionOfList<E> implements List<E> {

    private Object[] array = new Object[0];
    private int size;

    @Override
    public String toString() {
    //TODO: выводит null'ы
        return Arrays.toString(array);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E e) {
        if (array.length == size) {
            array = Arrays.copyOf(array, Math.max((int) (array.length * 1.5), 5));
        }
        array[size] = e;
        size++;
        return true;
    }

    @Override
    public void clear() {
        array = new Object[0];
        size = 0;
    }

    @Override
    public E get(int index) {
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        E e = (E) array[index];
        array[index] = element;
        return e;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], o))
                return true;
        }
        return false;
    }

    @Override
    public void add(int index, E element) {
        if (array.length == size) {
            array = Arrays.copyOf(array, Math.max((int) (array.length * 1.5), 5));
        }
        if (size == 0 && index > 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = element;
    }

    @Override
    public E remove(int index) {
        Object[] array1 = Arrays.copyOf(array, array.length - 1);
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (i == index) {
                count++;
            }
            array1[i] = array[count];
            count++;
        }
        array = array1;
        size--;
        return (E) array[index - 1];
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //TODO: разобраться с условиями if
        if(array.length <= (c.size() + size)) {
            Object[] newArray = Arrays.copyOf(array, c.size() + array.length);
            int count = 0;
            for (int i = array.length; i < newArray.length; i++) {
                newArray[i] = c.toArray()[count];
                count++;
            }
            array = newArray;
            size += c.size();
        } else {
            int count = 0;
            for (int i = size; i < array.length; i++) {
                array[size] = c.toArray()[count];
                count++;
                size++;
            }
        }
        return true;
    }

    //__________________________________________

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
