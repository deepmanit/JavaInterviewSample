package Knapsack;

public class Knapsack01 {
    public  int solveKnapsack(int[] profits, int[] weights, int capacity)
    {
        return knapsackRecursive(profits,weights,capacity,0);
    }
    private   int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
       if(capacity < 0 || currentIndex>=weights.length)
           return 0;
       int include =0;

        if( weights[currentIndex] <= capacity )
            include = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int exclude = knapsackRecursive(profits, weights, capacity, currentIndex + 1);
        return Math.max(include,exclude);
    }

    public int solveKnapsackusingTopDown(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursiveUsingTopDown(dp, profits, weights, capacity, 0);
    }
    private int knapsackRecursiveUsingTopDown(Integer[][] dp, int[] profits, int[] weights, int capacity,
                                  int currentIndex) {
        if(capacity < 0 || currentIndex>=weights.length)
            return 0;
        if(dp[currentIndex][capacity] != null)
            return dp[currentIndex][capacity];
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursiveUsingTopDown(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursiveUsingTopDown(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }
    public int solveKnapsackusingDP(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];
        for(int i=0; i < n; i++)
            dp[i][0] = 0;
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }
        for (int w = 1; w < n; ++w)
        {
            for (int c = 1; c <= capacity; ++c)
            {
                int profit1 = 0;
                int profit2 = 0;
                if(weights[w] <= c)
                    profit1 = profits[w] + dp[w-1][c-weights[w]];
                profit2 = dp[w-1][c];

                dp[w][c] = Math.max(profit1,profit2);

            }
        }
        return dp[weights.length -1][capacity];
    }
}
