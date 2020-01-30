package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Coder {

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {

        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            FileWriter writer = new FileWriter(outFileName);
            try {
                while (scanner.hasNextLine()) {
                    String symbol = "";
                    char[] str = scanner.nextLine().toCharArray();
                    for (int i = 0; i < str.length; i++) {
                        symbol += code[((int)str[i])];
                    }
                    writer.write(symbol);
                    writer.write("\n");
                    symbol = "";
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
        char[] codeFile = {'\65','\66','\67'};
        String logFile = "C:/csb.log";
        codeFile(inFile, outFile, codeFile, logFile);
    }

}
