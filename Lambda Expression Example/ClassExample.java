// interface MyInterFace {
//     void hello();
//     void bye();
// }


// //This is wihtout anonymous implementaion
// class Sample implements MyInterFace {
//     public void hello() {
//         System.out.println("THis is hello method");
//     }

//     public void bye() {
//         System.out.println("This is bye method");
//     }
// }

// public class ClassExample {
//     public static void main(String[] args) {
//       MyInterFace mi = new Sample();
//       mi.hello();
//       mi.bye();

//       System.out.println();

             
        //This is the example of anonymous class implementations

//       MyInterFace mi2 = new MyInterFace(){
//         public  void hello() {
//             System.out.println("THis is anonymous hello method");
//         }

//         public void bye(){
//             System.out.println("This is anonymous bye method");
//         }
//       };

//       mi2.hello();
//       mi2.bye();

//     }
// }

interface MyInterFace {
    void hello();
}

interface MyNewInterFace {
    int cal(int a, int b);
}

class Sample implements MyInterFace {
    public void hello() {
        Sop():
    }
}

public class ClassExample {
    public static void main(String[] args) {

        MyInterFace mi = () -> {
                    System.out.println("This is lambda expression example");
        } 

        MyNewInterFace m2 = (a,b) -> a+b;

        System.out.println(m2.cal(6,2));
        

        mi.hello();
    }
}