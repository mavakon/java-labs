package lab1;

public class StringCalculator {
    public int add(String numbers) {
        int sum = 0;

        if (numbers.isBlank()) return sum;
        if (numbers.endsWith(",") || numbers.endsWith("\\n")) throw new IllegalArgumentException("String should not end with a delimitor.");

        String[] numberArray = numbers.split(",|\\\\n");
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
