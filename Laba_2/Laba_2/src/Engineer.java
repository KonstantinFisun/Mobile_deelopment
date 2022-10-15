public class Engineer extends Scientist {

    public Engineer(String name, int salary, int seniority) {
        super(name, salary, seniority);
    }

    @Override
    public String toString() {
        return "Инженер " + this.getName() + " с зарплатой " + this.getSalary() + " стаж " + this.getSeniority();
    }

    @Override
    public double countSalary() {
        return Math.round(this.getSalary() * (1 + this.getSeniority() * 0.01));
    }
}
