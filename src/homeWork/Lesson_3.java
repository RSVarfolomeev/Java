package homeWork;

import java.util.Random;
import java.util.Scanner;

public class Lesson_3 {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int count; // переменная для подсчета победных фишек
    private static char[][] field;

    private static void initField() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        count = 4; // количество фишек для проверки победы
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }

        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 5) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isEmptyCell(x, y)) return false;
            }
        }
        return true;
    }

    private static boolean winCell(int x, int y, char c) {
        return field[y][x] != c;
    }

    private static boolean xLineCheck(int dx, int y, char c) {
        for (int x = dx; x < fieldSizeX - (fieldSizeX - count - dx); x++) {
            if (winCell(x, y, c)) return false;
        }
        return true;
    }

    private static boolean yLineCheck(int x, int dy, char c) {
        for (int y = dy; y < fieldSizeY - (fieldSizeY - count - dy); y++) {
            if (winCell(x, y, c)) return false;
        }
        return true;
    }

    private static boolean diagonal_1_Check(int d, int dd, char c) {
        if (d < 0) {
            d = -d;
            for (int x = dd; x < fieldSizeY - (fieldSizeY - count - dd); x++) {
                if (winCell(x, x + d, c)) return false;
            }
        } else if (d >= 0) {
            for (int x = dd; x < fieldSizeX - (fieldSizeX - count - dd); x++) {
                if (winCell(x + d, x, c)) return false;
            }
        }
        return true;
    }

    private static boolean diagonal_2_Check(int d, int dd, char c) {
        if (d < 0) {
            d = -d;
            for (int x = dd; x < fieldSizeY - (fieldSizeY - count - dd); x++) {
                if (winCell(x, fieldSizeY - 1 - (x + d), c)) return false;
            }
        } else if (d >= 0) {
            for (int x = dd; x < fieldSizeX - (fieldSizeX - count - dd); x++) {
                if (winCell(x + d, fieldSizeX - 1 - x, c)) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char c) {

        // hor
        for (int dx = 0; dx <= fieldSizeX - count; dx++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (xLineCheck(dx, y, c)) return true;
            }
        }

        // ver
        for (int dy = 0; dy <= fieldSizeY - count; dy++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (yLineCheck(x, dy, c)) return true;
            }
        }

        // dia
        for (int d = count - fieldSizeY; d <= fieldSizeX - count; d++) {
            if (d < 0) {
                for (int dd = 0; dd <= fieldSizeY - count + d; dd++) {
                    if (diagonal_1_Check(d, dd, c)) return true;
                }
            } else if (d >= 0) {
                for (int dd = 0; dd <= fieldSizeX - count - d; dd++) {
                    if (diagonal_1_Check(d, dd, c)) return true;
                }
            }
        }

        for (int d = count - fieldSizeY; d <= fieldSizeX - count; d++) {
            if (d < 0) {
                for (int dd = 0; dd <= fieldSizeY - count + d; dd++) {
                    if (diagonal_2_Check(d, dd, c)) return true;
                }
            } else if (d >= 0) {
                for (int dd = 0; dd <= fieldSizeX - count - d; dd++) {
                    if (diagonal_2_Check(d, dd, c)) return true;
                }
            }
        }

        return false;

//        //  hor
//        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
//        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
//        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;
//
//        // ver
//        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
//        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
//        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;
//
//        // dia
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
//        return false;
    }


    public static void main(String[] args) {
        String answer;
        do {
            initField();
            printField();
            while (true) {
                humanTurn();
                if (checkEndGame(DOT_HUMAN, "Human win!")) break;
                aiTurn();
                if (checkEndGame(DOT_AI, "Computer win!")) break;
            }
            System.out.println("Wanna play again? (y/n) >>> ");
            answer = SCANNER.next();
        } while (answer.equals("y"));
        SCANNER.close();
    }

    private static boolean checkEndGame(char dot, String winMessage) {
        printField();
        if (checkWin(dot)) {
            System.out.println(winMessage);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Draw!");
            return true;
        }
        return false;
    }
}