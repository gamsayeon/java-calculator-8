package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static String regex = "[,:]";

    public static int calculate(String input) {
        String extractString = removeDelimiterString(input);

        String[] numbers = extractString.split(regex);
        return Arrays.stream(numbers)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static String removeDelimiterString(String input){
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            regex = regex.replace("]",matcher.group(1)+"]");
            return matcher.replaceAll("");
        }
        return input;
    }
}
