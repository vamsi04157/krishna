
package com.randomNumbers;


import java.util.Random;
 
public class random{
 
    public static void main(String args[])
    {
        // create instance of Random class
        Random rand = new Random();
 
        // Generate random integers in range 0 to 500
        int rand_int = rand.nextInt(500);
      
 
        // Print random integers
        System.out.println("Random Integers: "+rand_int);

 
        
    }
}


