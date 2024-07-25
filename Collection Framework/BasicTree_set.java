package basicarraylist;

import java.util.* ;

public class BasicTree_set 
{
    public static void main(String args[]){
    TreeSet<Integer> ts = new TreeSet<>(List.of(10,56,85,24,36,39));
    
    ts.add(22);
    
    Iterator<Integer> it = ts.iterator();
    while(it.hasNext())
    {
        System.out.print(it.next() + " ");
    }
    
    //ts.forEach((X)->System.out.println(X));
    
}
}