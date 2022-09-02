package com.javarush.task.task14.task1419;

import javax.naming.directory.AttributeInUseException;
import javax.security.auth.login.AccountNotFoundException;
import java.awt.*;
import java.io.IOException;
import java.rmi.activation.ActivationException;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {
        // 1
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
            exceptions.add(new AccountNotFoundException(""));
            exceptions.add(new ActivationException(""));
            exceptions.add(new IOException(""));
            exceptions.add(new AttributeInUseException(""));
            exceptions.add(new AWTException(""));
            exceptions.add(new BackingStoreException(""));
            exceptions.add(new CertificateEncodingException(""));
            exceptions.add(new ClassNotFoundException(""));
            exceptions.add(new DataFormatException(""));

        }

//        // 2
//        try
//        {
//            float i = 1 / 0;
//
//        } catch (ArithmeticException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 3
//        try
//        {
//            int[] a = {1, 2, 3};
//            int s = a[4];
//        } catch (ArrayIndexOutOfBoundsException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 4
//        try
//        {
//            Date date = Date.from(Instant.parse("dfdf"));
//        } catch (DateTimeParseException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 5
//        try
//        {
//            InputStream stream = new FileInputStream("dfdfdf");
//        } catch (FileNotFoundException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 6
//        try
//        {
//            InputStream stream = new FileInputStream("dfdfdf");
//        } catch (IOException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 7
//        try
//        {
//            String str = null;
//            str.equals("dfd");
//        } catch (NullPointerException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 8
//        try
//        {
//            Integer integer = Integer.parseInt("ddf");
//        } catch (RuntimeException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 9
//        try
//        {
//            Integer integer = Integer.parseInt("ddf");
//        } catch (IllegalArgumentException e)
//        {
//            exceptions.add(e);
//        }
//
//        // 10
//        try
//        {
//            Integer integer = Integer.parseInt("ddf");
//        } catch (NumberFormatException e)
//        {
//            exceptions.add(e);
//        }

    }
}
