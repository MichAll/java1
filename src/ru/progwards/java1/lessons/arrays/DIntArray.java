package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {

    private int[] intArray;

//    public DIntArray() {
//        intArray = new int [0];
//    }
     // 3.2 метод - добавляет элемент num в конец массива,
// при этом размер массива должен увеличиться на 1.
    public void add(int num) {
        int[] newArray = Arrays.copyOf(intArray, intArray.length + 1);
        newArray[intArray.length] = num;
        intArray = Arrays.copyOf(newArray, newArray.length);
        System.out.println(Arrays.toString(intArray));

//        int[] newArray = new int[intArray.length + 1];
//        System.arraycopy(intArray, 0, newArray, 0, intArray.length);
//        newArray[newArray.length-1] = num;
    }
    // 3.3 метод  - добавляет элемент num в позицию pos массива,
// при этом размер массива должен увеличиться на 1.
// окажется где-то в середине, и потом положить в нужный индекс элемент num.
    public void atInsert(int pos, int num) {
        if (pos<=intArray.length) {
            int[] newArray = new int[intArray.length + 1];
            System.arraycopy(intArray, 0, newArray, 0, intArray.length);
            newArray[pos] = num;
            System.arraycopy(intArray, pos, newArray, pos + 1, intArray.length - pos);
        }
    }
    // 3.4 метод  - удаляет элемент в позиции pos массива,
// при этом размер массива должен уменьшиться на 1.
    public void atDelete(int pos) {
        if (pos<=intArray.length-1) {
            int[] newArray = new int[intArray.length - 1];
            System.arraycopy(intArray, 0, newArray, 0, intArray.length - 1);
            System.arraycopy(intArray, pos + 1, newArray, pos, intArray.length - pos - 1);
        }
    }
    // 3.5 метод - возвращает элемент по индексу pos.
    public int at(int pos) {
        return intArray[pos];
    }

    public static void main(String[] args) {
        DIntArray arrayNew = new DIntArray();
        arrayNew.intArray = new int[]{1, 2, 3, 4, 5};
        arrayNew.add(-7);
        arrayNew.atInsert(1, 3);
        arrayNew.atDelete(9);
        System.out.println(arrayNew.at(4));
    }
}
