package basicarraylist;

import java.util.*;
import java.io.* ;

public class BasicProperties {

    public static void main(String args[])
    {
        Properties pt = new Properties();
        
        pt.setProperty("name", "HP");
        pt.setProperty("class", "laptop");        
        pt.setProperty("shop", "umiya");
        pt.setProperty("place", "morbi");
        pt.setProperty("version", "i5");
      
        //pt.storeToXML(new FileOutputStream("C:\Users\HP\OneDrive\Desktop\code\Untitled-1.txt") , "Ok Done");
    
        // It's similar to file input output , fetch data from file and store data from file 
    }
}
