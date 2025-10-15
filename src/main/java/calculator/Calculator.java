package calculator;

import java.util.Arrays;

public class Calculator {
    public static int calculate(String input) {
        String[] numbers = input.split("[,:]");
        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
