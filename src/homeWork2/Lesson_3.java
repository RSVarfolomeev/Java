package homeWork2;

import java.util.*;

public class Lesson_3 {

    static Set method_1_1(String[] arr) {
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set;
    }

    static HashMap method_1_2(String[] arr) {
        int count = 1;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (Map.Entry<String, Integer> o : map.entrySet()) {
                if (o.getKey() == arr[i]) count += o.getValue();
            }
            map.put(arr[i], count);
            count = 1;
        }
        return map;
    }

    public static void main(String[] args) {
        String[] arr = {"zero", "one", "two", "three", "two", "five", "two", "seven", "zero", "two"};
        System.out.println("Массив arr состоит из следующих уникальных слов: " + method_1_1(arr));
        System.out.println("В массиве arr каждое слово повторяется следующее количество раз: " + method_1_2(arr).entrySet());
    }
}
