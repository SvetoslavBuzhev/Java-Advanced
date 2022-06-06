package DefiningClassesExercise._03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int travelDistance = 0;
    //constructor
    public Car(String model,double fuel, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount=fuel;
        this.fuelCostPerKm=fuelCostPerKm;
    }

    //getters

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostPerKm() {
        return fuelCostPerKm;
    }

    public int getTravelDistance() {
        return travelDistance;
    }

    public void movingCar(double amountKm){
        double cost =CalculatedDistanceCost(amountKm);
        if (getFuelAmount()<cost){
            System.out.println("Insufficient fuel for the drive");
        }else {
            fuelAmount-=cost;
            travelDistance+=amountKm;
        }
    }

    private double CalculatedDistanceCost(double amountKm) {
        return amountKm*getFuelCostPerKm();
    }
}
