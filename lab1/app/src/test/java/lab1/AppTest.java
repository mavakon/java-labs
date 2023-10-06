package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class StringCalculatorTest {
    private final StringCalculator calculatorTest = new StringCalculator();

    @Nested
    @DisplayName("Tests for Step 1")
    class Step1Tests {
        @Test
        @Disabled("Only required for Step 1")
        void lessThanTwoNumbers() {
            assertThrows(IllegalArgumentException.class, () -> calculatorTest.add("1,2,3"));
        }

        @Test
        void noNumbers() {
            assertEquals(calculatorTest.add(""), 0);
        }

        @Test
        void oneNumber() {
            assertEquals(calculatorTest.add("1"), 1);
        }

        @Test
        void twoNumbers() {
            assertEquals(calculatorTest.add("1,2"), 3);
        }

        @ParameterizedTest(name = "{0}")
        @DisplayName("Consecutive delimiters or other symbols")
        @ValueSource(strings = {"1,,3", "2,d", "d,2", ",,23", ",2ad"})
        void DelimitersOrSymbols(String numbers) {
            assertThrows(IllegalArgumentException.class, () -> calculatorTest.add(numbers));
        }
    }
    @Nested
    @DisplayName("Tests for Step 2")
    class Step2Tests{
        @ParameterizedTest(name = "{0}")
        @DisplayName("More than 2 numbers")
        @ValueSource(strings = {"1,3,3,3", "5,0,5,0", "1,2,2,3,1,1", "1,1,1,1,1,1,1,1,1,1"})
        void DelimitersOrSymbols(String numbers) {
            assertEquals(calculatorTest.add(numbers), 10);
        }
    }
    @Nested
    @DisplayName("Tests for Step 3")
    class Step3Tests {
        @ParameterizedTest(name = "{0}")
        @DisplayName("\\n as new possible delimiter")
        @ValueSource(strings = {"1,2\\n3", "1\\n2,3", "1\\n2\\n3"})
        void NewDelimitor(String numbers) {
            assertEquals(calculatorTest.add(numbers), 6);
        }
        @ParameterizedTest(name = "{0}")
        @DisplayName("Consecutive delimiters with \\n")
        @ValueSource(strings = {"1,2,\\n3", "1\\n\\n2,3", ",\\n12,3", "1,\\n"})
        void DelimitersOrSymbols(String numbers) {
            assertThrows(IllegalArgumentException.class, () -> calculatorTest.add(numbers));
        }


    }


}
