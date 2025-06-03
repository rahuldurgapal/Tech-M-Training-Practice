import java.io.*;

public class ReadUser {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // FileInputStream fis = new FileInputStream("user.bin");
        // ObjectInputStream ois = new ObjectInputStream(fis);
        // User user = (User)ois.readObject();
        // User user1 = (User)ois.readObject();
        // User user2 = (User)ois.readObject();
        // System.out.println(user);
        // System.out.println(user1);
        // //System.out.println(user2);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
        try{
            while(true) {
                User user = (User)ois.readObject();
                System.out.println(user);
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //fis.close();
        ois.close();
    }
}