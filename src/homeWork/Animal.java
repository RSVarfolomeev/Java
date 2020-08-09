package homeWork;

public class Animal {
    protected String name;
    protected int runLength;
    protected double jumpHeight;
    protected int swimLength;

    protected Animal(String name, int runLength, int swimLength, double jumpHeight) {
        this.name = name;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
        this.swimLength = swimLength;
    }

    public void jump() {
    }

    public void run() {
    }

    public void swim() {
    }
}
