package ru.progwards.MichAll;

import java.io.IOException;
import java.util.Scanner;
import java.io.RandomAccessFile;

public class IO {
    public void scanLines() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String nwLine = scanner.nextLine();
                if (nwLine.contains("/stop"))
                break;
                else if (nwLine.contains("Привет"))
                System.out.println("Здравствуйте!");
                else if (nwLine.contains("как дела"))
                System.out.println("Хорошо");
                else
                    System.out.println(nwLine);
            }
        }
    }

    public String invertWords(String sentence) {
        String [] resWords = sentence.split(" ");
        String result ="";
        for (int i=0; i<resWords.length; i++){
            result = resWords[i]+" "+result;
        }
        result = result.trim();
        result = result.replace(" ",".");
        return result;
    }

    public String setStars(String filename) {
        String strOut = "";
        try (RandomAccessFile strFile = new RandomAccessFile(filename,"rw")) {
            if(strFile.length()>10){
                for (int i = 9; i < strFile.length(); i = i + 10) {
                    strFile.seek(i);
                    strOut = strOut + (char)strFile.read();
                    strFile.seek(i);
                    strFile.writeByte((int)'*');
                }
            }
        } catch (IOException e) {
            new IOException(e.getMessage());
        }
        return strOut;
    }

    public static void main(String[] args) {
        IO nw = new IO();
        //nw.scanLines();
        //System.out.println(nw.invertWords("Буря мглою небо кроет"));
        String str = "d:/JavaPackage/ТЦ.txt";
        System.out.println(nw.setStars(str));
    }
}
