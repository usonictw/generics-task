package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class MyList<T extends Number> implements Iterable {

    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;

    private Object[] array;

    public MyList() {
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public void add(T o) {
        resize();
        array[size] = o;
        size++;
//    throw new RuntimeException("Not implemented");
    }

    public T get(int index) {
        return (T) array[index];

        //   throw new RuntimeException("Not implemented");
    }

    private void resize() {
        int oldCapacity = array.length;
        if (size == array.length) {
            int newCapacity = oldCapacity + oldCapacity / 2;
            array = Arrays.copyOf(array, newCapacity);
        }
//    throw new RuntimeException("Not implemented");
    }

    public T remove(int index) {
        T removedElem = null;
        if (index < size && index > 0) {
            if (index == size - 1) {
                removedElem = (T) array[index];
                array[index] = null;
                size--;
                return removedElem;
            } else {
                removedElem = (T) array[index];
                for (int i = index; i < size; i++) {
                    array[i] = array[i + 1];
                }
                size--;
                return removedElem;
            }
        } else {
            throw new NullPointerException();
        }
//    throw new RuntimeException("Not implemented");
    }

    public <R extends Number> MyList<R> map(Function<T, R > f) {
        MyList<R> list = new MyList<>();

        for (int i = 0; i < size; i++) {
            list.add(f.apply((T)this.array[i]));
        }
        return list;

//        throw new RuntimeException("Not implemented");
    }

    public int size() {
        return size;
//    throw new RuntimeException("Not implemented");
    }

    @Override
    public Iterator iterator() {
        return new MyListIterator();
    }

    /**
     * <h1>Статический внутренний класс</h1>
     * <p>Может получить доступ к статическим полям и методам внешнего класса непосредственно.
     * Но, чтобы получить доступ к полям и методам экземпляра внешнего класса необходимо создать
     * экземпляр внешнего класса.
     * <p>
     * <p><h1>Нестатический внутренний класс</h1>
     * Может получить доступ к полям и методам своего внешнего класса (оба экземпляра и статическому)
     * непосредственно без конкретизации (без созания экземпляра).
     */


    private class MyListIterator implements Iterator {
        private int index = 0;
        T currentElem = get(index);

        @Override
        public boolean hasNext() {
            return currentElem != null;
        }

        @Override
        public T next() {
            if (currentElem == null) {
                throw new NoSuchElementException();
            }
            if (size > 0) {
                index++;
                return get(index - 1);
            }
            return null;
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String prefix = "";
        for (int i = 0; i < size; i++) {
            sb.append(prefix);
            prefix = ", ";
            sb.append(get(i));
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(MyList<? extends Number> list) {

        if (list == this) {
            return true;
        }

        if (list == null || list.getClass() != this.getClass()) {
            return false;
        }

        boolean equal = true;
        if (list.size() == this.size()){
            Object[] elem = array;
            Object[]elem1 = list.array;
            for (int i = 0; i < size; i++) {
                if (!Objects.equals(elem[i], elem1[i])) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    public int hashCode(){
        int result = 1;

        for (int i = 0; i < size; i++) {
            result = 31 * result + (array[i] == null ? 0 : array[i].hashCode());
        }
        return result;

    }
}
