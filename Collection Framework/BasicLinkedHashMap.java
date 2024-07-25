package basicarraylist;

import java.util.* ;

public class BasicLinkedHashMap
{
    // Run the code cover all possiable
    
    public static void main(String args[])
    {
        //LinkedHashMap<Integer,String> lhm = new LinkedHashMap<>(5,0.75f,true);
        
        LinkedHashMap<Integer,String> lhm = new LinkedHashMap<>(5)
        {
            protected boolean removeEldestEntry(Map.Entry e)
            {
                    return size()>4 ;   
            }
        };
        
        lhm.put(1, "a");    lhm.put(2, "b");    lhm.put(3, "c");    lhm.put(4, "d");    lhm.put(5, "e");
        
        String s = lhm.get(2);
        s = lhm.get(4);
        s = lhm.get(1);
        
        lhm.put(6,"f");
        
        lhm.forEach((K,V)->System.out.println(K + " " + V));
    }
}
