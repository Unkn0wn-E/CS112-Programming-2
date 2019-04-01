package Test;

public class Student extends Person{
    
    private long studentId;
    
    public Student(String name, long studentId){
        setName(name);
        this.studentId = studentId;
    }
    
    @Override
    public String toString(){
        return getName() + " - " + this.studentId;
    }
    
}