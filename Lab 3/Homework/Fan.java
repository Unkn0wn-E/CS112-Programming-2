public class Fan{
    
    final int SLOW = 0;
    final int MEDIUM = 1;
    final int FAST = 2;
    
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 4;
    private String color = "red";
    
    public Fan(){
        // pass
    }
    
    // Setters and Getters
    public void setSpeed(final int speed){
        this.speed = speed;
    }
    
    public void setOn(boolean onOrOff){
        this.on = onOrOff;
    }
    
    public void setRadius(double radius){
        this.radius = radius;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public boolean isON(){
        return this.on;
    }
    
    public double getRadius(){
        return this.radius;
    }
    
    public String getColor(){
        return this.color;
    }
    
    // END Setters and Getters
    
    public String toString(){
        if(this.on){
            return 
            "\nFan Speed : "+this.speed+"\n"+
            "Fan color : "+this.color+"\n"+
            "Fan radius: "+this.radius;
        }else{
            return 
            "\n\t-- fan is off --\n"+
            "Fan color : "+this.color+"\n"+
            "Fan radius: "+this.radius;
        }
    }
    
    
}