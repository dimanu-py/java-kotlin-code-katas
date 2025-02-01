package ocp;

import ocp.inheritancesolution.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeShould {

    private static final int BONUS = 100;
    private static final int SALARY = 1000;

    @Test
    void not_add_bonus_to_the_engineer_pay_amount() {
        Employee engineer = EngineerMother.withSalary(SALARY);

        int finalSalary = engineer.payAmount();

        assertThat(finalSalary).isEqualTo(SALARY);
    }

    @Test
    void add_bonus_to_the_manager_pay_amount() {
        Employee manager = ManagerMother.withSalaryAndBonus(SALARY, BONUS);

        int finalSalary = manager.payAmount();

        assertThat(finalSalary).isEqualTo(SALARY + BONUS);
    }
}
