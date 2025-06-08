import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, NullPointerException{


            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
            if (con != null) {
                System.out.println(con);
                System.out.println("Connection Successfull");
            } else {
                System.out.println("Connection failed");
            }

            Statement st = con.createStatement();
            String query = "create table if not exists user(id int primary key auto_increment, name varchar(50) not null, email varchar(50) not null,password varchar(50) not null )";

            int x = st.executeUpdate(query);
            if (x>=0) {
                System.out.println("table created successfully "+x);
            } else {
                System.out.println("Something went wrong");
            }


            String email = "";
            String password = "";
            String comma = "','";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you email");
        email = sc.nextLine();
        System.out.println("Enter you passowrd");
        password = sc.nextLine();

           // String query1 = "insert into user(name, email, password) values ('" +name + comma +email + comma + password + "')";

        String query1 = "update user set email = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(query1);
        ps.setString(1,"vivek@gmail.com");
        ps.setInt(2,3);


       if( ps.executeUpdate()>=0) {
           System.out.println("Update successfully");
       } else {
           System.out.println("update failed");
       }
//       while(rs.next()) {
//           System.out.println("user ID: " + rs.getInt("id"));
//           System.out.println("User name: " + rs.getString("name"));
//           System.out.println("User email: "+rs.getString("email"));
//           System.out.println();
//       }

            con.close();



    }


}