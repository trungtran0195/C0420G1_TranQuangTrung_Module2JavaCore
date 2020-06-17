package B6_DataStructuresAndAlgorithmBasic.BaiTap.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];

    }

    public MyList(int capacity) {
        if (capacity >= 10) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity : " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    public boolean add(E element) {
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;
        size++;
        return true;
    }

    //void add(int index,  E element)
    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) { //duyệt từ cuối mảng đến phần từ i
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }


    // void ensureCapacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("min capacity : " + minCapacity);
        }
    }


    public E get(int index) {
        return (E) elements[index];
    }

    //int indexOf(E o) - lay vi tri cua 1 phan tu trong mang
    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    //boolean contains(E o) - tim xem co phan tu do tai vi tri do khong
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    //E clone() - copy 1 array moi
    public MyList<E> clone() {
        MyList<E> copy1 = new MyList<>();
        copy1.elements = Arrays.copyOf(this.elements, this.size);
        copy1.size = this.size;
        return copy1;
    }

    //E remove (int index) - xoa 1 phan tu trong array
    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index :" + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {//chay tu index den size -1
            elements[i] = elements[i + 1];//don cac phan tu len
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}