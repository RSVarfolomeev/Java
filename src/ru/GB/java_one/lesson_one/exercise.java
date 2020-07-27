package ru.GB.java_one.lesson_one;

public class exercise {

    public static double method_1(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean method_2(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    public static String method_3(int a) {
        String b;
        if (a >= 0) {
            b = "Число '" + a + "' - положительное";
        } else {
            b = "Число '" + a + "' - отрицательное";
        }
        return b;
    }

    public static String method_4(String a) {
        return "Привет, " + a + "!";
    }

    public static String method_5(int a) {
        String b;
        if (a % 4 == 0 && a % 100 != 0) {
            b = "Год " + a + " является високосным";
        } else if (a % 400 == 0) {
            b = "Год " + a + " является високосным";
        } else {
            b = "Год " + a + " не является високосным";
        }
        return b;
    }

    public static void main(String[] args) {
        double z = method_1(5, 3, 4, 2);
        System.out.println(z);
        boolean x = method_2(5, 25);
        System.out.println(x);
        String y = method_3(-5);
        System.out.println(y);
        String v = method_4("Иван");
        System.out.println(v);
        String u = method_5(1900);
        System.out.println(u);
    }
}
