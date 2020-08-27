package homeWork2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    // добавлено к 4-му заданию
    private int[][] field;
    private static final int ADD = 1;
    private boolean initialized = false;
    private int number = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    Sprite[] sprites = new Sprite[10];
    Sprite[] spritesAdd = new Sprite[100];

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        // добавлено к 4-му заданию
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                updateAdd(e);
            }
        });
        field = new int[WINDOW_HEIGHT][WINDOW_WIDTH];

        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    // добавлено к 4-му заданию
    private void addApplication() {
        for (int i = 0; i < number; i++) {
            spritesAdd[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        // добавлено к 4-му заданию
        if (initialized == true) {
            for (int i = 0; i < number; i++) {
                spritesAdd[i].update(canvas, deltaTime);
            }

        }
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        // добавлено к 4-му заданию
        if (initialized == true) {
            for (int i = 0; i < number; i++) {
                spritesAdd[i].render(canvas, g);
            }

        }
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    // добавлено к 4-му заданию
    private void updateAdd(MouseEvent e) {
        int cellX = e.getX();
        int cellY = e.getY();
        field[cellY][cellX] = ADD;
        number++;
        for (int y = 0; y < WINDOW_HEIGHT; y++) {
            for (int x = 0; x < WINDOW_WIDTH; x++) {
                if (field[y][x] == ADD) {
                    initialized = true;
                    addApplication();
                }
            }
        }
    }
}