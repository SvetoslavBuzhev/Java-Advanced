package DefiningClassesExercise._07Google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car (String carModel,int carSpeed){
        setCarModel(carModel);
        setCarSpeed(carSpeed);
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed = carSpeed;
    }
    @Override
    public String toString(){
       return String.format("%s %d",carModel,carSpeed);
    }
}
