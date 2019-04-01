public class Stock{
    
    private String symbol;
    private String stockName;
    
    private double previousClosingPrice;
    private double currentPrice;
    
    private int ID;
    
    Stock(String symbol, String stockName, int ID) {
        this.symbol = symbol;
        this.stockName = stockName;
        this.ID = ID;
    }
        
    // getter
    public double getChangePercent(){
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getSymbol(){
        return symbol;
    }
    
    public String getStockName(){
        return stockName;
    }
    
    
    // setter
    public void setPreviousClosingPrice(double n1){
        previousClosingPrice = n1;
    }
    
    public void setCurrentPrice(double n1){
        currentPrice = n1;
    }
    
}