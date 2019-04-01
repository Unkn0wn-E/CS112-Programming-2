import java.util.*;

public class ConsecutiveFour {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of row: ");
        int row = input.nextInt();

        System.out.print("Number of column: ");
        int col = input.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        
        System.out.println("\n~"+isConsecutiveFour(arr));

    }

    public static boolean isConsecutiveFour(int[][] values) {
        String index;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length - 3; j++) {
                if (values[i][j] == values[i][j + 1]) {
                    if (values[i][j + 1] == values[i][j + 2]) {
                        if (values[i][j + 2] == values[i][j + 3]) {
                            index = i + "-" + j + " " + i + "-" + (j + 1) + " " + i + "-" + (j + 2) + " " + i + "-" + (j + 3);
                            printAndMark(values, index);
                            return true;

                        }
                    }
                }
            }
        }

        for (int i = 0; i < values.length - 3; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[i + 1][j]) {
                    if (values[i + 1][j] == values[i + 2][j]) {
                        if (values[i + 2][j] == values[i + 3][j]) {
                            index = i + "-" + j + " " + (i + 1) + "-" + j + " " + (i + 2) + "-" + j + " " + (i + 3) + "-" + j;
                            printAndMark(values, index);
                            return true;

                        }
                    }
                }
            }
        }

        for (int i = 0; i < values.length - 3; i++) {
            for (int j = values[i].length - 1; j > 2; j--) {
                if (values[i][j] == values[i + 1][j - 1]) {
                    if (values[i + 1][j - 1] == values[i + 2][j - 2]) {
                        if (values[i + 2][j - 2] == values[i + 3][j - 3]) {
                            index = i + "-" + j + " " + (i + 1) + "-" + (j - 1) + " " + (i + 2) + "-" + (j - 2) + " " + (i + 3) + "-" + (j - 3);
                            printAndMark(values, index);
                            return true;

                        }

                    }
                }
            }
        }

        for (int i = values.length - 1; i > 2; i--) {
            for (int j = values[i].length - 1; j > 2; j--) {
                if (values[i][j] == values[i - 1][j - 1]) {
                    if (values[i - 1][j - 1] == values[i - 2][j - 2]) {
                        if (values[i - 2][j - 2] == values[i - 3][j - 3]) {
                            index = i + "-" + j + " " + (i - 1) + "-" + (j - 1) + " " + (i - 2) + "-" + (j - 2) + " " + (i - 3) + "-" + (j - 3);
                            printAndMark(values, index);
                            return true;

                        }
                    }
                }

            }
        }

        return false;
    }

    public static void printAndMark(int[][] array, String index){
        String[] in = index.split(" ");
        boolean print = true;
        boolean allow = true;
        System.out.println("\n");
        
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                print = true;
                
                for(int s = 0; s < in.length; s++){
                    int dashIndex = in[s].indexOf("-");
                    
                    if(i == Integer.parseInt(in[s].substring(0,dashIndex))&& j == Integer.parseInt(in[s].substring(dashIndex+1))){
                        System.out.print("{"+array[i][j]+"}");
                        print = false;
                        allow = false;
                        break;
                    }
                    
                    if(j > 0 && s == in.length - 1 && allow)
                    System.out.print(" ");
                    
                    if(s == in.length - 1)
                    allow = true;
                }
                
                if(print)
                System.out.print(array[i][j]);
                
            }
            
            System.out.println();
        }
    }

}
