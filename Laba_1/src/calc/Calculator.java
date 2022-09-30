package calc;
import calc.operation.Adder;
import calc.operation.Subtractor;
import calc.operation.Multiplier;
import calc.operation.Divider;
import calc.operation.Squaring;

public class Calculator{


    // Сумма
    public int sum(int... a){
        Adder adder = new Adder();
        for(int i:a){
            adder.add(i);
        }

        return adder.getSum();
    }

    // Вычитатание
    public int subtract(int... a) {
        Subtractor subtractor = new Subtractor(a[0]);
        for (int i = 1; i < a.length; i++) {
            subtractor.sub(a[i]);
        }
        return subtractor.getSub();
    }

    // Умножение
    public int multiplier(int... a) {
        Multiplier multiplier = new Multiplier(a[0]);
        for (int i = 1; i < a.length; i++) {
            multiplier.mult(a[i]);
        }

        return multiplier.getMult();
    }

    // Деление
    public double divider(int... a) {
        Divider divider = new Divider(a[0]);
        for (int i = 1; i < a.length; i++) {
            divider.div(a[i]);
        }
        return divider.getDiv();
    }

    // Возведение в квадрат
    public int squaring(int... a) {
        Squaring squaring = new Squaring(a[0]);
        for (int i = 1; i < a.length; i++) {
            squaring.sqr(a[i]);
        }
        return squaring.getSqr();
    }

}
