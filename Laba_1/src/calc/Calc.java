package calc;

public class Calc {
    public static void main(String[] args) {
        System.out.println("Hello!");
        Calculator calc = new Calculator();
        System.out.println("2 + 2 = " + calc.sum(2,2));
        System.out.println("5 - 3 = " + calc.subtract(5,3));
        System.out.println("2 * 10 = " + calc.multiplier(2,10));
        System.out.println("12 / 4 = " + calc.divider(12,4));
        System.out.println("2 ** 4 = " + calc.squaring(2,4));
    }

}