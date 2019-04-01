public class StackOfStrings{
    
    private String[] strings;
    private int size;
    
    // Constructor
    public StackOfStrings(){
        this(4);
    }
    
    public StackOfStrings(int capacity){
        strings = new String[capacity];
    }
    
    // Methods
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void push(String str){
        if(size >= strings.length){
            String[] temp = new String[strings.length * 1];
            temp = strings.clone();
            strings = temp;
        }
        
        strings[size++] = str;
    }
    
    public String pop(){
        if(size == 0) return "Stack is EMPTY";
        
        return strings[--size];
    }
    
    public String peek(){
        if(size == 0) return "Stack is EMPTY";
    
        return strings[size - 1];
    }
    
    public void printStack(){
        
        if(size == 0) return;
        
        System.out.println("Stack (top to bottom)");
        for(int i = 0; i < size; i++){
            System.out.println(size - i + " - " + strings[i]);
        }
    }
}