import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    private static Map<Integer, Double> memo = new HashMap<>();

    // Optimized method to calculate future value using recursion with memoization
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods is 0, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Check if the result is already computed
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        // Recursive case: calculate the future value for the next period
        double futureValue = calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
        memo.put(periods, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        // Example usage
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 periods (years)

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("The future value after " + periods + " years is: " + futureValue);
    }
}
