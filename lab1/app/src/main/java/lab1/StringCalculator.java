package lab1;

import java.util.regex.*;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        String delimiter = ",|\\\\n";

        if (numbers.isBlank()) return sum;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\\n");
            if (delimiterEndIndex < 0) throw new IllegalArgumentException("Delimiter specification is incorrect.");
            delimiter += "|" + Pattern.quote(numbers.substring(2, delimiterEndIndex));
            numbers = numbers.substring(delimiterEndIndex + 2);
        }

        if (numbers.matches(".*(" + delimiter + "){2,}.*")) {
            throw new IllegalArgumentException("Consecutive delimiters found.");
        }

        String[] numberArray = numbers.split(delimiter);
        for (String x: numberArray) {
            try{
                sum += Integer.parseInt(x);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("String contains symbols other than delimiters or integers.\n" +
                        " OR it has consecutive delimiters.");
            }
        }
       return sum;
   }
}
