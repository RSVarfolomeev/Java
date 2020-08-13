package homeWork;

import java.io.*;
import java.util.Scanner;

public class Lesson_6 {

    public static String method_2(String[] arr) {
        String sc = "";
        for (int i = 0; i < arr.length; i++) {
            sc += method_2_1(arr[i]) + "\n";
        }
        return sc;
    }

    public static String method_2_1(String a) {
        String sc = "";
        try {
            Scanner scanner = new Scanner(new FileInputStream(a));
            while (scanner.hasNext())
                sc += scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sc;
    }

    public static boolean method_3(String file, String word) {
        String sc = method_2_1(file);
        for (int i = 0; i < sc.length() - word.length() + 1; i++) {
            if (sc.substring(i, i + word.length()).equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean method_4(String [] directoryList, String word) {
        for (int j = 0; j < directoryList.length; j++) {
            for (int i = 0; i < directoryList[j].length() - word.length() + 1; i++) {
                if (directoryList[j].substring(i, i + word.length()).equals(word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

//  №1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);

        try {

            PrintStream ps1 = new PrintStream(new FileOutputStream("text1.txt", true));
            ps1.println("The 2ES10 is a twin section freight locomotive\n manufactured from 2010 by Ural Locomotives.");
            ps1.flush();
            ps1.close();

            PrintStream ps2 = new PrintStream(new FileOutputStream("text2.txt", true));
            ps2.println("The 2ES10 offers double the power output of VL11 locomotives,\n with lower operating and maintenance costs.");
            ps2.flush();
            ps2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

//  №2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.

        String [] arr = {"text1.txt", "text2.txt"};
        System.out.println(method_2(arr));

//  №3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле (работаем только с латиницей).

        String file = "text1.txt";
        Scanner fileScanner3 = new Scanner(System.in);
        System.out.println("Введите слово для поиска в файле " + file + " >>>");
        String word3 = fileScanner3.next();
        if (method_3(file, word3)){
            System.out.println("Слово '" + word3 +"' в файле " + file + " присутствует.");
        } else {
            System.out.println("Слова '" + word3 +"' в файле " + file + " не найдено.");
        }

//  №4. ** Написать метод, проверяющий, есть ли указанное слово в папке.

        File directory = new File("D:/Java");
        String[] directoryList = directory.list();
        Scanner fileScanner4 = new Scanner(System.in);
        System.out.println("Введите слово для поиска в папке " + directory + " >>>");
        String word4 = fileScanner4.next();
        fileScanner4.close();
        if (method_4(directoryList, word4)){
            System.out.println("Слово '" + word4 +"' в папке " + directory + " присутствует.");
        } else {
            System.out.println("Слова '" + word4 +"' в папке " + directory + " не найдено.");
        }
    }
}

