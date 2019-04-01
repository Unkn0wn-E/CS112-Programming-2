import java.util.Date;
public class Account{
    
    private int id = 0;
    private double balance = 0;
    private Date dateCreated;
    
    public Account(){
        dateCreated = new Date();
    }
    
    public Account(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        dateCreated = new Date();        
    }
    
    
    // Setters and Getters
    public void setId(int id){
        this.id = id;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public int getId(){
        return this.id;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public Date getDateCreated(){
        return this.dateCreated;
    }
    
    // END Setters and Getters
    
    public void withdraw(double takeMoney){
        this.balance = balance - takeMoney;
    }
    
    public void deposit(double addMoney){
        this.balance = balance + addMoney;
    }
    
}