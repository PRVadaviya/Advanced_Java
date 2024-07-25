/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basiclambdaexpression;

interface MyLambda
{
    void display();
}

class Demo
{
     int temp = 10 ;        //check what to do when temp variable become final ?
    
    public void method1(){
        
       int test = 48 ;
        
    MyLambda ml = ()->{
                        int a=3 ;
                        System.out.println("Red");
                        System.out.println(a++);      // modify and accessable 
                        System.out.println(test );    //Local variable - not modify and accessable
                        System.out.println((temp++)); //instance variable - modify and accessable
                      };  
           ml.display();
    }
}
public class CaptureLambdaExpression {
    
    public static void main(String args[]){
        Demo d1 = new Demo();
        d1.method1();
    }
}
