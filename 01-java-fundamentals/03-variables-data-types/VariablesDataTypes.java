/**
 * Sub-topic : Variables & Data Types
 * Module    : 01-java-fundamentals
 * Run       : java 01-java-fundamentals/03-variables-data-types/VariablesDataTypes.java
 */

public class VariablesDataTypes {

    public static void main(String[] args) {

        // Step 1: declare and give a value (initialize)
        int age = 23;                    // type + name = value;
        System.out.println("Age: " + age);

        // Step 2: declare first, assign later
        int score;                       // declaration only
        score = 80;                      // assignment
        System.out.println("Score: " + score);

        // Step 3: change the value (the type must stay the same)
        score = 95;
        System.out.println("New score: " + score);

        // Step 4: the 8 primitive types
        byte smallNumber = 100;                  // 1 byte:  -128 to 127
        short mediumNumber = 30000;              // 2 bytes: -32,768 to 32,767
        int normalNumber = 2000000000;           // 4 bytes: about -2.1 billion to 2.1 billion
        long bigNumber = 9000000000L;            // 8 bytes: needs the L at the end
        float smallDecimal = 3.14f;              // 4 bytes: needs the f at the end
        double normalDecimal = 3.14159265359;    // 8 bytes: default type for decimals
        char letter = 'B';                       // 1 character: single quotes
        boolean isLearning = true;               // only true or false

        System.out.println("byte:    " + smallNumber);
        System.out.println("short:   " + mediumNumber);
        System.out.println("int:     " + normalNumber);
        System.out.println("long:    " + bigNumber);
        System.out.println("float:   " + smallDecimal);
        System.out.println("double:  " + normalDecimal);
        System.out.println("char:    " + letter);
        System.out.println("boolean: " + isLearning);

        // Step 5: String is NOT a primitive type. It is text, with a capital S and double quotes.
        String name = "Badru";
        System.out.println("Name: " + name);

        // Step 6: limits of each type (Java has built-in constants for them)
        System.out.println("byte range:  " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short range: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int range:   " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long range:  " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

        // Step 7: overflow. If a number goes over the limit, it wraps around to the other side.
        int maxInt = Integer.MAX_VALUE;
        System.out.println("maxInt + 1 = " + (maxInt + 1));   // not 2147483648!

        // Step 8: decimals are not always exact
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));     // not exactly 0.3

        // Step 9: constants. "final" means the value cannot change after it is set.
        final double PI = 3.14159;
        System.out.println("PI: " + PI);
        // PI = 3.14;   // error: cannot assign a value to final variable PI

        // Step 10: var. Java can guess the type from the value (local variables only).
        var city = "Bogor";              // Java sees String
        var year = 2026;                 // Java sees int
        System.out.println("City: " + city + ", Year: " + year);

        // Step 11: naming. Use camelCase and clear names.
        int studentAge = 17;             // good: clear
        int a = 17;                      // bad: unclear
        System.out.println("studentAge = " + studentAge + ", a = " + a);

        // ---------------------------------------------------------------
        // COMMON MISTAKES: remove the // in front of ONE line to see the error.
        // Put the // back before you test the next one.
        // ---------------------------------------------------------------

        // 1. Use a variable before giving it a value
        // int total;
        // System.out.println(total);            // error: variable total might not have been initialized

        // 2. Put a decimal into an int
        // int wrong = 3.14;                     // error: incompatible types: possible lossy conversion from double to int

        // 3. Forget the L for a big number
        // long tooBig = 3000000000;             // error: integer number too large

        // 4. Forget the f for a float
        // float price = 19.99;                  // error: incompatible types: possible lossy conversion from double to float

        // 5. Use double quotes for char
        // char grade = "A";                     // error: incompatible types: String cannot be converted to char

        // 6. Declare the same variable name twice
        // int age = 30;                         // error: variable age is already defined in method main(String[])

        // 7. Put text into an int
        // int number = "10";                    // error: incompatible types: String cannot be converted to int
    }
}
