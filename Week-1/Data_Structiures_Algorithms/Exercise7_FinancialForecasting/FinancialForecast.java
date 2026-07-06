import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double futureValueOptimized(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = futureValueOptimized(presentValue, growthRate, years - 1) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    public static void main(String[] args) {
        double presentValue = 100000.0;
        double growthRate = 0.08;
        int years = 10;

        double result = futureValue(presentValue, growthRate, years);
        System.out.println("Projected future value after " + years + " years: " + result);

        double optimizedResult = futureValueOptimized(presentValue, growthRate, years);
        System.out.println("Projected future value (optimized): " + optimizedResult);
    }
}
