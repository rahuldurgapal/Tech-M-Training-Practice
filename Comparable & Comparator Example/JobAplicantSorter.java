import java.util.*;
class Applicant {
    String name;
    int experience;
    int salary;
    String qualification;

    public Applicant(String name, int experience, int salary, String qualification) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
        this.qualification = qualification;
    }

    public String toString() {
        return "Applicant Name: " +name + " Applicant Experience: " +experience + " Applicant Qualification: " + qualification +
             " Applicant Expected Salary: " + salary;
    }

    
}

public class JobAplicantSorter {

    public static void main(String[] args) {
         List<Applicant> applicants = new ArrayList<>();
         applicants.add(new Applicant("Tushar",4,50000,"B-Tech"));
         applicants.add(new Applicant("Vishal",1,55000,"B-Tech"));
         applicants.add(new Applicant("Anajli",2,65000,"MCA"));
         applicants.add(new Applicant("Aman",1,30000,"MCA"));

         int choice; 
         Scanner sc = new Scanner(System.in);

         do {

            System.out.println("\nChose sorting option");
            System.out.println("1. Sort by Experience");
            System.out.println("2. Sort By Qualification");
            System.out.println("3. Sort BY Expected Salary");
            System.out.println("4. Exit");
            System.out.println("Enter Choice (1-4): ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    Collections.sort(applicants,new Comparator<Applicant>() {
                           public int compare(Applicant i, Applicant j) {
                            return j.experience - i.experience;
                           }
                    });
                    System.out.println("\n Sorted By Experience");
                    System.out.println(applicants);
                    break;
                
                 case 2:
                    Collections.sort(applicants, new Comparator<Applicant>(){
                        public int compare(Applicant i, Applicant j) {
                            return i.qualification.compareTo(j.qualification);
                        }
                    });
                    System.out.println("\n Sorted By Qualification");
                    System.out.println(applicants);

                    break;

                case 3:
                    Collections.sort(applicants, new Comparator<Applicant>() {
                        public int compare(Applicant i, Applicant j) {
                            return i.salary - j.salary;
                        }
                    });

                   System.out.println("\n Sorted By Expected Salary");
                   System.out.println(applicants);
                    break;

                case 4:
                    System.out.println("Exiting from the program");
                    break;

                default:
                    System.out.println("Invalid Choice, Please try again: ");
            }

                    
            }while(choice!=4);
         }
    }
