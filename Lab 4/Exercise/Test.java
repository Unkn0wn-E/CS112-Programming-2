import java.util.Scanner;
public class Test {

    public static void main(String[] args){
        
        StackOfStrings stack = new StackOfStrings();
        
        System.out.println("STACK OF STRINGS\nType PSH followed by a space "
        + "and a string and a carriage return or\nType POP followed "
        + "by a carriage return or\nType PEK followed by a carriage "
        + "return or \nType STP followed buy a carriage return");
        
        Scanner input = new Scanner(System.in);
        while (true) {
            
            System.out.print("Enter command: ");
            String s = input.nextLine();
            String stackCommand = s.substring(0, 3);
            
            switch (stackCommand) {
                case "PSH":
                stack.push(s.substring(s.indexOf(" ") + 1));
                stack.printStack();
                break;
                
                case "POP":
                System.out.println(stack.pop());
                stack.printStack();
                break;
                
                case "PEK":
                System.out.println(stack.peek());
                stack.printStack();
                break;
                
                case "STP":
                System.exit(0);
                
                default:
                System.out.println("Illegal input. Try again.");
            }
        }
            
    }
}