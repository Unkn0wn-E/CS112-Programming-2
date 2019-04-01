import java.util.*;

public class Test {
    public static void main(String[] args){
        
        /* Exercise Question */
        
        // GeometricObject circle = new Circle(2, "blue", false);
        // System.out.println("Date crated of the object is :"+circle.getDate());
        // System.out.println("The color is :"+circle.getColor());
        // System.out.println("The area is : "+circle.getArea());
        // System.out.println("The permieter is :"+circle.getPerimeter());
        
        // System.out.println();
        
        // GeometricObject rect = new Rectangle(100,50, "red", true);
        // System.out.println("Date crated of the object is :"+rect.getDate());
        // System.out.println("The color is :"+rect.getColor());
        // System.out.println("The area is : "+rect.getArea());
        // System.out.println("The permieter is :"+rect.getPerimeter());
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter the length of one side of the square : ");
        double side = input.nextDouble();
        
        System.out.print("Please enter color for the square: ");
        String color = input.next();
        
        boolean filled = false;
        boolean done = false;
        do{
            System.out.print("Will it be filled with that color ? (Yes/No): ");
            switch(input.next().toLowerCase()){
                case "yes":
                    filled = true;
                    done = true;
                    break;
                case "no":
                    filled = false;
                    done = true;
                    break;
                default:
                    System.out.println("Please enter 'yes' or 'no'");
                
            }
        }while(!done);
        input.close();
        
        GeometricObject square = new Square(side,color,filled);
        System.out.println();
        System.out.println("Date created : "+square.getDate());
        System.out.println("Color : "+square.toString());
        System.out.println("Area : "+square.getArea());
        System.out.println("Perimeter : "+square.getPerimeter());
        
        
        
    }
}
