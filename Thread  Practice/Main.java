class TicketBooking {

    int seat = 1;

    public  void bookTicket(String user) {
        if(seat>0) {
            System.out.println(user + " is booking seat...");

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println(e);
            }
            seat--;
            System.out.println(user + " successfully booked the seat");
        } else {
            System.out.println(user + " failed to book --seat already booked");
        }
    }
}

class  BookinThread extends Thread {

    TicketBooking ticketBooking;
    String user;

    public BookinThread(String user, TicketBooking ticketBooking) {
        this.user = user;
        this.ticketBooking = ticketBooking;
    }

    public void run() {
        ticketBooking.bookTicket(user);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TicketBooking t = new TicketBooking();
        BookinThread b = new BookinThread("aman",t);
        BookinThread b1 = new BookinThread("amit",t);

        b.start();
        b.join();
        b1.start();
    }
}