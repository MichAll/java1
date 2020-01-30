package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
//Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла соответствует символ code[(int)symbol] выходного файла.
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            FileWriter writer = new FileWriter(outFileName);
            try {
                String symbol = "";
                char[] str;
                while (scanner.hasNextLine()) {
                    str = scanner.nextLine().toCharArray();
                    for (int i = 0; i < str.length; i++) {
                         symbol += code[(int)str[i]];
                    }
                    writer.write(symbol);
                    symbol = "";
                    if (scanner.hasNextLine()) writer.write("\n");
                }
            } finally {
                reader.close();
                scanner.close();
                writer.close();
            }
        } catch (Exception e) {
            try {
                FileWriter logFile = new FileWriter(logName);
                try {
                    logFile.write(e.getMessage());
                } finally {
                    logFile.close();
                }
            } catch (IOException e1) {
                System.out.println(e1.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String inFile = "C:/csbin1.txt";
        String outFile = "C:/csbout.txt";
        char[] codeFile = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        String logFile = "C:/csb.log";
        codeFile(inFile, outFile, codeFile, logFile);
    }

}
