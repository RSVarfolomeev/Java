package homeWork;

import java.util.Arrays;

public class Lesson_2 {

    public static int[] method_1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case 0:
                    a[i] = 1;
                    break;
                case 1:
                    a[i] = 0;
                    break;
                default:
                    System.out.println("Ни один из case не сработал");
            }
        }
        return a;
    }

    public static int[] method_2(int[] a) {
        a[0] = 1;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + 3;
        }
        return a;
    }

    public static int[] method_3(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] = a[i] * 2;
            }
        }
        return a;
    }

    public static int method_4max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static int method_4min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static int[][] method_5(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[a.length - 1 - i][i] = 1;
        }
        return a;
    }

    public static boolean method_6(int[] a) {
        int leftSum = a[0];
        int rightSum = a[a.length - 1];
        int[] arrLeft = new int[a.length];
        int[] arrRight = new int[a.length];
        arrLeft[0] = leftSum;
        arrRight[0] = rightSum;
        for (int i = 1; i < a.length; i++) {
            leftSum = leftSum + a[i];
            rightSum = rightSum + a[a.length - 1 - i];
            arrLeft[i] = leftSum;
            arrRight[i] = rightSum;
        }
        boolean checkBalance = false;
        for (int j = 0; j < a.length - 1; j++) {
            if (arrLeft[j] == arrRight[a.length - 2 - j]) {
                checkBalance = true;
                break;
            }
        }
        return checkBalance;
    }

//    public static int[] method_7(int[] a, int n) {
//        n = n % a.length;
//        int b;
//        for (int i = 0; i < a.length; i++) {
//            if (i < a.length - n) {
//                b = a[a.length - 1 - i];
//                int g = a.length - 1 - i - n;
//                a[a.length - 1 - i] = a[g];
//                a[g] = b;
//            } else if (i >= a.length - n && i < a.length - 1) {
//                b = a[a.length - 1 - i];
//                int g = a.length - 1 - i - (1 + (a.length - 1 - n - i + a.length - n) / n);
//                a[a.length - 1 - i] = a[g];
//                a[g] = b;
//            }
//        }
//        return a;
//    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 1};
        int[] arrPrint = method_1(arr);
        System.out.println(Arrays.toString(arrPrint));

        int[] arr2 = new int[8];
        int[] arr2Print = method_2(arr2);
        System.out.println(Arrays.toString(arr2Print));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arr3Print = method_3(arr3);
        System.out.println(Arrays.toString(arr3Print));

        int[] arr4 = {1, 5, 3, 2, 11, 4};
        int arr4MaxPrint = method_4max(arr4);
        int arr4MinPrint = method_4min(arr4);
        System.out.println("Максимальное значение элемента массива в 4-м задании - " + arr4MaxPrint);
        System.out.println("Минимальное значение элемента массива в 4-м задании - " + arr4MinPrint);

        int[][] arr5 = new int[4][4];
        int[][] arr5Print = method_5(arr5);
        for (int i = 0; i < arr5Print.length; i++) {
            System.out.println(Arrays.toString(arr5Print[i]));
        }

        int[] arr6 = {1, 8, 5, 3, 1, 11, 7};
        boolean arr6Print = method_6(arr6);
        if (arr6Print == true) {
            System.out.println("В массиве 6-го задания имеется место, в котором сумма левой и правой части массива равны");
        } else {
            System.out.println("В массиве 6-го задания отсутствует место, в котором сумма левой и правой части массива равны");
        }

//        int[] arr7 = {1, 2, 3, 4, 5, 6, 7};
//        int number = 3;
//        int[] arr7Print = method_7(arr7, number);
//        System.out.println(Arrays.toString(arr7Print));
    }
}