import javax.swing.*;
import java.awt.*;

public class Cell extends JLabel {

    public Cell() {
        super();
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Consolas", Font.BOLD, 90));
        setForeground(new Color(0x766D65));
    }

    public void draw(int number){
        switch (number) {
            case 0 -> {
                setText("");
                setBackground(new Color(0xCCC0B3));
            }
            case 2 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 90));
                setText(String.valueOf(2));
                setBackground(new Color(0xECE2D9));
                setForeground(new Color(0x766D65));
            }
            case 4 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 90));
                setText(String.valueOf(4));
                setBackground(new Color(0xEBDEC7));
                setForeground(new Color(0x766D65));
            }
            case 8 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 90));
                setText(String.valueOf(8));
                setBackground(new Color(0xF0B078));
                setForeground(new Color(0xF7F4F0));
            }
            case 16 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 75));
                setText(String.valueOf(16));
                setBackground(new Color(0xF39463));
                setForeground(new Color(0xF7F4F0));
            }
            case 32 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 75));
                setText(String.valueOf(32));
                setBackground(new Color(0xF47B5F));
                setForeground(new Color(0xF7F4F0));
            }
            case 64 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 75));
                setText(String.valueOf(64));
                setBackground(new Color(0xF45E3B));
                setForeground(new Color(0xF7F4F0));
            }
            case 128 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 60));
                setText(String.valueOf(128));
                setBackground(new Color(0xEBCE71));
                setForeground(new Color(0xF7F4F0));
            }
            case 256 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 60));
                setText(String.valueOf(256));
                setBackground(new Color(0xE9CC5D));
                setForeground(new Color(0xF7F4F0));
            }
            case 512 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 60));
                setText(String.valueOf(512));
                setBackground(new Color(0xEAC43C));
                setForeground(new Color(0xF7F4F0));
            }
            case 1024 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 45));
                setText(String.valueOf(1024));
                setBackground(new Color(0xEAC43E));
                setForeground(new Color(0xF7F4F0));
            }
            case 2048 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 45));
                setText(String.valueOf(2048));
                setBackground(new Color(0xEAC12F));
                setForeground(new Color(0xF7F4F0));
            }
            case 4096 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 45));
                setText(String.valueOf(4096));
                setBackground(new Color(0xE7B61F));
                setForeground(new Color(0xF7F4F0));
            }
            case 8192 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 45));
                setText(String.valueOf(8192));
                setBackground(new Color(0xF1BB10));
                setForeground(new Color(0xF7F4F0));
            }
            case 16284 -> {
                setFont(new Font("Comic Sans", Font.BOLD, 45));
                setText(String.valueOf(16284));
                setBackground(new Color(0x000000));
                setForeground(new Color(0xF7F4F0));
            }
        }

    }
}
