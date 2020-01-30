package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.util.Scanner;

public class LineCount {

    public static int calcEmpty(String fileName) {
        int i=0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            try {
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (str.isEmpty())
                    i++;
                }
            } finally {
                reader.close();
                scanner.close();
            }
        } catch (Exception e) {
            i = -1;
        }
        return i;
    }

    public static void main(String[] args) {
        String fileName = "C:/csb.log";
        System.out.println(calcEmpty(fileName));
    }
}
