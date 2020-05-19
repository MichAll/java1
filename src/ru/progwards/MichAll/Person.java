package ru.progwards.MichAll;

import java.util.Date;
import java.util.Locale;

public class Person {
    public String name;
    public Date birth;
    public double salary;

    Person(String name, Date birth, double salary) {
        this.name = name;
        this.birth = birth;
        this. salary = salary;
    }
    void printPersons(Person[] persons) {
        for (Person persona : persons){
            System.out.format(new Locale("ru"),"|%-10s|%2$td/%2$tm/%2$tY|%3$,10.2f|\n", persona.name, persona.birth, persona.salary);
        }
    }

    public static void main(String[] args) {
    }
/*
|Вася      |01/01/1970|200 000,00|
1. Разделитель значений - "|"
2. Порядок вывода значений: name, birth, salary
3. Для имени name, ширина 10 символов, прижим влево
4. Для дня рождения birth формат "дд/мм/гггг"
5. Для зарплаты salary ширина 10 точность 2, и задать разделитель тысяч, в русской раскладке
*/

//    static class Child1 {
//        public String hello() {
//            return "привет";
//        }
//    }
//    class Child2 {
//        public String hello() {
//            return "servus";
//        }
//    }
}