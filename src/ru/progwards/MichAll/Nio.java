package ru.progwards.MichAll;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio {
    String createFolder(String name) {
        new File(name).mkdir();
        Path path = Paths.get(".");
        return path.toAbsolutePath().normalize().getParent().toString();
    }

    boolean replaceF(String name) {
        String str="", strOut="";
        try {
            Path path = Paths.get(name);
            str = Files.readString(path);
            strOut = str.replaceAll("F", "f");
            Files.writeString(path, strOut);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Nio nio = new Nio();
        System.out.println(nio.createFolder("123"));
    }
}
