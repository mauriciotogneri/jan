package com.mauriciotogneri.jan.bytecode;

import java.util.Arrays;

public class MyClass
{
    public static long factorial(long n)
    {
        if (n <= 0)
        {
            return 1;
        }
        else
        {
            return n * factorial(n - 1);
        }
    }

    public static long[] fibonacci(long n)
    {
        return fibo2(0, n, new long[] {});
    }

    public static long[] fibo2(long index, long limit, long[] list)
    {
        if (index >= limit)
        {
            return list;
        }
        else if (index == 0)
        {
            return fibo2(1, limit, new long[] {1});
        }
        else if (index == 1)
        {
            return fibo2(2, limit, new long[] {1, 1});
        }
        else
        {
            long value = list[(int) (index - 1)] + list[(int) (index - 2)];
            long[] array = Runtime.$concat(list, value);

            return fibo2(index + 1, limit, array);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(fibonacci(10)));
    }
}