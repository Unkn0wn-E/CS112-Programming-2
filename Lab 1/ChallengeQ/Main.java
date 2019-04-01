import java.util.Arrays;

public class Main{
    
    static java.util.Scanner input = new java.util.Scanner(System.in);
    public static void main(String[] args){
        
        boolean identical = true;
        
        //--------Fisrt Array------------//
        
        System.out.print("How many elements (the size) in the first array: ");
        int raw1 = input.nextInt();
        int col1 = input.nextInt();
        
        int[][] arr1 = new int[raw1][col1];
        
        System.out.println("Enter the elements of the first array: ");
        for(int i = 0 ; i < arr1.length; i++){
            
            for(int j = 0; j < arr1[i].length; j++){
                arr1[i][j] = input.nextInt();
            }
            
        }
        
        //--------Second Array------------//
        
        System.out.print("\nHow many elements (the size) in the second array: ");
        int raw2 = input.nextInt();
        int col2 = input.nextInt();
        
        int[][] arr2 = new int[raw2][col2];
        
        System.out.println("Enter the elements of the second array: ");
        for(int i = 0 ; i < arr2.length; i++){
            
            for(int j = 0; j < arr2[i].length; j++){
                arr2[i][j] = input.nextInt();
            }
            
        }
        
        //-------Check---------//
        
        if(raw2 != raw1 || col2 != col1){
            System.out.println("The size of the two arrays are not equals");
            return;
        }
        
        for(int i = 0; i < arr1.length; i++){
            Arrays.sort(arr1[i]);
            Arrays.sort(arr2[i]);
            
            for(int j = 0; j < arr1[i].length; j++){
                if(arr2[i][j] != arr1[i][j]){
                    
                    identical = false;
                    break;
                }
            }
            
            if(!identical){
                System.out.println("The two arrays are not identical arrays");
                break;
            }
        }
        
        if(identical){
            System.out.println("The two arrays are equal and identical");
        }
    }
    
    
    
}