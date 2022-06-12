package DefiningClassesExercise._07Google;

public class Company {
    private String companyName;
    private String companyDepartment;
    private double salary;

    public Company (String companyName,String companyDepartment,double salary){
        setCompanyName(companyName);
        setCompanyDepartment(companyDepartment);
        setSalary(salary);
    }
    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public double getSalary() {
        return salary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString(){
        return String.format("%s %s %.2f",getCompanyName(),getCompanyDepartment(),getSalary());
    }
}
