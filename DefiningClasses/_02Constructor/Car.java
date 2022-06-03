package DefiningClassesLab;

public class Car {
    private
    String brand;
    String model;
    int horsePower;


    public
    Car (String brand){
        setBrand(brand);
        setModel("unknown");
        setHorsePower(-1);
    }
    Car (String brand,String model,int HorsePower){
        setBrand(brand);
        setModel(model);
        setHorsePower(HorsePower);
    }
    void setBrand(String brand) {
        this.brand = brand;
    }

    void setModel(String model) {
        this.model = model;
    }

    void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    String getBrand() {
        return this.brand;
    }

    String getModel() {
        return this.model;
    }

    int getHorsePower() {
        return this.horsePower;
    }

    String carInfo() {

        return String.format("The car is: %s %s - %d HP.", getBrand(), getModel(),getHorsePower());
    }
}
