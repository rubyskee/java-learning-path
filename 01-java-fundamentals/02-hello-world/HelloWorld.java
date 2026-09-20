/**
 * Sub-topic : Hello World
 * Module    : 01-java-fundamentals
 * Run       : java 01-java-fundamentals/02-hello-world/HelloWorld.java
 */
public class HelloWorld {
    // The JVM starts your program from this method.
    public static void main(String[] args) {

        // Step 1: print one line of text
        System.out.println("Hello, World!");

        // Step 2: println moves to a new line, print does not
        System.out.println("Line one");
        System.out.println("Line two");
        System.out.print("Same ");
        System.out.print("line");
        System.out.println(); // empty println = empty line

        // Step 3: print your own information
        System.out.println("My name is Badru.");
        System.out.println("I am learning Java.");

        // Step 4: escape characters (special characters inside text)
        System.out.println("First\tSecond");          // \t = tab
        System.out.println("Top\nBottom");            // \n = new line
        System.out.println("She said \"Hello\"");     // \" = double quote
        System.out.println("C:\\Users\\Badru");       // \\ = one backslash

        // Step 5: print text and a number
        System.out.println("2 + 3 = " + (2 + 3));     // + joins text and values

        // Step 6: comments are ignored by the compiler
        // This is a single-line comment.
        /*
         * This is a multi-line comment.
         * Use it for longer notes.
         */

        // ---------------------------------------------------------------
        // COMMON MISTAKES: remove the // in front of ONE line to see the error.
        // Put the // back before you test the next one.
        // ---------------------------------------------------------------

        // 1. Missing semicolon -> error: ';' expected
        // System.out.println("No semicolon")

        // 2. Wrong capital letter: system instead of System -> error: package system does not exist
        // system.out.println("Wrong case");

        // 3. Missing closing quote -> error: unclosed string literal
        // System.out.println("Hello);

        // 4. Wrong method name: printline instead of println -> error: cannot find symbol
        // System.out.printline("Hello");
    }
}
