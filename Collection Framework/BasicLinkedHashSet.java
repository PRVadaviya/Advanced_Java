package basicarraylist;

import java.util.* ;

public class BasicLinkedHashSet {
    
    public static void main(String args[])
    {
        LinkedHashSet<String> lhs = new LinkedHashSet<>(10);
        //HashSet<String> hs = new HashSet<>(10);               //Different answer
        
        lhs.add("a");   lhs.add("b");   lhs.add("e");   lhs.add("j");   lhs.add("h");
        
        Iterator<String> it = lhs.iterator();        
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        
        //lhs.forEach(System.out::println);
    }
}
