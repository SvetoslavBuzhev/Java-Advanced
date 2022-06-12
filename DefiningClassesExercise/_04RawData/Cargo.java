package DefiningClassesExercise._04RawData;

public class Cargo {


    private int CargoWeight;
    private String CargoType;

    public Cargo(int cargoWeight, String cargoType) {
        setCargoType(cargoType);
        setCargoWeight(cargoWeight);
    }

    public int getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        CargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }


}
