import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String basePath = "/Users/nikolaspetrov/Games";
        StringBuilder log = new StringBuilder();

        List<String> directories = List.of(
                basePath + "/src",
                basePath + "/res",
                basePath + "/savegames",
                basePath + "/temp",
                basePath + "/src/main",
                basePath + "/src/test",
                basePath + "/res/drawables",
                basePath + "/res/vectors",
                basePath + "/res/icons"
        );

        List<String> files = List.of(
                basePath + "/src/main/Main.java",
                basePath + "/src/main/Utils.java",
                basePath + "/temp/temp.txt"
        );

        directories.forEach(dirPath -> createDirectory(dirPath, log));
        files.forEach(filePath -> createFile(filePath, log));

        writeLogToFile(basePath + "/temp/temp.txt", log);
    }

    private static void createDirectory(String path, StringBuilder log) {
        File directory = new File(path);
        if (directory.mkdir()) {
            log.append("Каталог ").append(directory.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(directory.getPath()).append("\n");
        }
    }

    private static void createFile(String path, StringBuilder log) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл ").append(file.getPath()).append(" создан\n");
            } else {
                log.append("Не удалось создать файл ").append(file.getPath()).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(file.getPath()).append(": ").append(e.getMessage()).append("\n");
        }
    }

    private static void writeLogToFile(String filePath, StringBuilder log) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(log.toString());
            System.out.println("Лог записан в файл " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в файл: " + e.getMessage());
        }
    }
}