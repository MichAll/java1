package ru.progwards.java2.lessons;

import java.util.ArrayDeque;
import java.util.Deque;

public class calculator {

    public static int smash(String expression) {
        int ind1; int ind2;
        while (expression.contains("(")) {
            if (expression.indexOf("(") == 0) {
                ind2 = expression.indexOf(")");
                expression = calculate(expression.substring(1, ind2)) + expression.substring(ind2 + 1);
            } else {
                ind1 = expression.indexOf("(");
                ind2 = expression.indexOf(")");
                expression = expression.substring(0, ind1) + calculate(expression.substring(ind1 + 1, ind2)) + expression.substring(ind2 + 1);
            }
        }
        return calculate(expression);
    }

    public static int calculate(String str) {
        System.out.println(str);
        Deque<Integer> x = new ArrayDeque<>();
        String simb;
        int result = 0;
        int num;
        x.push(Integer.parseInt(str.substring(0, 1)));
        for (int i = 1; i < str.length(); i += 2) {
            simb = str.substring(i, i + 1);
            if (str.substring(i + 1, i + 2).equals("-")) {
                num = -Integer.parseInt(str.substring(i + 2, i + 3));
                i++;
            }else
                num = Integer.parseInt(str.substring(i + 1, i + 2));
            if (simb.equals("-")) {
                x.push(-num);
            }
            if (simb.equals("*")) {
                x.push(x.pop() * num);
            }
            if (simb.equals("/")) {
                x.push(x.pop() / num);
            }
            if (simb.equals("+")) {
                x.push(num);
            }
        }
        while (!x.isEmpty())
            result += x.pop();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(smash("2+3*2"));
        System.out.println(smash("2+3*(2-8)/4*(5+1)-7"));
    }
}
