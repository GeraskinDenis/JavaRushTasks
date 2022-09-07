package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Проход по дереву файлов
*/

public class Solution {

    public static void main(String[] args) {
        // "temp/task3101/src" "c:/fresh7lemon@ya.ru/java/vm53/IdeaProjects/JavaRushTasks/temp/task3101/result.txt"

        if (args.length != 2) {
            return;
        }

        File src = new File(System.getProperty("user.dir") + "/" + args[0]);
        if (!FileUtils.isExist(src)) {
            System.out.println("The catalog '" + src.getAbsolutePath() + "' not found!");
            return;
        }

        File resultFile = new File(args[1]);
        if(!FileUtils.isExist(resultFile)){
            System.out.println("The File '" + resultFile.getAbsolutePath() + "' not found!");
            return;
        }

        File newResultFile = new File(resultFile.getParent() + "/allFilesContent.txt");

        // Если существует файл с новым именем, тогда удаляем его
        if (FileUtils.isExist(newResultFile)) {
            FileUtils.deleteFile(newResultFile);
        }

        if (FileUtils.isExist(resultFile)) {
            FileUtils.renameFile(resultFile, newResultFile);
        }

        try (FileOutputStream fos = new FileOutputStream(newResultFile)) {
            readCatalogRecursion(src, fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readCatalogRecursion(File Directory, FileOutputStream fos) {
        File[] listFiles = Directory.listFiles();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                readCatalogRecursion(file, fos);
            } else {
                if (file.length() <= 50L && isTxtFile(file)) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        byte[] bytes = new byte[16];
                        while (fis.available() > 0) {
                            int n = fis.read(bytes);
                            fos.write(bytes, 0, n);
                        }
                        fos.write(System.lineSeparator().getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    private static boolean isTxtFile(File file) {
        return file.getName().matches(".+.txt$");
    }
}
