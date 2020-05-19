package ru.progwards.java2.lessons.recursion;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Goods {

    String name;
    String number;
    int available;
    double price;
    Instant expired;

    public Goods(String name, String number, int available, double price, Instant expired) {
        this.name = name;
        this.number = number;
        this.available = available;
        this.price = price;
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name +
                ", number='" + number +
                ", available=" + available +
                ", price=" + price +
                ", expired=" + expired +
                '}';
    }
}
public class GoodsWithLambda {
    List<Goods> goods;
    GoodsWithLambda (List<Goods> list) {
        goods = list;
    }
    void setGoods(List<Goods> list){
        goods = list;
    }
    // вернуть список, отсортированный по наименованию
    List<Goods> sortByName(){
        goods.sort(Comparator.comparing(a -> a.name));
        return goods;
    }
    // вернуть список, отсортированный по артикулу, без учета регистра
    List<Goods> sortByNumber(){
        goods.sort(Comparator.comparing(a -> a.number));
        return goods;
    }
    // вернуть список, отсортированный по первым 3-м символам артикула, без учета регистра
    List<Goods> sortByPartNumber(){
        goods.sort(Comparator.comparing(a -> a.number.substring(0, 3)));
        return goods;
    }
    // вернуть список, отсортированный по количеству, а для одинакового количества, по артикулу, без учета регистра
    List<Goods> sortByAvailabilityAndNumber() {
        goods.sort(Comparator.comparing(a -> a.number));
        goods.sort(Comparator.comparing(a -> a.available));
        return goods;
    }
    // вернуть список, с товаром, который будет просрочен после указанной даты, отсортированный по дате годности
    List<Goods> expiredAfter(Instant date){
        return goods.stream().filter(a -> date.isBefore(a.expired)).collect(Collectors.toList());
    }
    // вернуть список, с товаром, количество на складе которого меньше указанного
    List<Goods> сountLess(int count){
        return goods.stream().filter(a -> count > a.available).collect(Collectors.toList());
    }
    // вернуть список, с товаром, количество на складе которого больше count1 и меньше count2
    List<Goods> сountBetween(int count1, int count2){
        return this.goods.stream().filter(a -> count1 < a.available && count2 > a.available).collect(Collectors.toList());
    }
    public static void main(String[] args) {
    }
}
