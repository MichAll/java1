package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {

    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        try {
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            FileWriter writer = new FileWriter(outFileName);
            try {
                while (scanner.hasNextLine()) {
                    String symbol = "";
                    char[] str = scanner.nextLine().toCharArray();
                    for (int i = 0; i < str.length; i++) {
                        if (filter.indexOf(str[i]) == -1)
                            symbol += str[i];
                        else symbol += "";
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
        } catch (IOException e) {
            throw new IOException("файл не найден");
        }
    }

    public static void main(String[] args) throws IOException {
        String inFile = "C:/csbin.txt";
        String outFile = "C:/csbout.txt";
        String strFilter = "=[.";
        filterFile(inFile, outFile, strFilter);
    }
}
