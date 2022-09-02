package com.javarush.task.task14.task1420;

import java.util.*;
import java.util.stream.Collectors;

/* 
НОД
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a = 0;
        int b = 0;
        try (Scanner scanner = new Scanner(System.in))
        {
            while (scanner.hasNextInt())
            {
                a = scanner.nextInt();
                if (a > 0)
                    break;
            }

            while (scanner.hasNextInt())
            {
                b = scanner.nextInt();
                if (b > 0)
                    break;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        HashSet<Integer> integers = new HashSet<>();
        integers.add(a);
        integers.add(b);
        System.out.println(nod(integers).get());
    }

    private static Optional<Integer> nod(HashSet<Integer> integers)
    {
        Map<Integer, List<Integer>> mapIntFactors =
                integers.stream().collect(Collectors.toMap(e -> e, Solution::getFactors));

        int minLength = Integer.MAX_VALUE;
        Integer key = null;
        List<Integer> integerList = null;
        for (Map.Entry<Integer, List<Integer>> oneOf : mapIntFactors.entrySet())
        {
            if (oneOf.getValue().size() < minLength)
            {
                minLength = oneOf.getValue().size();
                key = oneOf.getKey();
                integerList = oneOf.getValue();
            }
        }

        if (integerList == null)
            return Optional.empty();

        mapIntFactors.remove(key);

        List<Integer> sharedFactors = new ArrayList<>();
        for (Integer factor : integerList)
        {
            boolean isSharedFactor = true;
            for (Map.Entry<Integer, List<Integer>> entry : mapIntFactors.entrySet())
            {
                boolean factorFound = false;
                List<Integer> listFactors = entry.getValue();
                for (int i = 0; i < listFactors.size(); i++)
                {
                    if (factor.equals(listFactors.get(i)))
                    {
                        factorFound = true;
                        listFactors.remove(i);
                        break;
                    }
                }
                isSharedFactor = isSharedFactor && factorFound;
                if (!isSharedFactor)
                    break;
            }
            if (isSharedFactor)
                sharedFactors.add(factor);
        }
        Integer nod = 1;
        for (Integer factor : sharedFactors)
        {
            nod *= factor;
        }
        return Optional.of(nod);
    }

    private static List<Integer> getFactors(int num)
    {
        List<Integer> factors = new ArrayList<>();
        int copyNum = num;
        for (int i = 2; num > 1 && i <= copyNum; )
        {
            if (num % i > 0)
            {
                i++;
                continue;
            }
            num = num / i;
            factors.add(i);
        }
        return factors;
    }
}
