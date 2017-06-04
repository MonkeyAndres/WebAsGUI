package frontend;

import backend.JSON;

/**
 * Bridge between JS and JAVA.
 * In this class you can define all methods you want and it
 * can be accessible from JS code.
 */
public class Bridge {

    /**
     * Example method that print "Hello From JS :P" in the console.
     * */
    public void sayHello(){
        System.out.println("Hello From JS :P");
    }

    /**
     * Method that print a string in console.
     * @param s The message you want to print
     * */
    public void print(String s){
        System.out.println(s);
    }
}
