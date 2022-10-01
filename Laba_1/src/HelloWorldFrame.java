import java.awt.*;
import java.awt.event.*;

public class HelloWorldFrame extends Frame{
    HelloWorldFrame(String s){
        super(s);
    }

    public void paint(Graphics g){
        g.setFont(new Font("Consoles", Font.ITALIC | Font.BOLD,30));
        g.drawString("Здрав", 20, 100);
    }

    public static void main(String[] args) {
        Frame f = new HelloWorldFrame("Здравствуй");
        f.setSize(400, 150);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
