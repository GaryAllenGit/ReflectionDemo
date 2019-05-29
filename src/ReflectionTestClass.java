public class ReflectionTestClass {
    /* This class contains a private field, a public constructor, two public methods,
       and one private method.
       The class "ReflectionDemo" will create an instance of this class and then use
       reflection to inspect the class, its methods, and its fields, then to invoke
       the methods and modify the value of the field.
    */

    // A private field
    private String s;

    // A public constructor
    public ReflectionTestClass()  {
        s = "Hello Java Reflection World!";
    }

    // A public method with no arguments
    public void method1()  {
        System.out.println("The string is " + s);
    }

    // A public method with an int as an argument
    public void method2(int n)  {
        System.out.println("The number is " + n);
    }

    // A private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}

