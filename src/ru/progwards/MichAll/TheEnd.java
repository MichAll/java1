package ru.progwards.MichAll;

import java.util.StringTokenizer;

public class TheEnd {
    String swapWords(String sentance) {
        String result=""; String res1=""; String res2="";
        StringTokenizer tokenizer = new StringTokenizer(sentance, " .,-!\n");
            while (tokenizer.hasMoreTokens()) {
                res1 = tokenizer.nextToken();
                if (tokenizer.countTokens()>0)
                    res2 = " " + tokenizer.nextToken();
                else {
                    res2 = "";
                }
                result += res2+" "+res1;
        }
        return result.trim();
    }

    public static void main(String[] args) {
        TheEnd konec = new TheEnd();
        System.out.println(konec.swapWords("Слово - серебро, молчание - золото!"));

        //серебро Слово золото молчание
        //словом Убитых молчанием добивают Уильям (c) Шекспир
    }

}
