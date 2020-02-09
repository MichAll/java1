package ru.progwards.java1.lessons.io2;

import java.util.Arrays;

public class Translator {
    private String[] inLang;
    private String[] outLang;
    Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang; this.outLang = outLang;
    }

    public String translate(String sentence) {
        if ("".equals(sentence)) return "";
        String result = "";
        for (int i=0; i<this.inLang.length; i++) {
            int x = sentence.toLowerCase().indexOf(this.inLang[i]);
            if (x != -1) {
                String str = this.inLang[i];
                String str1 = this.outLang[i];
                if (sentence.substring(x,x+1).compareTo(sentence.substring(x,x+1).toUpperCase())==0){
                    str = str.substring(0,1).toUpperCase()+str.substring(1);
                    str1 = str1.substring(0,1).toUpperCase()+str1.substring(1);
                }
                sentence = sentence.replace(str,str1);
            }
        }
        return sentence;
    }
// найти слова, содержащиеся в sentence и в inLang и заменить их на соответствующие в outLang.
// Пунктуация должна быть соблюдена (скопирована из оригинальной строки).
// При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте.
// В inLang и outLang все слова хранятся в нижнем регистре.
    public static void main(String[] args) {
        String[] inL = {"spartak", "champion"};
        String[] outL = {"спартак", "чемпион"};
        Translator newCL = new Translator(inL, outL);
        System.out.println(newCL.translate("Spartak - Champion!"));
        System.out.println(newCL.translate("spartak - champion!"));
        System.out.println(newCL.translate("Mission: Impossible"));
    }
}
