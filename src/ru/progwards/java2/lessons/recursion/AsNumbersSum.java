package ru.progwards.java2.lessons.recursion;

public class AsNumbersSum {

//    который раскладывает параметр number,
//    как всевозможные уникальные комбинации сумм натуральных чисел, например:
//            5 = 4+1 = 3+2 = 3+1+1 = 2+2+1 = 2+1+1+1 = 1+1+1+1+1
//    Строка должна содержать результат, отформатированный точно, как указано в примере.
//    Повторные комбинации не допускаются, например, если а строке уже есть 3+2, то 2+3 там быть не должно.
//    Задача должна быть решена методом рекурсии, циклы использовать запрещено.
    public static String asNumbersSum(int number) {
        return number + end(number-1, 1, "");
    }
    public static String end (int n, int i, String res){
        if (n <= 0){
            return "";
        }else
            if (i > n)
                return end(n, i - n, res + n + "+") + end(n - 1, i + 1, res);
            else return " = " + res + n + "+" + i + end(i - 1, 1, res + n + "+")+ end(n - 1, i + 1, res);
    }
    public static void main(String[] args) {
        System.out.println(asNumbersSum(5));
    }
}
