class A extends Thread{
    
    public void run() {
        for(int i=1;i<=10;i++) {
            System.out.println("Thread A: " +i);
        }
    }
}

class B extends Thread{

  public void run(){

    try{
    for(int i=1;i<=10;i++) {
        System.out.println("Thread B: "+i);
        Thread.sleep(2000);
    }
    }catch(InterruptedException e) {
        System.out.println(e.getMessage());
    }
 }

}

public class RunnableExample {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();

        a.start();
        b.start();

    }
}