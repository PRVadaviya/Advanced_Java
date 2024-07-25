
package basicarraylist;
import java.util.* ;

public class BasicArrayList {

    public static void main(String[] args) {
        
        LinkedList<Integer> ll = new LinkedList<>();    // 
        
        ll.addFirst(10);        // Explore other methods
        System.out.println(ll);
        
        
        ArrayList<Integer> al = new ArrayList<>(10);        //
        ArrayList<Integer> al1 = new ArrayList<>(List.of(101,102,103,104));
        
        al.add(10);   al.add(20);   al.add(30);    al.add(2, 40);
          
        al.addAll(2,al1);
//        System.out.println(al.contains(20));
//        System.out.println(al);





        /*1.  ui direction (-> 'left to right')

            Iterator<Integer> it = al.iterator(); 

            while(it.hasNext())
            {
                System.out.println(it.next());
            }
        */
        
        /* 2.   bi direction (<-> forward and previous )
        
        ListIterator<Integer> it = al.listIterator(); 

            while(it.hasNext())
            {
                System.out.println(it.next());
            }
        */
        
        
        /*  3.
            for(Iterator<Integer> itt = al.iterator();it.hasNext();)
            {
                System.out.println(itt.next());
            }
        */
    }   
}
