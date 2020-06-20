package Knapsack;

public class PartitionSet {
    public boolean canPartition(int[] num) {
        int sum = getSum(num);
        if(sum%2 !=0)
            return false;
        return canPartitionRecursive(num,sum/2,0);
    }
    private boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {
        if(sum == 0)
            return true;

        if(num.length == 0 || currentIndex >= num.length )
            return false;
        if( num[currentIndex] <= sum ) {
            if(canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
                return true;
        }
        return canPartitionRecursive(num, sum ,currentIndex + 1);
    }
    private int getSum(int[] num)
    {
        int sum = 0;
        for (int n:num ) {
            sum+=n;

        }
        return sum;
    }
    public boolean canPartitionTopDown(int[] num)
    {
        int sum = getSum(num);
        if(sum%2 !=0)
            return false;
        Boolean dp[][] = new Boolean[num.length][sum/2+1];
        return canPartitionRecursiveTopDown(dp,num,sum/2,0);
    }
    private boolean canPartitionRecursiveTopDown(Boolean [][]dp,int[]num, int sum,int curIndex)
    {
        if(sum == 0)
            return true;
        if(num.length == 0 || curIndex >= num.length )
            return false;
        if(dp[curIndex][sum] != null)
            return  dp[curIndex][sum];
        Boolean inc = false;
        Boolean excl = false;
        if(num[curIndex]<=sum)
        {
            inc = canPartitionRecursiveTopDown(dp,num,sum-num[curIndex],curIndex+1);
        }
        excl = canPartitionRecursiveTopDown(dp,num,sum,curIndex+1);

        dp[curIndex][sum] = inc || excl;
        return dp[curIndex][sum];

    }

    public boolean canPartitionDp(int[] num)
    {
        int sum = getSum(num);
        if(sum%2 !=0)
            return false;
        sum/=2;
        int n = num.length;
        Boolean dp[][] = new Boolean[num.length][sum+1];
        for(int i=0; i < n; i++)
            dp[i][0] = true;
        for(int s = 0; s <= sum ; ++s)
        {
            dp[0][s] = (num[0] == s ? true : false);
        }
        for(int i = 1; i < num.length; ++i)
        {
            for(int s = 1; s <= sum ; ++s)
            {
                dp[i][s] = dp[i-1][s];
                if(num[i] <= s)
                    dp[i][s]=dp[i][s] || dp[i-1][s-num[i]];
             }
        }
        return dp[n-1][sum];
    }
}
