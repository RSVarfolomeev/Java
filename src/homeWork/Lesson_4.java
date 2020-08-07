package homeWork;

public class Lesson_4 {

    public static void salary_up(Worker[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].getAge() > 45) {
                a[i].setSalary(a[i].getSalary()+5000);
            }
        }
    }

        public static int middle_Salary(Worker[] a) {
        int middle = a[0].getSalary();
        for (int i = 1; i < a.length; i++) {
            middle += a[i].getSalary();
        }
        return middle /= a.length;
    }

    public static int middle_Age(Worker[] a) {
        int middle = a[0].getAge();
        for (int i = 1; i < a.length; i++) {
            middle += a[i].getAge();
        }
        return middle /= a.length;
    }

    public static void main(String[] args) {
        Worker w = new Worker("Иванов Иван Иванович", 50000, 25);
        System.out.printf("Worker: %s of age %d\n",
                w.getFull_name(), w.getAge());

        Worker[] w1 = {
                new Worker("Иванов Иван Иванович", 50000, 25),
                new Worker("Сергеев Сергей Сергеевич", 60000, 35),
                new Worker("Андреев Андрей Андреевич", 70000, 45),
                new Worker("Дмитриев Дмитрий Дмитриевич", 80000, 50),
                new Worker("Романов Роман Романович", 90000, 55),
        };
        for (int i = 0; i < w1.length; i++) {
            if (w1[i].getAge() > 40) {
                System.out.printf("Worker: %s of age %d have salary %d\n",
                        w1[i].getFull_name(), w1[i].getAge(), w1[i].getSalary());
            }
        }

        salary_up(w1);

        for (int i = 0; i < w1.length; i++) {
            if (w1[i].getAge() > 45) {
                System.out.printf("Worker: %s of age %d has salary %d (up +5000)\n",
                        w1[i].getFull_name(), w1[i].getAge(), w1[i].getSalary());
            }
        }
        System.out.println("Средняя зарплата по штату сотрудников составляет: " + middle_Salary(w1));
        System.out.println("Средний возраст по штату сотрудников составляет: " + middle_Age(w1));
    }
}
