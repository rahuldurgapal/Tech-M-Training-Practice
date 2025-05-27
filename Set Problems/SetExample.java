import java.util.*;
public class SetExample {

    public static void main(String[] ars) {
        Set<String> allGuest = new HashSet<>();

        allGuest.add("Ravi");
        allGuest.add("Anjali");
        allGuest.add("Ravi");
        allGuest.add("Mohan");

        System.out.println("All Unique Guest: "+allGuest);

        Set<String> newGuest = new LinkedHashSet<>();
        newGuest.add("Aditya");
        newGuest.add("Tushar");
        newGuest.add("Vishal");
        newGuest.add("Tushar");
        newGuest.add("Mayank");

        System.out.println("Guest by Arrival: "+newGuest);


        SortedSet<String> vipGuest = new TreeSet<>();

        vipGuest.add("Vivek");
        vipGuest.add("Arjun");
        vipGuest.add("Pradeep");
        vipGuest.add("Arjun");
        vipGuest.add("Ashish");

        System.out.println("VIP Guest in sorted order: "+vipGuest);

        for(String str: newGuest) {
            System.out.println(str);
        }

        Iterator<String> it = newGuest.iterator();

        while(it.hashNext()) {
            String value = it.next();
            Sysetm.out.println(value);
        }

        if(allGuest.contains("Mohan")){
            System.out.println("Mohan is arrived");
        } else {
            System.out.println("Mohan is not arrived");
        }

        newGuest.remove("Vishal");
        System.out.println("Updated New Guest: "+newGuest);
    }
}