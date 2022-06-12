package DefiningClassesExercise._04RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int speed,int power){
        setEngineSpeed(speed);
        setEnginePower(power);
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }


    public int getEngineSpeed(){
        return engineSpeed;
    }

    public int getEnginePower(){
        return enginePower;
    }
}
