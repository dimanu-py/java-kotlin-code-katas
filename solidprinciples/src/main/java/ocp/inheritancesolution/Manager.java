package ocp.inheritancesolution;

public class Manager extends Employee {

    public Manager(int salary, int bonus) {
        super(salary, bonus);
    }

    @Override
    public int payAmount() {
        return salary + bonus;
    }
}
