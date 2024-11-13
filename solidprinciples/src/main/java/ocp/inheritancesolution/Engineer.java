package ocp.inheritancesolution;

import ocp.Employee;
import ocp.EmployeeType;

public class Engineer extends Employee {

    public static final int NO_BONUS = 0;

    public Engineer(int salary) {
        super(salary, NO_BONUS, EmployeeType.ENGINEER);
    }

    @Override
    public int payAmount() {
        return salary;
    }
}
