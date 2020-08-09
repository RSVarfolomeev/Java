package homeWork.Zoo;

import homeWork.Animal;

import java.util.Random;

public class Cat extends Animal {

    public Random random = new Random();
    int maxRun = 150 + random.nextInt(100);
    double maxJump = 2;

    public Cat(String name, int runLength, int swimLength, double jumpHeight) {
        super(name, runLength, swimLength, jumpHeight);
    }

    @Override
    public void jump() {
        if (jumpHeight <= maxJump) {
            System.out.println(this.name + " jumps on height " + jumpHeight + " m   --> Result: '" + this.name + " jumped!'");
        } else {
            System.out.println(this.name + " jumps on height " + jumpHeight + " m   --> Result: '" + this.name + " not jumped!'");
        }
    }

    @Override
    public void run() {
        if (runLength <= maxRun){
            System.out.println(this.name + " runs distance " + runLength + " m   --> Result: '" + this.name + " ran! Available distance of this cat " + maxRun + " m.'");
        } else {
            System.out.println(this.name + " runs distance " + runLength + " m   --> Result: '" + this.name + " not ran! Available distance of this cat " + maxRun + " m.'");
        }
    }

    @Override
    public void swim() {
        System.out.println(this.name + " swims distance " + swimLength + " m   --> Result: '" + this.name + " can't to swim and go down!'");
    }
}