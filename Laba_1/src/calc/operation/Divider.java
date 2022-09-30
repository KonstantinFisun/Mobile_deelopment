package calc.operation;

public class Divider {
    private int div;
    public Divider() { div=1;}
    public Divider(int a) { this.div = a;}

    public void div(int b){
        div /= b;
    }

    public int getDiv(){ return div;}

}
