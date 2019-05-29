import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {

    /* This class creates an instance of the "ReflectionTestClass" and then uses reflection
       to inspect the class, its methods, and its fields, and then to invoke the methods and
       modify the value in the field.
     */

    public static void main(String args[]) throws Exception
    {
        // Create an object (instance of a class)
        ReflectionTestClass obj = new ReflectionTestClass();

        // Create a class object from the object using getclass method
        Class cls = obj.getClass();
        System.out.println("The name of class is " + cls.getName());

        // Get the constructor of the class through the object of the class by using getConstructor
        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " + constructor.getName());

        // Get the methods of the class through the object of the class by using getMethods
        Method[] methods = cls.getMethods();

        // Print the method names
        System.out.println("The public methods of class are : ");
        for (Method method:methods)
            System.out.println(method.getName());

        // Create object of desired method by providing the method name and parameter class
        // as arguments to the getDeclaredMethod
        Method methodcall1 = cls.getDeclaredMethod("method2", int.class);

        // Invoke the method at runtime
        methodcall1.invoke(obj, 19);

        // Create object of the desired field by providing the name of the field as
        // argument to the getDeclaredField method
        Field field = cls.getDeclaredField("s");

        // Allow the object to access the field irrespective
        // of the access specifier used with the field
        field.setAccessible(true);

        // Set the value in the field with the set method, taking the object and the
        // new value to be assigned to the field as arguments
        field.set(obj, "JAVA");

        // Create object of desired method by providing the method name as argument
        // to the getDeclaredMethod
        Method methodcall2 = cls.getDeclaredMethod("method1");

        // Invoke the method at runtime
        methodcall2.invoke(obj);

        // Create object of the desired method by providing the name of method as
        // argument to the getDeclaredMethod method
        Method methodcall3 = cls.getDeclaredMethod("method3");

        // Allows the object to access the method irrespective of the access
        // specifier used with the method
        methodcall3.setAccessible(true);

        // Invoke the method at runtime
        methodcall3.invoke(obj);
    }
}
