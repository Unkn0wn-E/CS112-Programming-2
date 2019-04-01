import java.util.*;

public class Main {
    
    public static void main(String[] args){
        int[][] nums = {
            {3,5,23,1,51,3},
            {5,233,53,25,11},
            {23,534,523,432,22},
            {3443,221,43,53,27,32}
        };
        int size = 0;
        int temp;
        
        System.out.println("Before the shuffle: ");
        for(int[] i : nums){
            for(int j: i){
                System.out.print(j+" ");
                size++;
            }
            System.out.println();
        }
        
        for(int i = 0; i < size; i++){
            int r1 = new Random().nextInt(nums.length);
            int r2 = new Random().nextInt(nums[r1].length);
            int r3, r4;
            
            while(true){
                r3 = new Random().nextInt(nums.length);
                r4 = new Random().nextInt(nums[r3].length);
                if(r1 != r3 || r2 != r4){
                    break;
                }
            }
            
            temp = nums[r1][r2];
            nums[r1][r2] = nums[r3][r4];
            nums[r3][r4] = temp;
            
        }
        
        System.out.println();
        
        System.out.println("After the shuffle: ");
        for(int[] i : nums){
            for(int j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}