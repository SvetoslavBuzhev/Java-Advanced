package DefiningClassesExercise._05CarSalesMan;

public class Engine {
    private String model;
    private int power;

    private String displacement = "n/a";
    private String efficiency = "n/a";

    public Engine(String[] input){
        setModel(input[0]);
        setPower(Integer.parseInt(input[1]));
        if (input.length==4){
            setDisplacement(input[2]);
            setEfficiency(input[3]);
        }else if (input.length==3){
            try{
                int displace = Integer.parseInt(input[2]);
                setDisplacement(String.valueOf(displace));
            }catch (Exception e){
                setEfficiency(input[2]);
            }
        }
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
