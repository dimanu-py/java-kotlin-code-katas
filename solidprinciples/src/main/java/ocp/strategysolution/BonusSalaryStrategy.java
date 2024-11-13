package ocp.strategysolution;

public class BonusSalaryStrategy implements PaymentStrategy {

    @Override
    public int pay(int salary, int bonus) {
        return salary + bonus;
    }

}
