package lab1;

import java.util.ArrayList;
import java.util.regex.*;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        String delimiter = ",|\\\\n";

        if (numbers.isBlank()) return sum;

        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\\n");
            if (delimiterEndIndex < 0) throw new IllegalArgumentException("Delimiter specification is incorrect.");
            Pattern customDelimPattern = Pattern.compile("\\[([^]]+)]");
            Matcher matcher = customDelimPattern.matcher(numbers.substring(2, delimiterEndIndex));

            StringBuilder customDelimiters = new StringBuilder();
            while (matcher.find()) { // Change from if to while to handle multiple delimiters
                if (!customDelimiters.isEmpty()) {
                    customDelimiters.append("|");
                }
                customDelimiters.append(Pattern.quote(matcher.group(1))); // Quote special characters in delimiter
            }

            if (!customDelimiters.isEmpty()) {
                delimiter += "|" + customDelimiters;
            } else {
                delimiter += "|" + Pattern.quote(numbers.substring(2, delimiterEndIndex));
            }

            numbers = numbers.substring(delimiterEndIndex + 2);
        }

        if (numbers.matches(".*(" + delimiter + "){2,}.*")) {
            throw new IllegalArgumentException("Consecutive delimiters found.");
        }

        ArrayList<String> negativeNumbers = new ArrayList<>();
        String[] numberArray = numbers.split(delimiter);
        for (String x: numberArray) {
            try{
                if (Integer.parseInt(x) < 0) {
                    negativeNumbers.add(x);
                } else if (Integer.parseInt(x) < 1001) {
                    sum += Integer.parseInt(x);
                }
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("String contains symbols other than delimiters or integers.\n" +
                        " OR it has consecutive delimiters.");
            }
        }
        if (negativeNumbers.isEmpty()){
            return sum;
        }
        else {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + String.join(", ", negativeNumbers));
        }
   }
}
