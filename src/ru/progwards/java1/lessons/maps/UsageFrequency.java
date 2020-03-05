package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UsageFrequency {
    //Реализовать класс, подсчитывающий частоту использования слов и букв в словах на основе текстов. Методы:
    private String strOut = "";

    // загрузить содержимое файла
    public void processFile(String fileName) {
        try (FileReader fileRead = new FileReader(fileName)) {
            try (Scanner scanner = new Scanner(fileRead)) {
                while (scanner.hasNextLine()) {
                    strOut += scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

// вернуть Map, который содержит все найденные буквы и цифры, и количество раз,
// которое встретился каждый искомый символ. Знаки препинания, такие как “.,!? @” и др не учитывать.
    public Map<Character, Integer> getLetters() {
        Map<Character, Integer> getL = new HashMap<>();
//        char [] str1 = strOut.toCharArray();
        for (char str : strOut.toCharArray()) {
            if (Character.isLetter(str) || Character.isDigit(str)) {
                if (getL.containsKey(str))
                    getL.replace(str, getL.get(str) + 1);
                else
                    getL.put(str, 1);
            }
        }
        return getL;
    }

// вернуть Map, который содержит все найденные слова и количество раз, которое каждое слово встретилось.
// Знаки препинания, такие как “.,!? @” и др являются разделителями.
    public Map<String, Integer> getWords() {
        Map<String, Integer> getW = new HashMap<>();
        strOut = strOut.replaceAll("[^\\w\\s]", "");
        for (String str1 : strOut.trim().split(" ")) {
            if (str1.equals("")) continue;
            if (getW.containsKey(str1))
                getW.replace(str1, getW.get(str1) + 1);
            else
                getW.put(str1, 1);
        }
        return getW;
    }

// Протестировать на файле wiki.train.tokens (во вложении), для отладки можно использовать wiki.test.tokens
    public static void main(String[] args) {
        UsageFrequency usaFreq = new UsageFrequency();
        usaFreq.processFile("d:/JavaPackage/wiki.test.tokens");
        for (var entry : usaFreq.getLetters().entrySet())
            System.out.println(entry);
        for (var entry : usaFreq.getWords().entrySet())
            System.out.println(entry);
    }
}
