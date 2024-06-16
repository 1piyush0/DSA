import java.util.*;

public class MaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        Map<Integer, Integer> freqProfit = new HashMap<>();
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                int profit = prices[i] - prices[i - 1];
                freqProfit.put(profit, freqProfit.getOrDefault(profit, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : freqProfit.entrySet()) {
            int profit = entry.getKey();
            int freq = entry.getValue();
            maxProfit = Math.max(maxProfit, profit * freq);
        }

        System.out.println(maxProfit);
        sc.close();
    }
}
