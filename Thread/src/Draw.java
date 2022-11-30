import javax.swing.*;
import java.awt.*;

public class Draw extends JFrame{

    public int size;
    public ParkingSpace[] parks;


    Draw(int size){
        super("Парковка");
        setBounds(700,200,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setBackground(new Color(0xBAAC9F));
        getContentPane().setBackground(new Color(0xBAAC9F));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.size = size;
        parks = new ParkingSpace[size];


        // Размеры кнопок
        int width = 100;
        int height = 100;

        //Отрисовка пустых клеток
        for(int i = 0; i < size; i++){
            parks[i] = new ParkingSpace(width, height);
            add(parks[i]);
        }

        setVisible(true);
    }

    public void drawCar(int carNumber, int numberPlace){
        parks[numberPlace].drawCar(carNumber);
    }

    public void clearPlace(int numberPlace){
        parks[numberPlace].clear();
    }
}
