public class Test{
    
    public static void main(String[] args){
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();       
         
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        
        fan2.setSpeed(fan1.MEDIUM);
        fan2.setRadius(4);
        fan2.setColor("red");
        fan2.setOn(false);
        
        System.out.println(fan1);
        System.out.println(fan2);
    }
}