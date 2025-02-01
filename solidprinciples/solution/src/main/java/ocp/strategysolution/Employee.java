package ocp.strategysolution;

public class Employee {

    private final int salary;
    private final int bonus;
    protected PaymentStrategy paymentStrategy;

    public Employee(int salary, int bonus, PaymentStrategy paymentStrategy) {
        this.salary = salary;
        this.bonus = bonus;
        this.paymentStrategy = paymentStrategy;
    }

    public int payAmount() {
        return paymentStrategy.pay(salary, bonus);
    }

}
