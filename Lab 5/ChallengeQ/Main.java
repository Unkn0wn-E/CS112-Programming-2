import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        
        System.out.print("Enter 10 numbers:");
        for(int i = 0; i < 10; i++){
            
            if(input.hasNextInt()){
                
                arr.add(input.nextInt());
                
            }
        }
        
        input.close();
        
        removeDuplicate(arr);
        
        System.out.print("The distinct integers are: ");        
        for(Integer i: arr){
            System.out.print(i + " ");
        }
        
        
    }
    
    public static void removeDuplicate(ArrayList<Integer> list){
        
        for(int i = 0; i < list.size(); i++){
            
            for(int j = 0; j < list.size(); j++){
                
                if(j == i)continue;
                
                if(list.get(i) == list.get(j)){
                    list.remove(j);
                    j = 0;
                }
            }
            
        }
        
        
    }
    
    
}