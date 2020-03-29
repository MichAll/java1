package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class FilesSelect {

    public void selectFiles(String inFolder, String outFolder, List<String> keys) {
        Path dir = Paths.get(inFolder);
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.txt");
        try {
            Files.walkFileTree(dir, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    if (pathMatcher.matches(path)) {
                        String str = "";
                        try {
                            str = Files.readString(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        for (String key : keys){
                            if (str.contains(key)){
                                Path newDir = Paths.get(outFolder).resolve(key);
                                try {
                                    Files.createDirectories(newDir);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Path newFile = newDir.resolve(path.getFileName());
                                try {
                                    Files.copy(path, newFile, StandardCopyOption.REPLACE_EXISTING);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
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
    }
    public static void main(String[] args) {
        FilesSelect x = new FilesSelect();
        x.selectFiles("D:/total", "D:/", Arrays.asList("123", "456"));
    }
/*
 сортирует файлы по их содержимому. Нужно просмотреть содержимое всех файлов, с расширением txt,
 содержащихся в каталоге inFolder с подкаталогами, и если файл содержит ключевое слово из коллекции keys,
 то скопировать его в подпапку с соответствующим именем, этого элемента keys, все подпапки должны находиться в outFolder.
 Например, вызвана функция с параметрами (“aaa”, “bbb”, {“check”, “files”} )
 нужно проверить каталог aaa с подкаталогами, найти там все файлы txt, и если файл содержит “check”,
 скопировать его в папку bbb/check, если файл содержит “files”, скопировать его в папку bbb/files.
 Важно! Если, например, слово “files” ни разу не встретилось, пустую папку создавать не нужно
*/
}
