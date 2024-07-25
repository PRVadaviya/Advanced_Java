package basicarraylist;

import java.util.Map.* ;
import java.util.* ;

public class BasicHashTable {
    
    public static void main(String args[])
    {
        Hashtable ht = new Hashtable() ;
        
        ht.put(1,"a");  ht.put(2,"b");  ht.put(3,"c");  ht.put(4,"k");  ht.put(5,"d");
        
        String s =(String) ht.get(3);
        
        Enumeration e = ht.keys();
        while(e.hasMoreElements())
        {
            System.out.println(e.nextElement());
        }
        
        //System.out.println(ht);
    }
}
