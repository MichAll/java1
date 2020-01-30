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
                    String sym1 ="";
                    char[] str = scanner.nextLine().toCharArray();
                    char[] str1 = filter.toCharArray();
                    for (int i = 0; i < str.length; i++) {
                        sym1 = String.valueOf(str[i]);
                        for (int j = 0; j < str1.length; j++) {
                            if (str[i] == str1[j]) {
                                sym1 = "";
                                break;
                            }
                        }
                        symbol+=sym1;
                    }
                    writer.write(symbol);
                    if (scanner.hasNextLine())
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
        String obscene = "— -,.()";
        filterFile(inFile, outFile, obscene);
    }
}
