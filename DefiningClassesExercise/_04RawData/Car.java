package DefiningClassesExercise._04RawData;

public class Car {
    public Car(String model, int speed,int power, int weight,String type, Tire[] tires) {
        this.model = model;
        this.carCargo=new Cargo(weight,type);
        this.carEngine = new Engine(speed, power);
        this.tires=tires;
    }

    public boolean isMorePressure (){
        for (int i = 0; i < 4; i++) {
            if (tires[i].getPressure()<1){
                return true;
            }
        }
        return false;
    }

    public boolean hasEnoughPower(){
        if (carEngine.getEnginePower()>250){
            return true;
        }
        return false;
    }

    private String model;

    public Cargo getCarCargo() {
        return carCargo;
    }

    private Engine carEngine;
    private Cargo carCargo;
    private Tire[] tires = new Tire[4];

    public Engine getCarEngine() {
        return carEngine;
    }

    public Tire[] getTires() {
        return tires;
    }
}
