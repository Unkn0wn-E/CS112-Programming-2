import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactors {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("To use the prime factors you must enter a positive integer which is greater than one:");
        int num = input.nextInt();
        if(num <= 1){
            System.out.println("** You have to enter a number greater than one\n".toUpperCase());
            PrimeFactors.main(new String[0]);
        }

        primeFactors(num).showStack_Reverse();

        System.out.print("\n\nPrinting prime numbers under " + num + ":\n");
        primeNumber(num).showStack_Reverse();
    }

    
    
    public static StackOfIntegers primeFactors(int num) {
        StackOfIntegers stack = new StackOfIntegers();
        Integer[] primeNumbers = primeNumber_Array(num);

        double number = num;
        boolean again = false;

        for (int i = 0; i < primeNumbers.length; i++) {
            if (again) i = 0;
            double check = number / primeNumbers[i];

            if ((check % 1) == 0) {
                stack.push(primeNumbers[i]);
                number = check;
                again = true;

            } else {
                again = false;
            }
        }

        return stack;
    }

    
    
    public static StackOfIntegers primeNumber(int num) {
        StackOfIntegers stack = new StackOfIntegers();

        for (int i = num; i > 0; i--) {
            if ((i % 2 != 0 && i % 3 != 0 && i != 1) || (i == 2 || i == 3)) {
                stack.push(i);
            }
        }

        return stack;
    }

    
    
    public static Integer[] primeNumber_Array(int num) {
        ArrayList<Integer> primeNums = new ArrayList<Integer>();

        for (int i = num; i > 0; i--) {
            if ((i % 2 != 0 && i % 3 != 0 && i != 1) || (i == 2 || i == 3)) {
                primeNums.add(i);
            }
        }
        Integer[] arr = primeNums.toArray(new Integer[primeNums.size()]);
        Arrays.sort(arr);

        return arr;
    }

}



class StackOfIntegers {

    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    /////////////////////////////////////
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /////////////////////////////////////
    public boolean empty() {
        return size == 0;
    }

    public int peek() {
        return elements[size - 1];
    }

    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements,0, temp, 0, elements.length);
            elements = temp;
        }

        elements[size++] = value;
    }

    public int pop() {
        return elements[--size];
    }

    public int getSize() {
        return size;
    }

    public void showStack_Reverse() {
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i] + " ");
        }
    }
}
