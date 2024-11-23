import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        while (continueCalculating) {
            List<Double> numbers = new ArrayList<>();
            double result = 0;
            while (true) {
                System.out.print("Enter a number (or 'done' to finish): ");
                String input = scanner.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                }
                try {
                    double number = Double.parseDouble(input);
                    numbers.add(number);
                    System.out.println("Choose an operation: +, -, *, /, E");
                    char operation = scanner.next().charAt(0);
                    //double result = numbers.get(0);
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
                        case'E':
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
    public static double add(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }
    public static double subtract(List<Double> numbers) {
        double result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }
        return result * -1;
    }
    public static double multiply(List<Double> numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }
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
