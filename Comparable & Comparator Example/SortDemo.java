import java.util.*;
// class Student implements Comparable<Student>{
//     int id;
//     String name;

//     public Student(int id, String name) {
//         this.id = id;
//         this.name = name;
//     }

//         public int compareTo(Student s) {
//           return this.name.length() - s.name.length();
//         }

//     public String toString() {
//         return "Student ID: " + id + " Student Name: " +name;
//     }
// }


class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Student ID: " + id + " Student Name: " +name;
    }
}


class StudentComparator implements Comparator<Student> {
    public int compare(Student i, Student j) {
        return i.id - j.id;
    }
}

class StudentComparatorByName implements Comparator<Student> {
    public int compare(Student i, Student j) {
        return i.name.compareTo(j.name);
    }
}
public class SortDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(23,65,76,22,54));
        List<Student> students  = new ArrayList<>();
        students.add(new Student(234,"Ramesh"));
        students.add(new Student(456, "Mahesh"));
        students.add(new Student(326,"Amit"));

        System.out.println(students);
        Comparator c = new StudentComparator();

        Collections.sort(students, c);

        Comparator c1 = new StudentComparatorByName();

        Collections.sort(students,c1);

        System.out.println("\n"+ students);



        System.out.println(students);

        list.add(33);
        list.add(43);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
    }
}