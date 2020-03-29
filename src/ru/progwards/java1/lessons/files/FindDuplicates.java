package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {
//    В заданном каталоге и его подкаталогах найти файлы, точно совпадающие по названию (и расширению),
//    дате-времени последнего изменения, размеру и по содержимому.

    //результат - список, содержащий списки строк с именами и полными путями совпадающих файлов.
    public List<List<String>> findDuplicates(String startPath) {
        List<List<String>> result = new ArrayList<>();
// собираем все файлы
        List<Path> paths = new ArrayList<>();
        Path dir = Paths.get(startPath);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**");
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(dir.relativize(path))) {
                        paths.add(path);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException e) {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < paths.size(); i++) {
            List<String> pathsName = new ArrayList<>();
            Path fileS = paths.get(i);
            int filesFound = 0;
            for (int y = i + 1; y < paths.size(); y++) {
                Path fileF = paths.get(y);
// проверка "Имя, сестра, имя!"
                if (fileS.getFileName().compareTo(fileF.getFileName()) == 0) {
                    if (!pathsName.contains(fileF.toString())) {
// проверка "Срок годности"
                        try {
                            if (Files.getAttribute(fileS, "lastModifiedTime").equals(Files.getAttribute(fileF, "lastModifiedTime"))) {
                                if (!pathsName.contains(fileF.toString())) {
// проверка "Размер горчичников и масла в жопу побольше"
                                        if ((Files.size(fileS) == Files.size(fileF)) && (Arrays.equals(Files.readAllBytes(fileS), Files.readAllBytes(fileF)))) {
                                            if (!pathsName.contains(fileF.toString())) {
                                                pathsName.add(fileF.toString());
                                                filesFound = 1;
                                            }
                                        }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (filesFound == 1) pathsName.add(fileS.toString());
            result.add(pathsName);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FindDuplicates x = new FindDuplicates();
        System.out.println(x.findDuplicates("C:/totalcmd"));
    }
}
