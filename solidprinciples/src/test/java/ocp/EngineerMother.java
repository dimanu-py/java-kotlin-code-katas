package ocp;

import ocp.inheritancesolution.Engineer;

public class EngineerMother {

    public static Employee withSalary(int salary) {
        return new Engineer(salary);
    }

}
