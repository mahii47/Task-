import java.util.*;

public class CoinChangeCalculator {
    public static void main(String[] args) {

        int[] usDollarDenominations = {1, 5, 10, 25};
        int[] britishPoundDenominations = {1, 2, 5, 10, 20, 50};
        int[] norwegianKroneDenominations = {1, 5, 10, 20};

        int usDollarAmount = 43;
        int britishPoundAmount = 43;
        int norwegianKroneAmount = 43;

   
        int[] usDollarChange = calculateMinCoins(usDollarDenominations, usDollarAmount);
        int[] britishPoundChange = calculateMinCoins(britishPoundDenominations, britishPoundAmount);
        int[] norwegianKroneChange = calculateMinCoins(norwegianKroneDenominations, norwegianKroneAmount);

        System.out.println("US Dollar Change: " + Arrays.toString(usDollarChange));
        System.out.println("British Pound Change: " + Arrays.toString(britishPoundChange));
        System.out.println("Norwegian Krone Change: " + Arrays.toString(norwegianKroneChange));
    }

    public static int[] calculateMinCoins(int[] denominations, int amount) {
        int[] result = new int[denominations.length];
        int remainingAmount = amount;

        for (int i = denominations.length - 1; i >= 0; i--) {
            if (remainingAmount >= denominations[i]) {
                result[i] = remainingAmount / denominations[i];
                remainingAmount %= denominations[i];
            }
        }

        return result;
    }
}
