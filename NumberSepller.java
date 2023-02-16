public class NumberSepller {


    private static final String[] ONES = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };


    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String spellOutNumber(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();
        int thousands = number / 1000;
        int hundreds = (number % 1000) / 100;
        int tens = (number % 100) / 10;
        int ones = number % 10;

        if (thousands > 0) {
            result.append(ONES[thousands]).append(" thousand ");
        }

        if (hundreds > 0) {
            result.append(ONES[hundreds]).append(" hundred ");
        }

        if (tens == 1) {
            result.append(ONES[number % 100]);
        } else if (tens > 1) {
            result.append(TENS[tens]);
            if (ones > 0) {
                result.append("-");
            }
        }

        if (ones > 0 && tens != 1) {
            result.append(ONES[ones]);
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 5, 8, 10, 21, 77, 100, 303, 555, 2000, 3466, 2400, 5300,6792};
        for (int number : numbers) {
            System.out.println(spellOutNumber(number));
        }
    }
}