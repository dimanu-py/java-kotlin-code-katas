package ocp;

public class ManagerMother {

    public static Employee withSalaryAndBonus(int salary, int bonus) {
        return new Employee(salary, bonus, EmployeeType.MANAGER);
    }
}
