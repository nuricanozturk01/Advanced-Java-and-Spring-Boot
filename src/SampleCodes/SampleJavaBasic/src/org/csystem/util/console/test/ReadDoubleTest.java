package org.csystem.util.console.test;

import org.csystem.util.console.Console;

public class ReadDoubleTest {
    public static void run()
    {
        double a = Console.readDouble("Birinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");
        double b = Console.readDouble("İkinci sayıyı giriniz:", "Hatalı sayı girdiniz!...");

        Console.writeLine("%f + %f = %f", a, b, a + b);
    }
    public static void main(String[] args)
    {
        run();
    }
}
