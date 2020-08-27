package homeWork2;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private MainCircles controller;

    // добавлено к 3-му заданию
    private Color color;
    private float dt;

    GameCanvas(MainCircles controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;

        // добавлено к 3-му заданию
        dt += deltaTime;
        if (dt >= 20) dt = 0;
        Background b = new Background(dt);
        color = new Color(
                b.getColorX(), //red
                b.getColorY(), //green
                b.getColorZ()  //blue
        );
        setBackground(color);

        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }
}