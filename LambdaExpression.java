//program to demonstrate the working of lambda expression

public class LambdaExpression {
    // operation is implemented using lambda expression
    interface FuncInter1{
        int operation(int a, int b);
    }

    //sayMessage is implemented using lambda expression
    interface FuncInter2{
        void sayMessage(String message);
    }

    //perform FuncInter1 operation on a and b
    private int operate(int a, int b, FuncInter1 fobj){
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {
        //lambda expression for addition of two parameters
        //data type for x and y is optional
        //this expression implements FuncInter1 interface

        FuncInter1 add = (int a, int b) -> a + b;

        //lambda expression for multiplication of two parameters
        FuncInter1 multiply = (int a, int b) -> a * b;

        //creating an object of Test to call operate using 
        // different implementation using lambda expression
        LambdaExpression leObj = new LambdaExpression();

        // add two numbers uding lambda expression
        System.out.println("Addition: " + leObj.operate(2, 3, add));

        //multiply two numbers using lambda expression
        System.out.println("Multiplication: " + leObj.operate(2, 3, multiply));

        //lambda expression for simgle parameter 
        //this expression implements FuncInter2 interface
        FuncInter2 fobj = message -> System.out.println("Hello");

        fobj.sayMessage("Wasif");

    }
    
}
