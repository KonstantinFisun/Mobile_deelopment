import java.awt.*;
import java.awt.event.*;


public class GraphTest01 extends Frame{
    GraphTest01(String s){
        super(s);
        setBounds(0, 0, 500, 300);
        setVisible(true);
    }

    public void paint(Graphics g){
        Dimension d = getSize();
        int dx = d.width / 20, dy = d.height / 20;
        int myWidth = 250, myHeight = 250;
        g.drawLine(0, 0, myWidth, myHeight);
        g.drawLine(0, 0, d.width, d.height);
        setBackground(Color.blue);
        setForeground(Color.black);
    }

    public static void main(String[] args) {
        GraphTest01 f = new GraphTest01("Рисуем");
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
