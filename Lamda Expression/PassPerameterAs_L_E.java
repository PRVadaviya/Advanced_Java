package basiclambdaexpression;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



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

public class PassPerameterAs_L_E {

        public static void main(String args[]){
            
            Demo d = new Demo();
            d.method1(()->System.out.println("Sucessfully Run"));        // No need put semicoloun
                                          //whenever return type is void then don't write expression inside this- {}
        }
    }
