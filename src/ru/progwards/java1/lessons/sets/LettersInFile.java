package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class LettersInFile {
//    Реализовать класс, считывающий содержимое файла и возвращающего набор букв,
//    которые встречались в этом файле.
//    Буквы, это латинские [A..Z[ и [a..z] и русские [А..Я] и [а..я], остальные символы надо игнорировать

    // - вернуть все буквы, которые встретились в файле, сконкатенированные в виде строки.
// Буквы должны быть упорядочены по алфавиту, типа “ADEF...”.
// Все возникающие исключения, по работе с потоками, пробросить выше.
    public static String process(String fileName) throws Exception {
        String strOut = "";
        try (FileReader fileRead = new FileReader(fileName)) {
            try (Scanner scanner = new Scanner(fileRead)) {
                TreeSet<Character> treeStr = new TreeSet<>();
                while (scanner.hasNextLine()) {
                    char[] symb = scanner.nextLine().toCharArray();
                    for (char x : symb) {
                        if (Character.isLetter(x))
                            treeStr.add(x);
                    }
                }
                //strOut = treeStr.toString().replace(", ", "");
                for (Character xyz : treeStr)
                    strOut += xyz;
            }
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
        return strOut;
    }

    public static void main(String[] args) {
        try {
            System.out.println(process("d:/JavaPackage/TEST.txt"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
