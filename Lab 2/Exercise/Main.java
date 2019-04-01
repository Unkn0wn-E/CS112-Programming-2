public class Main {
   public static void main(String[] args){
        Rectangle r1 = new Rectangle(4 , 40);
        Rectangle r2 = new Rectangle(3.5 , 35.9);
        
        printRect_ALL(r1);
        printRect_ALL(r2);
        
    }
    
    static void printRect_ALL(Rectangle rect){
        System.out.println("\n#Rectangle_"+rect.objID);
        System.out.println("Width: "+rect.width);
        System.out.println("Height: "+rect.height);
        System.out.println("Area: "+rect.getArea());
        System.out.println("Perimeter: "+rect.getPerimeter());
        
    }
    
}

// Rectangel class
class Rectangle {
    
    double width = 1;
    double height = 1;
    static int objCount = 0;
    int objID;
    
    Rectangle(){
     objCount++;
     objID = objCount; 
    }
    
    Rectangle(double w, double h){
        width = w;
        height = h;
        
        objCount++;
        objID = objCount; 
    }
    
    double getArea(){
        return width * height;
    }
    
    double getPerimeter(){
        return 2*(width+height);
    }
    
    
}