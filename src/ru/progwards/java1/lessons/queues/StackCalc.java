package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCalc {
//    который содержит стек чисел с плавающей точкой (double).
//    Выбрать наиболее удобную для этого коллекцию.
//    Реализовать методы работы со стеком:
    Deque<Double> stack = new ArrayDeque<>();
    // положить value на вершину стека
    public void push(double value) {
        stack.push(value);
    }

    // - взять (убрать) значение с вершины стека
    public double pop() {
        return stack.pop();
    }
 // сложить 2 верхних значения на стеке, результат положить на стек.
// В итогу в стеке должно быть на один элемент меньше
    public void add() {
        Double newStack = stack.pop()+stack.pop();
        stack.push(newStack);
    }

// вычесть верхнее значение на стеке, из следующего по глубине, результат положить на стек.
// В итоге в стеке должно быть на один элемент меньше
    public void sub() {
        Double newStack1 = stack.pop();
        Double newStack = stack.pop()-newStack1;
        stack.push(newStack);
    }

// умножить 2 верхних значения на стеке, результат положить на стек.
// В итогу в стеке должно быть на один элемент меньше
    public void mul() {
        Double newStack = stack.pop()*stack.pop();
        stack.push(newStack);
    }

// поделить на верхнее значение на стеке, следующее по глубине, результат положить на стек.
// В итоге в стеке должно быть на один элемент меньше
    public void div() {
        Double newStack1 = stack.pop();
        Double newStack = stack.pop()/newStack1;
        stack.push(newStack);
    }

    public static void main(String[] args) {
        StackCalc newCalc = new StackCalc();
        newCalc.push(123.00);
        newCalc.push(25.50);
        newCalc.push(83.05);
        newCalc.push(40.00);
        newCalc.div();
        System.out.println(newCalc.pop());
    }
}