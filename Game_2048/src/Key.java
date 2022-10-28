import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    // Считывание последних данных из стека событий, это необходимо
    /* Данные о вводе за последнюю итераци. */
    private boolean wasEscPressed;
    private Direction lastDirectionKeyPressed;

    /**
     * Считывание последних данных из стека событий
     */
    public void update() {
        lastDirectionKeyPressed = Direction.AWAITING;
    }

    // Обнуление данных, полученых в при предыдущих запросах

    // Возвращает направление последней нажатой стрелочки
    public Direction lastDirectionKeyPressed() {
        return lastDirectionKeyPressed;
    }

    public void lastDirectionKeyPressedSet(Direction direct){
        lastDirectionKeyPressed = direct;
    }

    // Возвращает информацию о том, был ли нажат ESCAPE за последнюю итерацию
    public boolean wasEscPressed() {
        return wasEscPressed;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        lastDirectionKeyPressed = Direction.AWAITING;
        wasEscPressed = false;
        if (e.getKeyCode()==KeyEvent.VK_UP){
            lastDirectionKeyPressed = Direction.DOWN;
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            lastDirectionKeyPressed = Direction.RIGHT;
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            lastDirectionKeyPressed = Direction.UP;
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            lastDirectionKeyPressed = Direction.LEFT;
        }
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            wasEscPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

