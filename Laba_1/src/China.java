import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;

public class China extends JPanel{

    public static void main(String[] args){
        // Создание рамки с именем
        JFrame frame = new JFrame ("Flag China");

        // getContentPane возвращает область
        // add добавление элемента в область
        frame.getContentPane().add(new China(800));

        // Устанавливает объекты внутри frame
        frame.pack();

        // Установка закрытия окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Установка рамки по центру
        frame.setLocationRelativeTo(null);

        // Установка видимости рамки
        frame.setVisible(true);
    }

    /**
     Создайте пятиконечную форму звезды.
     Координата центра пятиконечной звезды равна (sx, sy), расстояние от центра до вершины равно радиусу,
     а угол смещения линии между вершиной и центром равен тета (радиан)
     @ возвратный пентакль a
     */
    public static Shape createPentacle(double sx,double sy,double radius,double theta){
        final double arc = Math.PI/5; // Угол смещения
        final double rad = Math.sin(Math.PI/10)/Math.sin(3*Math.PI/10); // Радиан
        GeneralPath path = new GeneralPath();
        path.moveTo(1,0);

        for(int idx = 0;idx < 5;idx ++){
            path.lineTo(rad*Math.cos((1+2*idx)*arc),rad*Math.sin((1+2*idx)*arc));
            path.lineTo(Math.cos(2*(idx+1)*arc),Math.sin(2*(idx+1)*arc));
        }
        path.closePath();
        AffineTransform atf = AffineTransform.getScaleInstance(radius,radius);
        atf.translate(sx/radius,sy/radius);
        atf.rotate(theta);
        return atf.createTransformedShape(path);
    }

    private int width,height;
    private double maxR = 0.15, minR = 0.05;
    private double maxX = 0.25, maxY = 0.25;
    private double[] minX = {0.50, 0.60, 0.60, 0.50};
    private double[] minY = {0.10, 0.20, 0.35, 0.45};


    //Создать флаг с шириной
    public China(int width){
        this.width =  width/3*3;
        this.height = width/3*2;

        // Установка размеров
        setPreferredSize(new Dimension(this.width,this.height));
    }

    // Отрисовка содержимого
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        // нарисовать красную область
        g2d.setPaint(Color.RED);
        g2d.fillRect(0,0,width,height);

        // Рисуем большой ☆
        double ox = height*maxX, oy = height*maxY;
        g2d.setPaint(Color.YELLOW); // Цвет желтый
        g2d.fill(createPentacle(ox,oy,height*maxR,-Math.PI/2)); // Рисуем звезду

        // Рисуем маленьким ★
        for(int idx =0;idx < 4;idx ++){
            double sx = minX[idx]*height, sy = minY[idx]*height;
            double theta = Math.atan2(oy-sy,ox-sx);
            g2d.fill(createPentacle(sx,sy,height*minR,theta));
        }
    }
}