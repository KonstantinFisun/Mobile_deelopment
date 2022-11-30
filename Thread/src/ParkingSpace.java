import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ParkingSpace extends JLabel {

    int width;
    int height;
    public ParkingSpace(int width, int height) {
        super();

        this.width = width;
        this.height = height;

        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Выравнивание текста
        setHorizontalTextPosition(JLabel.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Comic Sans", Font.BOLD, 50));
        setForeground(new Color(0xADF50000, true));

        clear();
    }

    public void drawCar(int num){
        DecimalFormat decimalFormat=new DecimalFormat("#.#");
        setText(Integer.toString(num));
        double x = (int)(Math.random()*((7-1)+1))+1;
        String path = "image/" + decimalFormat.format(x) + ".png";
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        setIcon(new ImageIcon(newimg));
    }

    public void clear(){
        setText("");
        setBackground(new Color(0xFFFFFFFF, true));
        ImageIcon imageIcon = new ImageIcon("image/0.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        setIcon(new ImageIcon(newimg));
    }
}
