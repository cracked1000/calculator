package org.example;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        while (continueCalculating) {
            List<Double> numbers = new ArrayList<>();
            double result = 0;
            while (true) {
                System.out.print("Enter a number or 'done' to finish : ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                try {
                    double number = Double.parseDouble(input);
                    numbers.add(number);
                    System.out.println("Choose an operation: +, -, *, /");
                    char operation = scanner.next().charAt(0);
                    //double result = numbers.get(0);
                    switch (operation) {
                        case '+':
                            result = methods.add(numbers);
                            break;
                        case '-':
                            result = methods.subtract(numbers);
                            break;
                        case '*':
                            result = methods.multiply(numbers);
                            break;
                        case '/':
                            result = methods.divide(numbers);
                            break;
                        default:
                            System.out.println("Invalid operation!");
                            continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number. Please try again.");
                }
            }
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                continueCalculating = false;
            }
            System.out.println("The result is: " + result);
            if (numbers.isEmpty()) {
                System.out.println("No numbers entered. Try again.");
                continue;
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }
}
