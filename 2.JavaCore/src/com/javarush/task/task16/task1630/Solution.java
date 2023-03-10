package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Последовательный вывод файлов
*/

public class Solution
{
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e)
        {
            System.out.println("Filename input error.");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException
    {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface
    {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface
    {
        private String fileName;
        private String fileContent = "";

        @Override
        public void run()
        {
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    stringBuilder.append(line + " ");
                }
                fileContent = stringBuilder.toString();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        @Override
        public void setFileName(String fullFileName)
        {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent()
        {
            return fileContent;
        }
    }

}
