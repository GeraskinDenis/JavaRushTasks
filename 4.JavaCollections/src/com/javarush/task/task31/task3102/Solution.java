package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        File src = new File(root);
        if (src.isFile()) {
            src = new File(src.getParent());
        }

        List<String> result = new ArrayList<>();
        File[] filePaths = src.listFiles();
        for (File file : filePaths) {
            if (file.isFile()) {
                result.add(file.getAbsolutePath());
            } else {
                addFiles(file, result);
            }
        }
        return result;
    }

    private static void addFiles(File file, List<String> result) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                result.add(f.getAbsolutePath());
            } else {
                addFiles(f, result);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> filePaths = getFileTree(new File("").getAbsolutePath());
        filePaths.forEach(System.out::println);
    }
}
