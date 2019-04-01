import java.util.Scanner;

public class Test{
    
    public static void main(String[] args){
        
        Account account = new Account(1122, 20000);
       
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is "+ account.getBalance());
        System.out.println("This account was created at "+ account.getDateCreated());
        
      
    }
    
}