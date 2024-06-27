package Java_Mini_Projects;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Calculator {
//     public class bankaccount{
//         string
// }
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);
        
        // Initialize a boolean variable to control the loop
        boolean continueCalculating = true;

        // Loop until the user decides to quit
        while (continueCalculating) {
            // Print a welcome message
            System.out.println("Hello, this is a calculator!");
            
            // Ask the user to enter the first number
            System.out.print("Enter the first number: ");
            // Call the getValidNumber method to get a valid float input
            float x = getValidNumber(sc);

            // Ask the user to enter the second number
            System.out.print("Enter the second number: ");
            // Call the getValidNumber method to get a valid float input
            float y = getValidNumber(sc);

            // Print a menu of operations to choose from
            System.out.println("Choose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Exponentiation");

            // Ask the user to choose an operation
            int choice = getValidChoice(sc);

            // Perform the chosen operation using a switch statement
            switch (choice) {
                case 1:
                    // Addition
                    System.out.println("The result is: " + (x + y));
                    break;
                case 2:
                    // Subtraction
                    System.out.println("The result is: " + (x - y));
                    break;
                case 3:
                    // Multiplication
                    System.out.println("The result is: " + (x * y));
                    break;
                case 4:
                    // Division
                    if (y!= 0) {
                        System.out.println("The result is: " + (x / y));
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                case 5:
                    // Modulus
                    System.out.println("The result is: " + (x % y));
                    break;
                case 6:
                    // Exponentiation
                    System.out.println("The result is: " + Math.pow(x, y));
                    break;
                default:
                    // Invalid operation
                    System.out.println("Invalid operation.");
                    break;
            }

            // Ask the user if they want to perform another calculation
            System.out.println("Do you want to perform another calculation? (yes/no)");
            // Consume the newline character left in the input buffer
            sc.nextLine();  
            // Read the user's response
            String continueResponse = sc.nextLine();
            // If the user doesn't want to continue, set the flag to false
            if (!continueResponse.equalsIgnoreCase("yes") && !continueResponse.equalsIgnoreCase("y") ) {
                continueCalculating = false;
            }
        }

        // Close the Scanner object
        sc.close();
        // Print a goodbye message
        System.out.println("Thank you for using the calculator. Goodbye!");
    }

    // Method to get a valid float input from the user
    private static float getValidNumber(Scanner sc) {
        // Loop until the user enters a valid float
        while (!sc.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid number.");
            // Clear the invalid input
            sc.next();  
        }
        // Return the valid float input
        return sc.nextFloat();
    }
    private static int getValidChoice(Scanner sc){
        List<Integer> validchoices = Arrays.asList(1,2,3,4,5,6);
        while (true){
            if(sc.hasNextInt()){
                int choice = sc.nextInt();
                if(validchoices.contains(choice)){
                    return choice;
                }else{
                    System.out.println("Please enter a valid number between 1-6.");
                    sc.next();
                }
            }else{
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

    }


}