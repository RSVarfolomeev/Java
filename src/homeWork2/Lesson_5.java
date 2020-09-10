package homeWork2;

import java.util.Arrays;

public class Lesson_5 {

    static void method_1(){
        final int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("\nМетод №1 (однопоточный):\na = " + a + " мс");
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis() + " мс");
        System.out.println("Разница = " + (System.currentTimeMillis() - a) + " мс");
    }

    static void method_2(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread r1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };
        Thread r2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        r1.start();
        r2.start();

        try {
            r1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            r2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.currentTimeMillis();
        System.out.println("\nМетод №2 (двухпоточный):\na = " + a + " мс");
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis() + " мс");
        System.out.println("Разница = " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void main(String[] args) {
        method_1();
        method_2();
    }
}
