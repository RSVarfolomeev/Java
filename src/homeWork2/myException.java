package homeWork2;

public class myException extends Exception {

    public myException (String s) {
        super (s);
    }

    static myException forInputString(String s, int i, int j) {
        return new myException("В ячейке массива arr[" + (i + 1) + "]" +
                "[" + (j + 1) + "] содержится нечисловое значение!");
    }
}
