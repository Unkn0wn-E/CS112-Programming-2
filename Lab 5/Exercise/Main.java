import Test.*;

public class Main{
    
    public static void main(String[] args){
        Person[] arr = new Person[3];
        arr[0] = new Student("Faisal", 3901404);
        arr[1] = new Faculty( "Employee Name", 00001, "Employee Rank");
        arr[2] = new Staff("Staff Name", 00001, "Some title");
        
        for(Person p : arr){
            System.out.println(p.getClass().getSimpleName() + " Class :");
            System.out.println(p.toString());
            System.out.println();
        }
        
    }
}