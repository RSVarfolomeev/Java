package homeWork;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    private int fieldSizeX;

    //Метод paint не желает отрабатывать при получении значения переменной fieldSizeX из меню
    //стартовых настроек + дополнительно скрывает заливку от setBackground(Color.DARK_GRAY).
    public void paint(Graphics g) {
        int ww = GameWindow.WIN_WIDTH - 7;
        int wh = GameWindow.WIN_HEIGHT - 54;
        int fs = this.fieldSizeX;
        g.setColor(Color.RED);
        for (int i = 0; i < this.fieldSizeX; i++) {
            for (int j = 0; j < this.fieldSizeX; j++) {
                g.drawRect(i * ww / fs, j * wh / fs, ww / fs, wh / fs);
            }
        }
    }

    Map() {
        setBackground(Color.DARK_GRAY);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.fieldSizeX = fieldSizeX;
        System.out.printf("mode: %d, size: %d, len: %d\n", mode, fieldSizeX, winLength);
    }
}
