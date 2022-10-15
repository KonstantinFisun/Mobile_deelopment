public abstract class Scientist {
    private int salary, seniority;
    private String name;

    // Конструктор
    public Scientist(String name, int salary, int seniority) {
        this.name = name;
        this.salary = salary;
        this.seniority = seniority;
    }

    // Геттеры и сеттеры
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //-----------------------------
    abstract double countSalary();

    public String hire() {
        return "Сотрудник принят на должность";
    }
    public String fire() {
        return "Сотрудник уволен с должности";
    }
    public String replace() {
        return "Сотрудник переведен с должности";
    }
    public double calculate_salary() {
        return this.countSalary();
    }

    //----------------------------------------
    //Переопределение equals
    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof Scientist emp) {
            if (salary == emp.salary && seniority == emp.seniority && name.equals(emp.name))
                result = true;
        }
        return result;
    }

    //Переопределение equals
    public String toString() {
        return "Научный сотрудник" + this.name + "c зарплатой: " + this.salary + ", стаж: " + this.seniority;
    }


}
