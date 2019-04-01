import java.net.URL;
import java.util.*;
import java.util.regex.*;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder allHTML = new StringBuilder();
        
        try {
            System.out.print("Enter URL with the Protocol (http/https) : ");
            URL link = new URL(input.nextLine());
            
            input.close();
            
            Scanner rd = new Scanner(link.openStream());
            
            
            while(rd.hasNextLine()){
                // System.out.println(rd.nextLine());
                allHTML.append(rd.nextLine()+"\n ");
            }
            
            Matcher m = Pattern.compile("((http|https)://.+?\")").matcher(allHTML);
            if(m.find()) System.out.println("\nAll the links from "+link.toString()+"\n");
            while(m.find()){
                System.out.println(allHTML.substring(m.start(), m.end()-1));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}