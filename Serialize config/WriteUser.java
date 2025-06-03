import java.io.*;
public class WriteUser{

    public static void main(String[] args) throws IOException {

       File file = new File("user.bin");
        FileOutputStream fos = new FileOutputStream(file,true);
        boolean append = file.exists() && file.length()>0;
        ObjectOutputStream oos = append ? new SerialConfig(fos)
                                      : new ObjectOutputStream(fos);

        User user = new User(234,"Ramesh");
        User user1 = new User(345,"Mahes");
        User user2 = new User(435,"Amit");
        oos.writeObject(user);
        oos.writeObject(user1);
        oos.writeObject(user2);

        fos.close();
        oos.close();
    }
}