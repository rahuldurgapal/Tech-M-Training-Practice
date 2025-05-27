import java.util.*;

public class MapExample {
    public static void main(String[] args) {

        Map<Integer, String> studentMap = new HashMap<>();
        studentMap.put(101,"Ayush");
        studentMap.put(103,"Aditya");
        studentMap.put(null,"Virat");
        studentMap.put(null,"Virat");
        studentMap.put(102,"Suresh");
        studentMap.put(103,"Ankit");

        Set<Integer> keys = studentMap.keySet();

        System.out.println(keys);

        System.out.println(studentMap.get(103));


        System.out.println("Students Details are: ");

        for(Map.Entry<Integer, String> mp: studentMap.entrySet()) {
            System.out.println("Roll no: "+ mp.getKey() + " Name: " +mp.getValue());
        }

      System.out.println();

        Map<String, Integer> cart = new LinkedHashMap<>();
        cart.put("Laptop",2);
        cart.put("Mouse",3);
        cart.put("Keyboard",1);
        cart.put(null,null);
        cart.put(null,4);

        System.out.println("Shoppin Carts are: ");

        for(Map.Entry<String, Integer> mp: cart.entrySet()) {
            System.out.println("Item: " + mp.getKey() + " Quantity: "+mp.getValue());
        }
       
       System.out.println();

        Map<Integer,String> emp = new TreeMap<>();
        emp.put(234,"Tushar");
        emp.put(324,"Vivek");
        // emp.put(null, "Abhishek");
        // emp.put(null, "Abhishek");
        emp.put(435,"Vishal");
        emp.put(324,"Mayank");

        System.out.println("Employees Details are in Sorted ");
        for(Map.Entry<Integer,String> mp: emp.entrySet()) {
            System.out.println("Emp ID: "+mp.getKey() + " Emp Name: "+mp.getValue());
        }

        System.out.println();

        Map<String, String> users = new Hashtable<>();
        users.put("admin","admin@123");
        users.put("admin1","admin1@123");
        users.put("admin3", "admin321");
        users.put("admin2","admin23");

        System.out.println("Users details are: ");

        for(Map.Entry<String,String> mp: users.entrySet()) {
            System.out.println("Username: "+mp.getKey() + " Password: "+mp.getValue());
        }
    }
}