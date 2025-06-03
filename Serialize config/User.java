import java.io.*;
public class User implements Serializable {

    private int id;
    private String name;
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "User Id: " +id + " User Name: " +name;
    }
}