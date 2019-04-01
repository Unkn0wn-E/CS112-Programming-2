import java.util.Scanner;
import java.util.Arrays;

class Lab1{
    
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        boolean exit = true;
        
        do{
            System.out.println("1- Simple Calculator");
            System.out.println("2- Total sum of Numbers");
            System.out.println("3- sort 2D Array");
            
            System.out.println();
            System.out.print("~ Enter any number from the list: ");
            int n = input.nextInt();
            
            switch(n){
                case 1: 
                    simpleCalc();
                    break;
                case 2: 
                    totalNum();
                    break;
                case 3: 
                    sort2D();
                    break;
                default:
                    System.out.println("nothing like "+ n + " in the list !");
                    break;
            }
            
            System.out.print("\n\n ~ Run the program again ? (Y/N)");
            String again = input.next();
            
            if(again.equalsIgnoreCase("y")){
                exit = false;
                for(int i = 10; i > 0; i--){System.out.println();}
            }else{
                exit = true;
            }

        }while(!exit);
        
        
    }
    
    static void simpleCalc(){
        System.out.print("\nEnter the first number: ");
        double n1 = input.nextDouble();
        
        System.out.print("Enter the second number: ");
        double n2 = input.nextDouble();
        
        System.out.print("\nEnter the operation: ");
        String op = input.next();
        
        if(op.equalsIgnoreCase("+")){
            System.out.println(n1 + n2);
            
        }else if(op.equalsIgnoreCase("-")){
            System.out.println(n1 - n2);
            
        }else if(op.equalsIgnoreCase("*")){
            System.out.println(n1 * n2);
            
        }else if(op.equalsIgnoreCase("/")){
            if(n2 == 0){
                System.out.println("You can't divide by zero !");
            }else{
                System.out.println(n1 / n2);
            }
        }else{
            System.out.println("Eneter a valid operation !");
        }
    }
    
    
    
    static void totalNum(){
        System.out.println("\nHow many numbers you want to type ? ");
        System.out.print("Size : ");
        int size = input.nextInt();
        int total = 0;
        
        double[] nums = new double[size];
        
        System.out.println("\nEnter the numbers :");
        
        for(int i = 0; i < nums.length; i++){
            System.out.print((i + 1) + " - ");
            nums[i] = input.nextDouble();
        }
        
        for(double i : nums){
            total += i;
        }
        
        System.out.println("\nThe Total is : "+ total);
        
    }
    
    
    static void sort2D(){
        System.out.print("\nEnter the numbers of row: ");
        int row = input.nextInt();
        
        System.out.print("Enter the numbers of column: ");
        int col = input.nextInt();
        
        double[][] arr = new double[row][col];
        
        System.out.println("\nEnter the numbers");
        
        for(int i = 0; i < arr.length; i++){
            
            System.out.println("Row: "+(i + 1));
            
            for(int j = 0 ; j < arr[i].length; j++){
                arr[i][j] = input.nextDouble();
            }
            
            Arrays.sort(arr[i]);
            System.out.println();
        }
        
        System.out.println("\nSort the array...");
        for(double[] i : arr){
            for(double j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        
    }
    
}