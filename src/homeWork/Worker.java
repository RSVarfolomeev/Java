package homeWork;

public class Worker {
    private String full_name;
    private int salary;
    private int age;

    Worker(String full_name, int salary, int age){
        this.full_name = full_name;
        this.salary = salary;
        this.age = age;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public int getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
