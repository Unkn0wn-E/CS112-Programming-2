package Test;

public class Faculty extends Employee{
    
    private String rank;
    
    public Faculty(String name, int employeeId, String rank){
        setName(name);
        setemployeeId(employeeId);
        this.rank = rank;
    }
    
    @Override
    public String toString(){
        return getName() + " - " + getemployeeId() + " - " + rank;
    }
}