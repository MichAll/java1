package ru.progwards.java2.lessons;

public class Calc {
    String expression;
    int pos = 0;

    Calc(String expression) {
        this.expression = expression;
    }

    // scanner
    String getNext() throws Exception {
        if (pos >= expression.length())
            throw new Exception("unexpected end of expression");
        return expression.substring(pos++, pos);
    }

    String checkNext() {
        if (pos >= expression.length())
            return "";
        return expression.substring(pos, pos + 1);
    }

    boolean hasNext() {
        return pos < expression.length();
    }

    int getNumber() throws Exception {
        return Integer.parseInt(getNext());
    }

    String getOperation() throws Exception {
        return getNext();
    }

    String checkOperation() {
        return checkNext();
    }

    // expression ::= term ("+"|"-") term
    // term ::= temr2 ("*"|"/") term2
    // term :: "(" expression ")" | number

    int term2() throws Exception {
        String br = checkNext();
        if (br.equals("(")) {
            getNext();
            int res = expression();
            br = getNext();
            if (!br.equals(")"))
                throw new Exception(") expexted");
            return res;
        }
        return getNumber();
    }

    int term() throws Exception {
        int res = term2();
        while (hasNext()) {
            String op = checkOperation();
            if ("*/".contains(op)) {
                op = getOperation();
                switch (op) {
                    case "*":
                        res *= term2();
                        break;
                    case "/":
                        res /= term2();
                        break;
                    default:
                        throw new Exception("Unknown symbol " + op);
                }
            } else
                return res;
        }
        return res;
    }

    int expression() throws Exception {
        int res = term();
        while (hasNext()) {
            String op = checkOperation();
            if ("+-".contains(op)) {
                op = getOperation();
                switch (op) {
                    case "+":
                        res += term();
                        break;
                    case "-":
                        res -= term();
                        break;
                    default:
                        throw new Exception("Unknown symbol " + op);
                }
            } else
                return res;
        }
        return res;
    }

    int calculate() throws Exception {
        int res = expression();
        if (hasNext())
            throw new Exception("Extra symbols in expression");
        return res;
    }

    static int calcuate(String expression) throws Exception {
        return new Calc(expression).calculate();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Calc.calcuate("2/1+2-3*2"));
    }
}
