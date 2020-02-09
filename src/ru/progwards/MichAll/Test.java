package ru.progwards.MichAll;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    //    static double fractional(double num) {
//        int int1 = (int)num;
//        double double1 = num - int1;
//        return (double1);
//    }
//    static int addAsStrings(int n1, int n2) {
//        String str1 = Integer.toString(n1);
//        String str2 = Integer.toString(n2);
//        String str3 = str1+str2;
//        int n3 = Integer.parseInt(str3);
//        return n3;
//    }
//    static long factorial(long n) {
//        long startSum = 1;
//        for (long i=1; i<n; i++) {
//            startSum += startSum * i;
//         }
//        return (startSum);
//    }
//    public int sumArrayItems(int[] a) {
//        int sumA = 0;
//        for (int i=0; i < a.length; i++)
//            sumA = sumA + a[i];
//
//        return sumA;
//    }
    public Integer sqr(Integer n) {
        Integer sqrN = 0;
        try {
            sqrN = n * n;
        } catch (NullPointerException e) {
            return -1;
        }
        return sqrN;
    }

    public String test(String filename)  throws IOException {
        try {
            filename.toString();
            return "File processing";
        } catch (Exception e) {
            throw new IOException("File not found");
        }
    }

    private int lineCount(String filename) throws IOException {
        int i=0;
        try {
            FileReader reader = new FileReader(filename);
            Scanner scanner = new Scanner(reader);
            try {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    i += 1;
                }
            } finally {
                reader.close();
                scanner.close();
            }
        } catch (IOException e) {
            throw new IOException("файл не найден");
        }
        return i;
    }

//    public void test(int n) throws IOException{
//        try {
//            doSomething(n);
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            throw new IOException(e);
//        } finally {
//            System.out.println("finally executed");
//        }
//    }

    public static void main(String[] args) {

//        double num = 1.53;
//        System.out.println(fractional(num));
//        System.out.println(addAsStrings(2,1));
//        System.out.println(factorial(0));
    }
 }
