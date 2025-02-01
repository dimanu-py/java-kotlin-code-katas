package ocp.inheritancesolution;

public class Engineer extends Employee {

    public static final int NO_BONUS = 0;

    public Engineer(int salary) {
        super(salary, NO_BONUS);
    }

    @Override
    public int payAmount() {
        return salary;
    }
}
