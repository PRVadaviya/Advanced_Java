/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basiclambdaexpression;

interface Car
{
    void carColor();
}

/*
 class MyCar implements Car
{
    public void carColor()
    {
        System.out.println("Blue");
    }
}

public class BasicLambdaExpression {

    public static void main(String[] args) {
        
        Car mc = new MyCar();
        mc.carColor();
    }
}
*/

// apply step one two and three

public class BasicLambdaExpression {

    public static void main(String[] args) {
       
       Car cc = ()->{System.out.print("Blue");}; 
        
    }
}
