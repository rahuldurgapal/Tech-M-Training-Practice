import java.util.concurrent.*;
public class NewThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(4);

        Runnable task1 = () -> {
            for(int i=1;i<=10;i++) {
                System.out.println("Task 1 by "+ Thread.currentThread().getName() + " " + i);
            }
        };
        Runnable task2 = () -> {
            for(int i=1;i<=10;i++) {
                System.out.println("Task 2 by " + Thread.currentThread().getName() + " " +i);
            }
        };

        Callable<String> call = () -> {
            for(int i=1;i<=10;i++) {
                System.out.println("Task 3 by " + Thread.currentThread().getName() + " " +i);
            }
            return "This is Callable interface";
        };

        service.execute(task1);
        service.execute(task2);
        Future<String> val = service.submit(call);
        System.out.println("Callable value " + val.get());

        service.shutdown();
    }
}