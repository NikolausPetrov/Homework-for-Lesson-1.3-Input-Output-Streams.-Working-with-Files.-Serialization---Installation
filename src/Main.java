import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        String basePath = "/Users/nikolaspetrov/Library/Games";

        File srcDir = new File(basePath, "src");
        File resDir = new File(basePath, "res");
        File savegamesDir = new File(basePath, "savegames");
        File tempDir = new File(basePath, "temp");

        if (srcDir.mkdir()) {
            log.append("Каталог ").append(srcDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(srcDir.getPath()).append("\n");
        }

        if (resDir.mkdir()) {
            log.append("Каталог ").append(resDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(resDir.getPath()).append("\n");
        }

        if (savegamesDir.mkdir()) {
            log.append("Каталог ").append(savegamesDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(savegamesDir.getPath()).append("\n");
        }

        if (tempDir.mkdir()) {
            log.append("Каталог ").append(tempDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(tempDir.getPath()).append("\n");
        }

        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");

        if (mainDir.mkdir()) {
            log.append("Каталог ").append(mainDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(mainDir.getPath()).append("\n");
        }

        if (testDir.mkdir()) {
            log.append("Каталог ").append(testDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(testDir.getPath()).append("\n");
        }

        File mainJava = new File(mainDir, "Main.java");
        try {
            if (mainJava.createNewFile()) {
                log.append("Файл ").append(mainJava.getPath()).append(" создан\n");
            } else {
                log.append("Не удалось создать файл ").append(mainJava.getPath()).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(mainJava.getPath()).append(": ").append(e.getMessage()).append("\n");
        }

        File utilsJava = new File(mainDir, "Utils.java");
        try {
            if (utilsJava.createNewFile()) {
                log.append("Файл ").append(utilsJava.getPath()).append(" создан\n");
            } else {
                log.append("Не удалось создать файл ").append(utilsJava.getPath()).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(utilsJava.getPath()).append(": ").append(e.getMessage()).append("\n");
        }

        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");

        if (drawablesDir.mkdir()) {
            log.append("Каталог ").append(drawablesDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(drawablesDir.getPath()).append("\n");
        }

        if (vectorsDir.mkdir()) {
            log.append("Каталог ").append(vectorsDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(vectorsDir.getPath()).append("\n");
        }

        if (iconsDir.mkdir()) {
            log.append("Каталог ").append(iconsDir.getPath()).append(" создан\n");
        } else {
            log.append("Не удалось создать каталог ").append(iconsDir.getPath()).append("\n");
        }

        File tempTxt = new File(tempDir, "temp.txt");
        try {
            if (tempTxt.createNewFile()) {
                log.append("Файл ").append(tempTxt.getPath()).append(" создан\n");
            } else {
                log.append("Не удалось создать файл ").append(tempTxt.getPath()).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(tempTxt.getPath()).append(": ").append(e.getMessage()).append("\n");
        }
        
        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(log.toString());
            System.out.println("Лог записан в файл " + tempTxt.getPath());
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в файл: " + e.getMessage());
        }
    }
}