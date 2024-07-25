/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basiclambdaexpression;

/*
interface Calculate
{
    int display(int a , int b);
}
    public class ParameterLambdaExpression {

        public static void main(String args[]){
            
            Calculate add = (a,b)->a+b ;
            Calculate sub = (a,b)->a-b ;
            Calculate mul = (a,b)->a*b ;
            Calculate div = (a,b)->a/b ;

            System.out.println(add.display(200,10));
            System.out.println(sub.display(200,10));
            System.out.println(mul.display(200,10));
            System.out.println(div.display(200,10));
        }
    }
*/

// In parameter pass Lambda expression

interface Calculate
{
    void display();
}

class Demo
{
    public void method1(Calculate c)
    {
        c.display();
    }
}

public class ParameterLambdaExpression {

        public static void main(String args[]){
            
            Demo d = new Demo();
            d.method1(()->{System.out.println("Sucessfully Run");});        // No need put semicoloun
        
        }
    }