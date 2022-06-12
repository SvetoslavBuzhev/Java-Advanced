package DefiningClassesExercise._05CarSalesMan;

public class Car {

    private String model;
    private Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car (String[] carInfo,Engine engine){
        setModel(carInfo[0]);
        setEngine(engine);
        if (carInfo.length==4){
            setWeight(carInfo[2]);
            setColor(carInfo[3]);
        }else if ( carInfo.length == 3){
            try{
                int we = Integer.parseInt(carInfo[2]);
                setWeight(String.valueOf(we));
            }catch (Exception e){
                setColor(carInfo[2]);
            }
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %d\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s"
                              ,getModel(),getEngine().getModel(),getEngine().getPower(),getEngine().getDisplacement()
                              ,getEngine().getEfficiency(),getWeight(),getColor());
    }
}
