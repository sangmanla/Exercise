package java8;

public class FunctionalInterfaceExample
{
    public static void main(String args[])
    {
        int a = 5;
 
        // lambda expression to define the calculate method
//        Square s = (int x)->{return x*x;};
        Square s = x -> x*x;
 
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
    }
    
    @FunctionalInterface
    interface Square
    {
        int calculate(int x);
    }
}