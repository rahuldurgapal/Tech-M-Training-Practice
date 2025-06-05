class Task1 extends Thread {
    public void run() {
        System.out.println("Document scan..");
        try{
          Thread.sleep(2000);
        }catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("scan complete");
    }
}

class Task2 extends Thread {

    public void run() {
        System.out.println("photo upload...");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Upload complete");
    }
}

public class JoinExample{
    public static void main(String[] args) throws InterruptedException {
        Task1 t = new Task1();
        Task2 t1 = new Task2();

        t.start();
        t1.start();

        t.join();
        t1.join();

        System.out.println("Form Submiteed");
        System.out.println("Form submitted successfully");
    }
}