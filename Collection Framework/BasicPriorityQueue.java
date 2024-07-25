/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicarraylist;
import java.util.* ;

public class BasicPriorityQueue {
    
    public static void main(String args[]){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        
        pq.add(10);     pq.add(20);     pq.add(30);     pq.add(40);
        
        pq.forEach((X)->System.out.println(X));
    }
}
