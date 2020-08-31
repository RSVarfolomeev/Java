package homeWork2;

import java.util.Arrays;

public class Lesson_2 {

    static String[][] method_1(String s) throws ArrayIndexOutOfBoundsException, NullPointerException {
        int x = 0;
        int kCount = 0;
        String q = "";
        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = kCount; k < s.length(); k++) {
                    if (s.charAt(k) == ' ' || s.charAt(k) == '\n') {
                        kCount = k + 1;
                        x++;
                        break;
                    }
                    q += s.charAt(k);
                }
                if (x > 15) throw new ArrayIndexOutOfBoundsException("Количество чисел в передаваемой\n" +
                        " методу 'method_1' строке не соответствует размеру массива - 4х4!");
                arr[i][j] = q;
                if (arr[i][j] == null || arr[i][j] == "") throw new NullPointerException("Количество чисел в передаваемой\n" +
                        " методу 'method_1' строке не соответствует размеру массива - 4х4!");
                q = "";
            }
        }
        return arr;
    }

    static int method_2(String[][] arr) throws myException {
        int[][] intArr = new int[4][4];
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int charCount = 0;
        int sumIntArr = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length(); k++) {
                    for (int l = 0; l < 10; l++) {
                        if (arr[i][j].charAt(k) != chars[l]) charCount++;
                    }
                    if (charCount == 10) throw myException.forInputString(arr[i][j], i, j);
//                        throw new NumberFormatException("В ячейке массива arr[" + (i + 1) + "]" +
//                                "[" + (j + 1) + "] содержится нечисловое значение!");
                    charCount = 0;
                }
                intArr[i][j] = Integer.parseInt(arr[i][j]);
                sumIntArr += intArr[i][j];
            }
        }
        return sumIntArr / 2;
    }

    public static void main(String[] args) {
        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] arr = new String[4][4];
        try {
            arr = method_1(s);
            System.out.println("Массив 1-го задания: " + (Arrays.deepToString(arr)));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        int sumIntArr;
        try {
            sumIntArr = method_2(arr);
            System.out.println("Сумма во 2-м задании равна: " + sumIntArr);
        } catch (myException e) {
            e.printStackTrace();
        }
    }
}