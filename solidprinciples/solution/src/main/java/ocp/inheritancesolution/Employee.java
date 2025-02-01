package ocp.inheritancesolution;

public abstract class Employee {

    protected int salary;
    protected int bonus;

    protected Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public abstract int payAmount();

}
