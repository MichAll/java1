package ru.progwards.java1.lessons.queues;

public class Calculate {

    // возвращающую результат вычисления следующей формулы:
// 2.2*(3+12.1), используя класс StackCalc
    public static double calculation1() {
        StackCalc x = new StackCalc();
        x.push(3.0);
        x.push(12.1);
        x.add();
        x.push(2.2);
        x.mul();
        return x.pop();
    }

//, возвращающую результат вычисления следующей формулы:
// (737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
//
    public static double calculation2() {
        StackCalc x = new StackCalc();
        x.push(19.0);
        x.push(3.33);
        x.sub();
        x.push(13.001);
        x.push(9.2);
        x.sub();
        x.push(2.0);
        x.mul();
        x.push(87);
        x.add();
        x.mul();
        x.push(737.22);
        x.push(24);
        x.add();
        x.push(55.6);
        x.push(12.1);
        x.sub();
        x.div();
        x.add();
        return x.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
}
