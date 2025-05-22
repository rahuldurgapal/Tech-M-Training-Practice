interface FuleType {
    void getFuelType();
}

abstract class TrnasportAuthority {
    abstract public void registerVehicle();
}
class Vehicle extends TrnasportAuthority{
    private int vehicleId;
    private String brand;
    private int maxSpeed;

    public Vehicle(int vehicleId, String brand, int maxSpeed) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public Vehicle() {

    }


    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setmaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getvehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void start() {
       System.out.println("Vehicle is starting...");
    }

    public void start(String mod) {
        System.out.println("Vehicle is Starting in " +mod);
    }

    public void registerVehicle() {
        System.out.println("Vehicle Register with ID: "+vehicleId);
    }
}

class Car extends Vehicle implements FuleType{

    public Car() {

    }

    public Car(int vehicleId, String brand, int maxSpeed) {
        super(vehicleId, brand, maxSpeed);
    }
   
   @Override
   public void start() {
    System.out.println("Car is starting...");
   }

   public void getFuelType() {
    System.out.println("The car is Petrol Type");
   }
}

class Truck extends Vehicle implements FuleType {

    public Truck(int vehicleId, String brand, int maxSpeed) {
       super(vehicleId, brand, maxSpeed);
       
    }
@Override
 public void start() {
    System.out.println("Truck is Starting...");
 }
 
  public void getFuelType() {
    System.out.println("Truck is Diesel Type");
  }

}

class Bike extends Vehicle {

    public Bike(int vehicleId, String brand, int maxSpeed) {
        super(vehicleId, brand, maxSpeed);
    }
    
    public void start() {
        System.out.println("Bike is Starting..");
    }
}

class ElectricCar extends Car {

    String electricBattery;

    public ElectricCar(int vehicleId, String brand, int maxSpeed, String electricBattery) {
        super(vehicleId, brand,maxSpeed);
        this.electricBattery = electricBattery;
    }

   
    @Override
    public void start() {
        System.out.println("Electric car is starting silently...");
    }
}

public class VechicleManagement {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[]
           {new Car(112, "Toyota",250),
            new Truck(123, "Mahindra", 180),
            new Bike(234,"Honda",220),
            new ElectricCar(124,"Tesla",200,"lithium")
           };

           for(int i=0;i<vehicles.length;i++) {
            Vehicle v = vehicles[i];
            v.start();
            System.out.println(v.getvehicleId());
            System.out.println(v.getBrand());
          System.out.println(v.getMaxSpeed());
          //System.out.println(v.getFuelType());
           
           System.out.println("\n  --------------------------------  \n");
          
           }
            FuleType f = new Car();
           f.getFuelType();
           //vehicles[1].getFuelType();
    }
}