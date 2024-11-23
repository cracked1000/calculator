package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class copy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        while (continueCalculating) {
            // Get a list of numbers from the user
            List<Double> numbers = new ArrayList<>();
            System.out.println("Enter numbers one by one. Type 'done' when finished:");
            while (true) {
                System.out.print("Enter a number (or 'done' to finish): ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                try {
                    double number = Double.parseDouble(input);
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }
            if (numbers.isEmpty()) {
                System.out.println("No numbers entered. Try again.");
                continue;
            }
            // Ask the user to choose an operation
            System.out.println("Choose an operation: +, -, *, /");
            char operation = scanner.next().charAt(0);
            double result = numbers.get(0);
            // Perform calculation based on the user's choice
            switch (operation) {
                case '+':
                    result = add(numbers);
                    break;
                case '-':
                    result = subtract(numbers);
                    break;
                case '*':
                    result = multiply(numbers);
                    break;
                case '/':
                    result = divide(numbers);
                    break;
                default:
                    System.out.println("Invalid operation!");
                    continue;
            }
            // Display the result
            System.out.println("The result is: " + result);
            // Ask if the user wants to perform another calculation
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                continueCalculating = false;
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
    // Addition method for multiple numbers
    public static double add(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
    // Subtraction method for multiple numbers
    public static double subtract(List<Double> numbers) {
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return result;
    }
    // Multiplication method for multiple numbers
    public static double multiply(List<Double> numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }
    // Division method for multiple numbers
    public static double divide(List<Double> numbers) {
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == 0) {
                System.out.println("Error! Division by zero.");
                return 0;
            }
            result /= numbers.get(i);
        }
        return result;
    }
}
