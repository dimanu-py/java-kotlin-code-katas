package ocp;

public class EngineerMother {

    private static final int ANY_BONUS = 100;

    public static Employee withSalary(int salary) {
        return new Employee(salary, ANY_BONUS, EmployeeType.ENGINEER);
    }

}
