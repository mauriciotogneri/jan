package com.mauriciotogneri.jan.bytecode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Runtime
{
    public static void main(String[] args) throws Exception
    {
        int[] aaa = new int[] {1, 2, 3};


        int[] bbb = $concat(aaa, 4);
        System.out.println(Arrays.toString(bbb));
    }

    public static int[] $concat(int[] array, int element)
    {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = element;

        return newArray;
    }

    public static long[] $concat(long[] array, long element)
    {
        long[] newArray = new long[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = element;

        return newArray;
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T $concat(T array, E element)
    {
        E[] newArray = $createArrayAndFill(array, ((E[]) array).length + 1);
        newArray[newArray.length - 1] = element;

        return (T) newArray;
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T $clone(T object)
    {
        if (object instanceof int[])
        {
            return (T) ((int[]) object).clone();
        }
        else if (object instanceof float[])
        {
            return (T) ((float[]) object).clone();
        }
        else if (object instanceof boolean[])
        {
            return (T) ((boolean[]) object).clone();
        }
        else if (object instanceof String[])
        {
            return (T) ((String[]) object).clone();
        }
        else if (object.getClass().isArray())
        {
            E[] array = (E[]) object;

            return (T) $createArrayAndFill(array, array.length);
        }
        else
        {
            return object;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T $createArray(Class<?> clazz, int size)
    {
        if (clazz.equals(int[].class))
        {
            return (T) new int[size];
        }
        else if (clazz.equals(float[].class))
        {
            return (T) new float[size];
        }
        else if (clazz.equals(boolean[].class))
        {
            return (T) new boolean[size];
        }
        else if (clazz.equals(String[].class))
        {
            return (T) new String[size];
        }
        else if (clazz.isArray())
        {
            return (T) Array.newInstance(clazz.getComponentType(), size);
        }
        else
        {
            return null;
        }
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private static <T, E> E[] $createArrayAndFill(T array, int size)
    {
        E[] source = (E[]) array;
        E[] newArray = $createArray(array.getClass(), size);

        for (int i = 0; i < source.length; i++)
        {
            newArray[i] = $clone(source[i]);
        }

        return newArray;
    }
}