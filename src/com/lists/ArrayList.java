package com.lists;

import java.util.Iterator;
import java.util.Random;

public class ArrayList implements List {

    private int size;
    private String[] array;

    private static final int INITIAL_CAPACITY = 10;

    ArrayList() {
        this(INITIAL_CAPACITY);

    }

    ArrayList(int capacity) {
        array = new String[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public boolean contains(String element) {

        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void add(String element) {
        resize();
        array[size] = element;
        size++;

    }

    public String set(int index, String element) {
        String oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        resize();
    }

    public void remove(String element) {

    }

    public void clear() {

    }

    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public String get(int index) {

        return array[index];
    }

    public Iterator listIterator() {

        return new ListIterator();
    }

    /*public Iterator backwardIterator() {
        return null;
    }*/

    public Iterator randomIterator() {
        return new RandomIterator();
    }

    @Override
    public Iterator randomIteratorAll() {
        return new RandomIteratorAll();
    }

    private void resize() {
        if (size == array.length) {
            String[] arrayNew = new String[array.length * 2];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            array = arrayNew;
        }
        if (size < array.length / 4) {
            String[] arrayNew = new String[array.length / 2];
            for (int i = 0; i < size; i++) {
                arrayNew[i] = array[i];
            }
            array = arrayNew;
        }
    }

    private class ListIterator implements Iterator {
        private int current = 0;

        @Override
        public boolean hasNext() {
            if (current > size - 1) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            String element = array[current];
            current++;
            return element;
        }
    }

    private class RandomIterator implements Iterator {
        private int current = size;
        private String[] tempArray = new String[size];
        private int index;

        RandomIterator() {
            copyArray();
        }

        @Override
        public boolean hasNext() {
            if (current < 1) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            if (current == 0) {
                return tempArray[current + 1];
            }

            Random random = new Random();
            index = random.nextInt(current);

            String element = tempArray[index];
            removeArray(index);
            return element;
        }

        private void copyArray() {
            for (int i = 0; i < current; i++) {
                tempArray[i] = array[i];
            }
        }

        private void removeArray(int index) {
            for (int i = index; i < current - 1; i++) {
                tempArray[i] = tempArray[i + 1];
            }
            tempArray[current - 1] = null;
            current--;
        }
    }

    private class RandomIteratorAll implements Iterator {
        private int current = size, index;
        private String element;

        @Override
        public boolean hasNext() {
            if (current < 1) {
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            Random random = new Random();
            index = random.nextInt(size - 1);
            element = array[index];
            current--;
            return element;
        }
    }

}
