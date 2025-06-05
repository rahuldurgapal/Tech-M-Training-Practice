import java.time.*;
public class DigitalClock implements Runnable {
    
    public void run() {
        try{

            while(true) {
                System.out.println(LocalTime.now());
                Thread.sleep(1000);
            }

        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new DigitalClock());
        t.start();
    }
}