package Test;

public class Staff extends Employee{
    private String title;
    
    public Staff(String name, int employeeId, String title){
        setName(name);
        setemployeeId(employeeId);
        this.title = title;
    }

    @Override
    public String toString(){
        return getName() + " - " + getemployeeId() + " - " + title;
    }
}