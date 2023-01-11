import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String BASIC_REGEX = ",|:";

    public static int splitAndSum(String str) {

        if(str == null || str.isEmpty()){
            return 0;
        }

        if(str.length() == 1){
            return Integer.valueOf(str);
        }


        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter + "|" + BASIC_REGEX);
            return splitStrSum(tokens);
        }

        return splitStrSum(str.split(BASIC_REGEX));
    }

    private static int splitStrSum(String[] splitStr) {
        int sum = 0;
        for(int i = 0; i < splitStr.length; i++){
            sum = strAdd(sum, splitStr[i]);
        }

        return sum;
    }

    private static int strAdd(int source, String addNumber) {
        return source + convertStrToPositiveNum(addNumber);
    }

    private static int convertStrToPositiveNum(String number) throws RuntimeException{
        try {
            Integer result = Integer.valueOf(number);

            if(result < 0){
                throw new RuntimeException();
            }

            return result;
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
