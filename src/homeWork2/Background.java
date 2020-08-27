package homeWork2;

public class Background {
    float deltaTime;
    int x;
    int y;
    int z;


    Background(float deltaTime) {
        this.deltaTime = deltaTime;
        x = (int) (deltaTime * 10);
        if (x >= 255) x = 0;
        y = (int) (deltaTime * 20);
        if (y >= 255) y = 85;
        z = (int) (deltaTime * 30);
        if (z >= 255) z = 170;
    }

    int getColorX() {
        return this.x;
    }

    int getColorY() {
        return this.y;
    }

    int getColorZ() {
        return this.z;
    }
}