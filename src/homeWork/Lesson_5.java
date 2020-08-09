package homeWork;

import homeWork.Zoo.Cat;
import homeWork.Zoo.Dog;

public class Lesson_5 {
    public static void main(String[] args) {
        Cat c = new Cat("Barseek", 200, 15, 2);
        Dog d0 = new Dog("Toozeek", 500, 10, 1);
        Dog d1 = new Dog("Bobeek", 500, 20, 0.5);

        Animal[] zoo = {c, d0, d1};
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].run();
            zoo[i].swim();
            zoo[i].jump();
        }
    }
}
