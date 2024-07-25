package basicarraylist;

import java.util.*;


class Point implements Comparable
{
    int x ;
    int y ;
    
    public Point(int i, int i0) {
        this.x = i ;
        this.y = i0 ;
    }
    
    public String toString()
    {
        return "X="+x+" Y="+y ;
    }
    
    @Override
    public int compareTo(Object o) {
        
        Point p = (Point)o;
        
        if(this.x < p.x)
            return -1 ;
        else if (this.x > p.x)
            return 1 ;
        else{
            
            if(this.y<p.y)
                return -1 ;
            else if(this.y > p.y)
                return 1 ;
            else 
                return 0 ;
        }
    }
}

public class BasicComparable_i {
    
    public static void main(String args[])
    {
        TreeSet<Integer> ts = new TreeSet<>();
        
//        ts.add(new Point(1,1));
//        ts.add(new Point(2,3));
//        ts.add(new Point(2,4));
        
        System.out.println(ts);
    }
}
