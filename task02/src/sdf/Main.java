package sdf;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Welcome. ---");
        
        Console cons = System.console();

        // instantiate new calculator class
        Calculator calculator = new Calculator();

        // flag to check if calculator should still run
        boolean exit = false;        

        while (!exit) {

            try {
            // reads the input after the prompt
            String calculations = cons.readLine("> ");

            // if input is exit, break out of while loop
            if (calculations.equals("exit")) {
                exit = true;
                break;
            }

            // split input based on space
            String[] cal = calculations.split(" ");

            // instantiate number values
            Float firstValue;
            Float secondValue;

            // checks if input is $last or a number
            if (cal[0].equals("$last")) {
                // if it is $last, get last value
                firstValue = calculator.getLast();
            } else {
                firstValue = Float.parseFloat(cal[0]);
            }

            if (cal[2].equals("$last")) {
                secondValue = calculator.getLast();
            } else {
                secondValue = Float.parseFloat(cal[2]);
            }

            // calls on calculate method in calculator
            Float result = calculator.calculate(firstValue, cal[1], secondValue);

            // prints out result
            System.out.println(String.format("%.3f", result));
            
            // sets result as new value of last
            calculator.setLast(result);

            // prints out invalide input if catches any error
            } catch (Exception e) {
                System.out.println("invalid input");
            }
        }

        System.out.println("Bye Bye");
        System.out.println("--- Thank you. Please pass me ---\n");

    }
    
}
