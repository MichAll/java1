package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

// Сделать итератор MatrixIterator по двумерному массиву (матрице),
// который разворачивает матрицу в линейную последовательность построчно:
// a[0][0], a[0][1], ...a[0][N],a[1][0], a[1][1]...a[1][N]... a[M][N]
// Шаблон для итератора взять от ArrayIterator
public class MatrixIterator <T> implements Iterator<T> {

    private T[][] array;
    private int ind1 = 0;
    private int ind2 = 0;

    MatrixIterator (T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (ind2 >= array[ind1].length) {
            ind1++;
            ind2 = 0;
        }
        if (ind1 >= array.length) {
            return false;
        }
        return (ind2) < array[ind1].length;
    }

    @Override
    public T next() {
        return array[ind1][ind2] != null ? array[ind1][ind2++] : null;
    }

    public static void main(String[] args) {
        Integer[][] newArray = {{0, 11, 1, 3, 4, 10, 7, 1}, {1, 3, 5, 7}};
        MatrixIterator<Integer> iterator = new MatrixIterator(newArray);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

