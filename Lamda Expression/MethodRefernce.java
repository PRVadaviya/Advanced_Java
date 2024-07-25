/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basiclambdaexpression;

interface MyLambda
{
    void display(String s);
}

public class MethodRefernce {
    
    public MethodRefernce(String s)
    {
        System.out.println(s.toUpperCase());  
    }
    
    public static void reverse(String s)            // static is must requirment bcz of this - ::
    {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        System.out.println(sb);
    }
    
    public static void main(String args[])
    {
        //MyLambda ml = MethodRefernce::reverse ;     //using one reference call to method 
        MyLambda ml = MethodRefernce::new ;        //using constructor
        
        ml.display("PratikVadaviya");
    }
    
}
