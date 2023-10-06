package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringCalculator stringCalculator = new StringCalculator();

        System.out.println("String Calculator");
        System.out.print("Input: ");
        String numbers = scanner.nextLine();
        System.out.println("Output: " + stringCalculator.add(numbers));


    }
}
