/*----------------------------------------------------------------
	FILE		: MatrixUtil.java
	AUTHOR		: Java-Aug-2022 Group
	LAST UPDATE	: 17.06.2023

	Utility class for matrix operations

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.matrix;

import org.csystem.util.array.ArrayUtil;

import java.util.random.RandomGenerator;

public final class MatrixUtil {
    private MatrixUtil()
    {}

    public static int [][] add(int [][] a, int [][] b)
    {
        int [][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                result[i][j] = a[i][j] + b[i][j];

        return result;
    }

    public static void addBy(int [][] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] += val;
    }

    public static int [][] getRandomMatrix(RandomGenerator randomGenerator, int m, int n, int min, int bound)
    {
        int [][] result = new int[m][];

        for (int i = 0; i < m; ++i)
            result[i] = ArrayUtil.getRandomArray(randomGenerator, n, min, bound);

        return result;
    }

    public static int [][] getRandomSquareMatrix(RandomGenerator randomGenerator, int n, int min, int bound)
    {
        return getRandomMatrix(randomGenerator, n, n, min, bound);
    }

    public static boolean isMatrix(int [][] a)
    {
        for (int i = 1; i < a.length; ++i)
            if (a[0].length != a[i].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][] a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static int [][] multiply(int [][] a, int [][] b)
    {
        int [][] result = new int[a.length][b[0].length];

        //TODO:

        return result;
    }

    public static void multiplyBy(int [][] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                a[i][j] *= val;
    }

    public static int [][] subtract(int [][] a, int [][] b)
    {
        int [][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                result[i][j] = a[i][j] - b[i][j];

        return result;
    }

    public static void subtractBy(int [][] a, int val)
    {
        addBy(a, -val);
    }

    public static long sum(int [][] a) {
        long total = 0;

        for (int[] rows : a)
            for (int val : rows)
                total += val;

        return total;
    }

    public static long sumDiagonal(int [][] a)
    {
        long total = 0;

        for (int i = 0; i < a.length; ++i)
            total += a[i][i];

        return total;
    }

    public static void swap(int [][] a, int i1, int j1, int i2, int j2)
    {
        int temp = a[i1][j1];
        
        a[i1][j1] = a[i2][j2];
        a[i2][j2] = temp;
    }

    public static int [][] transpose(int [][] a)
    {
        int [][] t = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; ++i)
            for (int j = 0; j < a[i].length; ++j)
                t[j][i] = a[i][j];

        return t;
    }


}
