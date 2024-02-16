A demo of Java Reflection

Dr Gary Allen, The University of Huddersfield

This demo is heavily based upon the one at:
    https://www.geeksforgeeks.org/reflection-in-java/

Simply import the code into IntelliJ (or another IDE) and run the ReflectionDemo class.


**********************************************
I have now added another demo called ClassAnalyser that scans a filesystem hierarchy (from a root specified as an argument to main) finding all class files and analysing them one by one.  This demo is NOT complete and is still work in progress - it may still be buggy!  
Try passing the **root folder of the compiled classes** in an IntelliJ project as the argument.  For example, I am passing /home/gary/IntelliJProjects/ReflectionDemo/out/production/ReflectionDemo/ as the command line argument.  This makes the project analyse itself.

IMPORTANT - On Windows systems it is necessary to escape the backslash symbols in the pathname, so use double backslashes.  For example: C:\\somefolder\\someproject\\out\\production\\someproject\\

ALSO IMPORTANT - the "/" (or "\\" on windows) at the end of the pathname argument IS REQUIRED.
**********************************************

