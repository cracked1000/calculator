package org.example;

import java.util.List;

public class methods {
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
