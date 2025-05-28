import java.util.*;

public class SortDigitExample {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(26,27,21,32,34);
        System.out.println(arr + "\n");
       Collections.sort(arr,new SortDigit());

       System.out.println(arr);
    }
}

class SortDigit implements Comparator<Integer> {
    public int compare(Integer i, Integer j) {
        return i%10-j%10;
    }
}