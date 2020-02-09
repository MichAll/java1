package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Scanner;

public class Censor {

    static String metodStr(String strStar){
        String str2 = "";
        for (int i=0; i<strStar.length(); i++)
            str2+="*";
        return str2;
    }

    public static void censorFile(String inoutFileName, String[] obscene)throws CensorException{
        String strOut = "";
        try (FileReader fileRead = new FileReader(inoutFileName)) {
            try (Scanner scanner = new Scanner(fileRead)) {
                while (scanner.hasNextLine()) {
                    String str1 = scanner.nextLine();
                    for (String str : obscene)
                        if (str1.contains(str) == true) str1 = str1.replace(str, metodStr(str));
//                    str1 = new String(str1.getBytes("UTF-8"));
                    strOut += str1;
                }
            }
            try (FileWriter fileWrite = new FileWriter(inoutFileName)) {
                fileWrite.write(strOut);
            } catch (IOException e) {
                throw new CensorException(e.getMessage(), inoutFileName);
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    static class CensorException extends Exception {

        private final String message;
        private final String fileName;

        public CensorException(String message, String fileName) {
            this.message = message;
            this.fileName = fileName;
        }
        @Override
        public String toString() {
            return fileName + ":" + message;
        }
    }

    public static void main (String[]args){
        Censor nw = new Censor();
        String file = "d:/JavaPackage/TEST.txt";
        String[] obs = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            nw.censorFile(file, obs);
        } catch (CensorException e) {
            e.printStackTrace();
        }
    }

}