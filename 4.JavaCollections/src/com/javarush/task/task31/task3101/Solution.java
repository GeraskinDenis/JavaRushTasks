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
        if (args.length != 2) {
            return;
        }
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File pathFile = new File(path);
        if (!FileUtils.isExist(pathFile)) {
            System.out.println("The File '" + pathFile.getAbsolutePath() + "' not found!");
            return;
        }
        File resultFile = new File(resultFileAbsolutePath);
        File newResultFile = new File(
                "w:/java/vm53/IdeaProjects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3101//allFilesContent.txt");

        System.out.println(resultFile.getName()); // XXX
        if (FileUtils.isExist(resultFile)) {
            FileUtils.renameFile(resultFile, newResultFile);
        }
        System.out.println(resultFile.getName());

        try (FileOutputStream fos = new FileOutputStream(newResultFile)) {
            readCatalogRecursion(pathFile, fos);
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
                if (file.length() <= 50L) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        fos.write(fis.readAllBytes());
                        fos.write(System.lineSeparator().getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
