package basicarraylist;

import java.util.*;
import java.util.Map.* ;

public class BasicTreeMap 
{
    public static void main(String args[])
    {           
            // Both are similar type 
        
        TreeMap<Integer,String> tm = new TreeMap<>(Map.of(0,"a",1,"b",2,"c",3,"d"));
        HashMap<Integer,String> hm = new HashMap<>(Map.of(0,"a",1,"b",2,"c",3,"d"));
        
        tm.put(4, "e");
        
        Entry<Integer,String> e = tm.firstEntry();
        
        System.out.println(e.getKey() + "  " + e.getValue());
        System.out.println(hm.get(2));
        System.out.println(tm);
    }  
}









