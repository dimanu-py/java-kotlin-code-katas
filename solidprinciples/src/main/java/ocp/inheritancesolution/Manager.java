package ocp.inheritancesolution;

import ocp.Employee;
import ocp.EmployeeType;

public class Manager extends Employee {

    public Manager(int salary, int bonus) {
        super(salary, bonus, EmployeeType.MANAGER);
    }

    @Override
    public int payAmount() {
        return salary + bonus;
    }
}
