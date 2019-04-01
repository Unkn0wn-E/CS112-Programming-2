import java.util.Random;
import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the name of Stock: ");
        String stockName = input.nextLine();
        
        System.out.print("Enter the symbol of Stock: ");
        String symbol = input.next();
        
        System.out.print("Enter the previous closing price: ");
        double previousPrice = input.nextDouble();
        
        System.out.print("Enter the current price: ");
        double currentPrice = input.nextDouble();
        
        Stock s1 = new Stock(symbol, stockName, new Random().nextInt(100));
        s1.setCurrentPrice(currentPrice);
        s1.setPreviousClosingPrice(previousPrice);
        
        System.out.println("\n\nStock name: "+s1.getStockName());
        System.out.println("Stock symbol: "+s1.getSymbol());
        System.out.println("Stock ID: "+s1.getID());
        System.out.println("Price-Change percentage: "+s1.getChangePercent());
    
        
    }
}