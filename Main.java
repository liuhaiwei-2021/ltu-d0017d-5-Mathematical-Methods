/*
* Assignment 5 Mathmatical methods
*
* Step 1. declare globaly userinput so can usde in every method
* Step 2. go in main function and create an userInput object 
* Step 3. declare all the variables radius,height, 
* circleArea, coneArea, coneVolume:
* Step 4. according userinput and input() assign validate 
* int and postive number to radius height numerator 
* denominator
* Step 5. call all methods and printf results
*
*@haiweiliu Haiwei
*/

import java.util.Scanner;
import java.util.Arrays;

public class Main {

  // declare global variable userinput
  static Scanner userInput;

  public static void main(String[] args) {
    // declare all varibles
    int radius = 0;
    int height = 0;
    double circleArea = 0.0;
    double coneArea = 0.0;
    double coneVolume = 0.0;
    int numerator = 0;
    int denominator = 0;


    System.out.println("Assignment 5!");
    userInput = new Scanner(System.in);
    
    // area and volume 
    while (true) {
      radius = input();
      if (radius == -1) {
        break;
      }
      height = input();
      if (height == -1) {
        break;
      }
      System.out.printf("r = %d h = %d%n", radius, height);

      // Rounding scale
      int noOfDecimals = 3;
      double scale = 0;
      scale = Math.pow(10, noOfDecimals);

      circleArea = Math.round(area(radius) * scale) / scale;
      System.out.printf("Circle area: %f%n", circleArea);
      coneArea = Math.round(area(radius, height) * scale) / scale;
      System.out.printf("Cone area: %f%n", coneArea);
      coneVolume = Math.round(volume(radius, height) * scale) / scale;
      System.out.printf("Cone volume: %f%n", coneVolume);

    }

    // fractions 
    while (true) {
      numerator = input();
      if (numerator == -1) {
        break;
      }
      denominator = input();
      if (denominator == -1) {
        break;
      }

      int[] parts = fraction(numerator, denominator);     
      printFractions(parts);
    }
    
    userInput.close();
  }// cloe of main function
 
   /**
   * input() to validate user input
   * @param  
   * @return a int number 
   */
  public static int input() {
    int number = 0;
    while (true) {
      if (userInput.hasNextInt()) {
        number = Math.abs(userInput.nextInt());
        if (number >= 0) {
          break;
        }
      } else if (userInput.hasNext()) {
        String inString = userInput.next();
        // Q and q
        if (inString.equalsIgnoreCase("q")) {
          number = -1;
          break;
        }
      }
    }
    return number;
  } // close of input

  /**
   * Area of the circle
   * @param radius is integer number
   * @return the area of the circle
   */
  public static double area(int radius) {
    int EXPONENT_AREA = 2;
    return Math.PI * Math.pow(radius, EXPONENT_AREA);
  }

  /**
   * Lateral surface area the cone 
   * @param radius and height are integer numbers
   * @return lateral surface area the cone
   */
  public static double area(int radius, int height) {
    return Math.PI * radius * pythagoras(radius, height);
  }

  /**
   * Pythagoras' theorem 
   * @param radius and height are integer numbers
   * @return the volume
   */
  public static double pythagoras(int sideA, int sideB) {
    return Math.sqrt(sideA) + Math.sqrt(sideB);
  }

  /**
   * volume
   * @param sideA and sideB are integer numbers
   * @return the hypotenuse
   */
  public static double volume(int radius, int height) {
    // declare all constants
    int EXPONENT_VOLUME = 2;  
    int DENOM_VOLUME = 3; 
    
    return Math.PI * Math.pow(radius, EXPONENT_VOLUME) * height / DENOM_VOLUME;  
  }// close of volume

  /**
   * fraction
   * @param numerator and denominator are integer numbers
   * @return an integer array, int[3], where the integer 
   * part is in first place in the array, and the 
   * fraction's numerator and denominator are in second and 
   * third place in the array.
   */
  public static int[] fraction(int numerator, int denominator) {
    int arrayInterger = 0;

    if (denominator == 0) {
      return null;
    } else if (numerator == 0) {
      return new int[] { 0, 0, 0 };
    }

    int GCD = gcd(numerator, denominator);
  
    arrayInterger = numerator / denominator;
    numerator = numerator % denominator / GCD;
    denominator = denominator / GCD;
    
    return new int[] { arrayInterger, numerator, denominator };
  } // close of fraction function

  /*
   * Reducing using gcd 
   * @param a and b are interger numbers
   * @return the greatest common divider (GCD) using Euclide's algorithm.
   */
  public static int gcd(int a, int b) {
    
    while (b != 0) {
      int t = a;
      a = b;
      b = t % b;
    }
    return a;
  } //close of gcd

  /*
   * printFractions
   * @param parts is int array
   * @return void
   */
  public static void printFractions(int[] parts) {
    if(parts == null) {
      System.out.printf("%-5s%n", "Error");
    }
    else if(parts[2] == 0){
      System.out.printf("%-1s%n","0");
    }
    else if(parts[1] == 0) {
      System.out.printf("%-2s%n", parts[1]);
    }
    else if(parts[0] == 0){
      System.out.printf("%-1s %-1s %-1s%n", parts[1], "/ ", parts[2]);
    }
    else {
       System.out.printf("%-2s %-1s %-1s %-1s%n", parts[0], parts[1], "/", parts[2]);
    }
  }// close of printFractions
  
}