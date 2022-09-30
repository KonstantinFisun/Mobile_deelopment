package calc.operation;

public class Subtractor {
    private int sub;
    public Subtractor() { sub=0;}
    public Subtractor(int a) { this.sub = a;}
    public void sub(int b){
        sub -= b;
    }
    public int getSub(){ return sub;}

}
