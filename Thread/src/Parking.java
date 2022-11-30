import java.util.concurrent.Semaphore;
import javax.swing.*;
import java.awt.*;

public class Parking {
    static int numberPlace = 28; // Количество парковочных мест
    static int numberCar = 1000; // Количество машин
    public static Draw d;
    //Парковочное место занято - true, свободно - false
    private static final boolean[] PARKING_PLACES = new boolean[numberPlace];

    //Устанавливаем флаг "справедливый", в таком случае метод
    //aсquire() будет раздавать разрешения в порядке очереди
    private static final Semaphore SEMAPHORE = new Semaphore(numberPlace, true);

    public static void main(String[] args) throws InterruptedException {
        d = new Draw(numberPlace);

        for (int i = 0; i < numberCar; i++) {
            new Thread(new Car(i)).start();
            int x = (int)(Math.random()*((200-100)+1))+100;
            Thread.sleep(x); // Задержка секунду до следующего
        }
    }

    public static class Car implements Runnable {
        private final int carNumber;
        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.printf("Автомобиль №%d подъехал к парковке.\n", carNumber);
            //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
            //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
            //пока семафор не разрешит доступ
            try {
                SEMAPHORE.acquire();
            } catch (InterruptedException e) {
                return;
            }

            long finish = System.currentTimeMillis();
            long elapsed = finish - start;

            // Парковочное место
            int parkingNumber = -1;

            // Время ожидание превышает
            if(elapsed > 5000){
                parkingNumber = 0;
                SEMAPHORE.release();//, напротив, освобождает ресурс
                System.out.printf("Автомобиль №%d покинул парковку пробыв в ожидании %d\n", carNumber, elapsed);
                return;
            }


            //Ищем свободное место и паркуемся
            synchronized (PARKING_PLACES){
                for (int i = 0; i < numberPlace; i++)
                    if (!PARKING_PLACES[i]) {      //Если место свободно
                        PARKING_PLACES[i] = true;  //занимаем его
                        parkingNumber = i;         //Наличие свободного места, гарантирует семафор
                        d.drawCar(carNumber, i);              // Рисуем машину carNumber на парковочное место i
                        System.out.printf("Автомобиль №%d припарковался на месте %d.\n", carNumber, i);
                        break;
                    }
            }

            int x = (int)(Math.random()*((7000-4000)+1))+4000;
            try {
                Thread.sleep(x);       //Уходим за покупками
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (PARKING_PLACES) {
                PARKING_PLACES[parkingNumber] = false;//Освобождаем место
                d.clearPlace(parkingNumber);
            }

            //release(), напротив, освобождает ресурс
            SEMAPHORE.release();
            System.out.printf("Автомобиль №%d покинул парковку.\n", carNumber);

        }
    }
}