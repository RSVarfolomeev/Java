package homeWork.Zoo;

import homeWork.Animal;

import java.util.Random;

public class Dog extends Animal {

    public Random random = new Random();
    int maxRun = 400 + random.nextInt(200);
    int maxSwin = 10;
    double maxJump = 0.5;

    public Dog (String name, int runLength, int swimLength, double jumpHeight) {
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
            System.out.println(this.name + " runs distance " + runLength + " m   --> Result: '" + this.name + " ran! Available distance of this dog " + maxRun + " m.'");
        } else {
            System.out.println(this.name + " runs distance " + runLength + " m   --> Result: '" + this.name + " not ran! Available distance of this dog " + maxRun + " m.'");
        }
    }

    @Override
    public void swim() {
        if (swimLength <= maxSwin) {
            System.out.println(this.name + " swims distance " + swimLength + " m   --> Result: '" + this.name + " swam!'");
        } else {
            System.out.println(this.name + " swims distance " + swimLength + " m   --> Result: '" + this.name + " not swam!'");
        }
    }
}
