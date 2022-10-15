public class Junior_Scientist extends Scientist{

    public Junior_Scientist(String name, int salary, int seniority) {
        super(name, salary, seniority);
    }

    @Override
    public String toString() {
        return "Младший научный сотрудник " + this.getName() + " с зарплатой " + this.getSalary() + " стаж " + this.getSeniority();
    }

    @Override
    public double countSalary() {
        return Math.round(this.getSalary() * (1 + this.getSeniority() * 0.02));
    }

}
