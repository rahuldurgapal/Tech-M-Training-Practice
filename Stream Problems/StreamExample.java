import java.util.*;
import java.util.stream.*;

class User {
    int userId;
    String name;

    public String toString() {
        return "User ID: "+userId + " User Name: "+name;
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

// class NewComparator implements Comparator<User> {
//     public int compare(User u, User v) {
//         return u.userId - v.userId;
//     }
// }
public class StreamExample {
    public static void main(String[] args) {

        List<Integer> arr = List.of(54,32,-43,23,-26,57);
        NewComparator nc = new NewComparator();

        List<User> users = new ArrayList<>();
        users.add(new User(231,"Amit"));
        users.add(new User(321,"Aman"));
        users.add(new User(134,"Amog"));

       List<User> newUsers = users.stream()
            .sorted((u,v) ->  u.userId -v.userId)
            .map(j -> {
               j.userId+=10;
               return j;
            })
            .collect(Collectors.toList());


    



        System.out.println(newUsers);

    

        // Stream<Integer> stream = arr.stream();

        //  stream.map(j -> {
        //     if(j>0){
        //        return j-=5;
        //     } else {
        //         return (j*-1)+5;
        //     }
        
        // List<Integer> list = arr.stream()
        // .map(n -> n*2)
        // .sorted()
        // .collect(Collectors.toList());

        // System.out.println(list);

            // arr.stream()
            // .filter(i -> i>-1)
            // .forEach(c -> System.out.println(c));

        // stream.forEach(n-> System.out.println(n));

      

        // System.out.println("List Elements: "+arr);
        // System.out.println("Stream Elements: ");
        // stream.forEach(n -> System.out.println(n));

        // Stream<Integer> newStream = stream.filter(x -> x>-1);

        // System.out.println("After filter method new Stream: ");
        //  newStream.forEach(n -> System.out.println(n));


    }
}