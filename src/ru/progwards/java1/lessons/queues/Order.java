package ru.progwards.java1.lessons.queues;

public class Order implements Comparable<Order>{
    private double sum;
    private static int num;
    private int numOrd;
    private int priority;

    //    - для номера заказа создать систему автонумерации, начиная с 1

    public Order(double sum) {
        this.sum = sum; num++;
        numOrd = num;
        if (sum > 0 & sum <= 10000) priority = 3;
        else if (sum > 10000 & sum <= 20000) priority = 2;
        else priority = 1;
    }

    public double getSum() {
        return this.sum;
    }

    public int getNum() {
        return numOrd;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sum=" + sum +
                ", num=" + numOrd +
                ", priority=" + priority +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        if (priority > o.priority) return 1;
        else if (priority < o.priority) return -1;
        else return Integer.compare(numOrd, o.numOrd);
    }
}
