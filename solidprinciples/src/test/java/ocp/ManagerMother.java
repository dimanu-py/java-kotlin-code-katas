package ocp;

import ocp.inheritancesolution.Manager;

public class ManagerMother {

    public static Employee withSalaryAndBonus(int salary, int bonus) {
        return new Manager(salary, bonus);
    }
}
