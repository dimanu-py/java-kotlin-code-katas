package ocp.strategysolution;

public class FixedSalaryStrategy implements PaymentStrategy {

    @Override
    public int pay(int salary, int bonus) {
        return salary;
    }
}
