package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    @Override
    public String toString(){
        return null;
    }
    public int perMen() {
        return Integer.parseInt(null);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        int summa = num1.perMen() + num2.perMen();
        if (summa>=Byte.MIN_VALUE & summa<=Byte.MAX_VALUE)
            return new ByteInteger((byte)summa);
        else if (summa>=Short.MIN_VALUE & summa<=Short.MAX_VALUE)
            return new ShortInteger((short)summa);
        return new IntInteger(summa);
    }

    public static void main(String[] args) {
        AbsInteger num1 = new IntInteger( 128);
//        AbsInteger num1 = new ByteInteger((byte) 127);
        AbsInteger num2 = new ShortInteger((short) 32767);
        System.out.println(add(num1, num2));
    }
}
