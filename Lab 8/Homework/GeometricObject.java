import java.util.*;
public abstract class GeometricObject {
    
    private String color;
    private boolean filled;
    private Date dateCreated;
    

    protected GeometricObject(){
        dateCreated = new Date();
    }
    
    protected GeometricObject(String color, boolean filled){
        this();
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    public boolean isFilled(){
        return this.filled;
    }
    
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    
    public Date getDate(){
        return this.dateCreated;
    }
    
    @Override
    public String toString(){
        return "Created at: "+dateCreated+""
                + "\n color: "+color+""
                + "\n are filled: "+filled;
    }
    
    
    public abstract double getArea();
    
    
    public abstract double getPerimeter();
}
