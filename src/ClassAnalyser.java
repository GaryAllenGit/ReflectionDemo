import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassAnalyser {

    private final String rootPath;

    private ClassAnalyser(String rootPath) {
        this.rootPath = rootPath;
        // starting from the root path, recursively descend searching for .class files, then pass each file to the analyser method.
        File directory = new File(rootPath);
        searchForFiles(directory);
    }

    private void searchForFiles(File dir) {

            File[] listFile = dir.listFiles();

            if (listFile != null) {
                for (File file : listFile) {
                    if (file.isDirectory()) {
                        searchForFiles(file);
                    } else {
                        if (file.getName().endsWith(".class")) {
                            analyseFile(file);
                        }
                    }
                }
            }
        }

    private void analyseFile(File file) {
        try {
            // Get the relative file name from the full pathname
            String fullFileName = file.getAbsolutePath();
            System.out.println("Analysing file: " + fullFileName);

            String relativeFileName = fullFileName.replaceAll(rootPath, "");
            System.out.println("Relative filename: " + relativeFileName);

            String croppedRelativeFilename = relativeFileName.replaceAll(".class", "");
            System.out.println("Cropped relative filename: " + croppedRelativeFilename);

            // Create an object (instance of a class)
            // first load the class
            Class<?> cls = Class.forName(croppedRelativeFilename);
            System.out.println("The name of the loaded class is " + cls.getName());

            // Get the constructors of the class by using getConstructors
            Constructor[] constructors = cls.getConstructors();

            System.out.println("There are " + constructors.length + " constructors");

            // Print the method names
            System.out.println("The constructors of class are : ");
            for (Constructor constructor:constructors)
                System.out.println(constructor.getName());

            // Get the methods of the class by using getMethods
            Method[] methods = cls.getMethods();

            System.out.println("There are " + methods.length + " methods");

            // Print the method names
            System.out.println("The methods of class are : ");
            for (Method method:methods)
                System.out.println(method.getName());


            // Get the fields of the class by using getFields
            Field[] fields =  cls.getFields();

            System.out.println("There are " + fields.length + " fields");

            // Print the field names
            System.out.println("The fields of class are : ");
            for (Field field:fields)
                System.out.println(field.getName());



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please pass the root directory as a parameter");
        } else {
            String rootPath = args[0];
            new ClassAnalyser(rootPath);
        }
    }
}
