package ru.progwards.java1.lessons.queues;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
   PriorityQueue<Order> priQueue = new PriorityQueue<>();
// размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
// 3 - заказы до 10000 руб включительно
// 2 - заказы от 10000 до 20000 руб включительно
// 1 - заказы от 20000 руб

    public void add(Order order) {
        priQueue.offer(order);
    }

// возвращающий первый заказ в очереди для обслуживания.
// Вначале обслуживаются заказы класса 1, потом 2, потом 3.
// Внутри каждого класса заказы должны обслуживаться в порядке поступления (по номеру заказа).
// Метод не выбрасывает исключения, возвращает null в случае пустой очереди.
    public Order get() {
        //System.out.println(priQueue.peek());
        return priQueue.poll();
    }

// Продумать, и, при необходимости, добавить в классы нужные методы и свойства, для того, чтобы реализовать эту задачу.
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();

        orderQueue.add(new Order(26230.0));
        orderQueue.add(new Order(8650.0));
        orderQueue.add(new Order(2919.0));
        orderQueue.add(new Order(12689.0));
        orderQueue.add(new Order(21716.0));
        orderQueue.add(new Order(5690.0));
        orderQueue.add(new Order(18808.0));
        orderQueue.add(new Order(8373.0));
        orderQueue.add(new Order(12205.0));
        orderQueue.add(new Order(3153.0));
        orderQueue.add(new Order(24861.0));
        for (int i = 1; i < 12 ; i++) {
            System.out.println(orderQueue.get());
        }

    }
}
