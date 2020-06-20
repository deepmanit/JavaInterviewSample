package Knapsack;
/*Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
Input: {1, 1, 2, 3}, S=4
Output: 3
The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
Note that we have two similar sets {1, 3}, because we have two '1' in our input.
Example 2: #
Input: {1, 2, 7, 1, 5}, S=9
Output: 3
The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
 */
public class CountSubSetOfGiveSum {
    public int countSubsets(int[] num, int sum) {
        return this.countSubsetsRecursive(num, sum, 0);
    }
    public int countSubsetsTopDown(int[] num, int sum) {
        Integer [][] dp = new Integer[num.length][sum+1];
        return this.countSubsetsRecursiveTopDown(dp,num, sum, 0);
    }

    private int countSubsetsRecursive(int[] num, int sum, int currentIndex) {
        // base checks
        if (sum == 0)
            return 1;

        if(num.length == 0 || currentIndex >= num.length)
            return 0;

        // recursive call after selecting the number at the currentIndex
        // if the number at currentIndex exceeds the sum, we shouldn't process this
        int sum1 = 0;
        if( num[currentIndex] <= sum )
            sum1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countSubsetsRecursive(num, sum, currentIndex + 1);

        return sum1 + sum2;
    }
    private int countSubsetsRecursiveTopDown(Integer[][]dp, int[] num, int sum, int currentIndex) {
        if( sum ==0)
            return 1;
        if(currentIndex>= num.length || num.length ==0)
            return 0;
        if(dp[currentIndex][sum] == null)
        {
            int sum1 = 0;
            if(num[currentIndex]<=sum)
            {
                sum1 = countSubsetsRecursiveTopDown(dp,num,sum-num[currentIndex],currentIndex+1);
            }
            int sum2 = countSubsetsRecursiveTopDown(dp,num,sum,currentIndex+1);
            dp[currentIndex][sum] = sum1+sum2;

        }
        return dp[currentIndex][sum];
    }
    public int countSubsetsDP(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for(int i=0; i < n; i++)
            dp[i][0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to its value
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for(int i=1; i < num.length; i++) {
            for(int s=1; s <= sum; s++) {
                // exclude the number
                dp[i][s] = dp[i-1][s];
                // include the number, if it does not exceed the sum
                if(s >= num[i])
                    dp[i][s] += dp[i-1][s-num[i]];
            }
        }

        // the bottom-right corner will have our answer.
        return dp[num.length-1][sum];
    }

}
