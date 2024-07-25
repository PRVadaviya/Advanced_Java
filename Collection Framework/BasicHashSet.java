/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicarraylist;
import java.util.* ;

public class BasicHashSet {

    public static void main(String args[]){
    
        HashSet<Integer> hs = new HashSet<>(10,0.25F);
        
        //  May be not a display same order 
        hs.add(10);     hs.add(20);     hs.add(30);     hs.add(40);
        
        hs.forEach((X)->System.out.println(X));
    }
            
}
