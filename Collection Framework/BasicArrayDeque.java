/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicarraylist;
import java.util.* ;

public class BasicArrayDeque 
{
    public static void main(String args[])
    {
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>() ;

        dq.offerFirst(10);  dq.offerFirst(20);  dq.offerFirst(30);  dq.offerFirst(40);
        dq.offerLast(100);  dq.offerLast(200);  dq.offerLast(300);  dq.offerLast(400);
        
        dq.pollFirst();         //remove first element
        dq.peekFirst();         //it return first element
                                //Explore other method
              
        //Lamda Expression
        dq.forEach((P)->System.out.println(P));
    }
}
