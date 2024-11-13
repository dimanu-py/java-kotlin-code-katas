package ocp;

public class Employee {

    protected int salary;
    protected int bonus;
    private EmployeeType type;

    public Employee(int salary, int bonus, EmployeeType type) {
        this.salary = salary;
        this.bonus = bonus;
        this.type = type;
    }

    public int payAmount() {
        switch (this.type) {
            default:
                return 0;
        }
    }

}
