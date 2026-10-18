/**
 * Sub-topic : Type Casting
 * Module    : 01-java-fundamentals
 * Run       : java 01-java-fundamentals/04-type-casting/TypeCasting.java
 */
public class TypeCasting {

    public static void main(String[] args) {

        // Step 1: widening (small type -> big type). Java does it automatically.
        // Order: byte -> short -> int -> long -> float -> double
        int myInt = 100;
        long myLong = myInt;          // int -> long
        double myDouble = myLong;     // long -> double
        System.out.println("int -> long -> double: " + myInt + " -> " + myLong + " -> " + myDouble);

        // Step 2: narrowing (big type -> small type). You must cast by hand: (type).
        double price = 19.99;
        int wholePrice = (int) price; // the decimal part is cut off, NOT rounded
        System.out.println("(int) 19.99 = " + wholePrice);
        System.out.println("(int) 3.99  = " + (int) 3.99);
        System.out.println("(int) -3.99 = " + (int) -3.99);

        // Step 3: narrowing can lose data. Java does not warn you.
        int big = 130;
        byte tooSmall = (byte) big;   // byte only holds -128 to 127
        System.out.println("(byte) 130 = " + tooSmall);

        long veryBig = 3000000000L;
        int wrapped = (int) veryBig;  // over the int limit
        System.out.println("(int) 3000000000L = " + wrapped);

        // Step 4: rounding. A cast cuts, Math.round rounds.
        double grade = 7.6;
        System.out.println("cast:  " + (int) grade);                // 7
        System.out.println("round: " + Math.round(grade));          // 8
        int roundedGrade = (int) Math.round(grade);                 // Math.round(double) gives long
        System.out.println("round as int: " + roundedGrade);

        // Step 5: char and int
        char letter = 'A';
        int code = letter;                    // char -> int (automatic)
        System.out.println("'A' as number: " + code);
        System.out.println("66 as char: " + (char) 66);
        System.out.println("'A' + 1 = " + ('A' + 1));                // int, not char
        System.out.println("(char) ('A' + 1) = " + (char) ('A' + 1));

        // Step 6: mixed types in a calculation. The result uses the "bigger" type.
        int apples = 5;
        double weight = 1.5;
        System.out.println("int * double = " + (apples * weight));   // double

        byte a = 10;
        byte b = 20;
        int sum = a + b;                      // byte + byte becomes int
        System.out.println("byte + byte = " + sum);

        // Step 7: the division trap. int / int gives int.
        System.out.println("7 / 2 = " + (7 / 2));                    // 3
        System.out.println("(double) 7 / 2 = " + ((double) 7 / 2));  // 3.5
        System.out.println("(double) (7 / 2) = " + ((double) (7 / 2))); // 3.0 (cast is too late)

        // Step 8: String <-> number. You cannot cast a String. Use parse methods.
        int numberFromText = Integer.parseInt("123");
        double decimalFromText = Double.parseDouble("3.14");
        System.out.println("parseInt: " + (numberFromText + 1));     // 124
        System.out.println("parseDouble: " + (decimalFromText * 2)); // 6.28

        String textFromNumber = String.valueOf(456);
        System.out.println("valueOf: " + textFromNumber + "7");      // 4567 (it is text now)

        // ---------------------------------------------------------------
        // COMMON MISTAKES: remove the // in front of ONE line to see the result.
        // Put the // back before you test the next one.
        // ---------------------------------------------------------------

        // 1. Narrowing without a cast
        // int x = 3.99;                              // error: incompatible types: possible lossy conversion from double to int

        // 2. byte + byte gives int, not byte
        // byte c = a + b;                            // error: incompatible types: possible lossy conversion from int to byte

        // 3. Casting a String
        // int n = (int) "123";                       // error: incompatible types: String cannot be converted to int

        // 4. Casting a boolean
        // int flag = (int) true;                     // error: incompatible types: boolean cannot be converted to int

        // 5. Text that is not a number (this fails when the program RUNS, not when it compiles)
        // int bad = Integer.parseInt("abc");         // NumberFormatException: For input string: "abc"

        // 6. Wrong result without any error (a logic mistake)
        // double average = 7 / 2;
        // System.out.println(average);               // prints 3.0, not 3.5
    }
}
