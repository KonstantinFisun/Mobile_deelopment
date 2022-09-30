package calc.operation;
import static java.lang.Math.pow;

public class Squaring {

    private int sqr;
    public Squaring() { sqr=1;}
    public Squaring(int a) { this.sqr = a;}

    public void sqr(int b){
        sqr = (int) pow(sqr,b);
    }

    public int getSqr(){ return sqr;}

}
