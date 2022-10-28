import javax.swing.*;
import java.awt.*;


public class Draw extends JFrame {

    public Cell[][] cells;
    public int size;
    Draw(int size){
        super("2048");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getRootPane().setBackground(new Color(0xBAAC9F));
        getContentPane().setBackground(new Color(0xBAAC9F));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));;
        setLayout(new GridLayout(4,4,10,10));
        this.size = size;
        cells = new Cell[size][size];

        //Отрисовка пустых клеток

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell();
                add(cells[i][j]);
            }
        }

        setVisible(true);
    }

    //Раскраска ячейки
    public void draw_cell(Board board){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j].draw(board.getState(i,j));
            }
        }
    }

}
