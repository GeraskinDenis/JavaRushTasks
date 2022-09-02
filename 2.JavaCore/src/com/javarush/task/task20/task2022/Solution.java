package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable
{
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args)
    {
        String fileName = ".\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\task2022.data";
        Solution solution;
        try
        {
            solution = new Solution(fileName);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }

        try
        {
            solution.writeObject("Hello World!");
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            line = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        System.out.println(line);

        byte[] bytesStorage;

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream))
        {
            outputStream.writeObject(solution);
            bytesStorage = byteArrayOutputStream.toByteArray();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        Solution solution1;
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytesStorage);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream))
        {
            solution1 = (Solution) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            return;
        }

        try
        {
            solution1.writeObject("Hello World!");
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        String line1;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            line1 = reader.readLine();
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        System.out.println(line1);
    }
}
