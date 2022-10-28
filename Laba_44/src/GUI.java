import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI extends JFrame {

    GUI(String title) {
        super(title);
        this.setSize(500, 500); // Размер окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Закрывает окно
        this.setVisible(true); // Видимость
        this.setLocation(500, 200); // Локация окна


    }

    public void add_label(){
        JLabel label = new JLabel("Hello, world!");
        Font font = new Font("Century Gothic", Font.BOLD, 18);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(font);
        this.add(label);

        JLabel label_1 = new JLabel("My name is Gosha");
        label_1.setVerticalAlignment(JLabel.CENTER);
        label_1.setHorizontalAlignment(JLabel.CENTER);
        label_1.setFont(font);
        this.add(label_1);
    }

}
