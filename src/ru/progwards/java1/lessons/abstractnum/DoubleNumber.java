package ru.progwards.java1.lessons.abstractnum;

public class DoubleNumber extends Number{
    private Double value;
    public DoubleNumber(Double number) {
        value = number;
    }
    @Override
    public Number mul(Number n) {
        if (n.getClass()==DoubleNumber.class)
            return new DoubleNumber(value*((DoubleNumber)n).value);
        else
            return null;
    }
    public Number div(Number n) {
        return new DoubleNumber(value/((DoubleNumber)n).value);
    }
    public Number newNumber(String strNum) {
        return new DoubleNumber(Double.parseDouble(strNum));
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
    @Override
    public boolean equals (Object obj){
        if (obj.getClass()==DoubleNumber.class)
            return false;
        else
            return ((DoubleNumber)obj).value == value;
    }
}
