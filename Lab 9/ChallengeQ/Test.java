public class Test{
    public static void main(String[] args){
        Course c1 = new Course("Math");
        c1.addStudent("Name 1");
        c1.addStudent("Name 2");
        c1.addStudent("Name 3");
        c1.addStudent("Name 4");
        
        Course c2 = c1.clone();
        c2.addStudent("Name 5");
        c2.addStudent("Name 6");
        c2.addStudent("Name 7");
        
        for(String i : c2.getStudents()){
            System.out.println(i+"\n");
        }
        
    }
}