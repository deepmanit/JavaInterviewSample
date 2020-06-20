package LCS;

public class LongestIncreasingSubsequnce {
    public int findLISLength(int[] nums) {
        return findLISLengthRecursive(nums, 0, -1);
    }

    private int findLISLengthRecursive(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        // include nums[currentIndex] if it is larger than the last included number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            c1 = 1 + findLISLengthRecursive(nums, currentIndex+1, currentIndex);

        // excluding the number at currentIndex
        int c2 = findLISLengthRecursive(nums, currentIndex+1, previousIndex);

        return Math.max(c1, c2);
    }
    private int findLISLengthRecursive(Integer[][] dp, int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        if(dp[currentIndex][previousIndex+1] == null) {
            // include nums[currentIndex] if it is larger than the last included number
            int c1 = 0;
            if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
                c1 = 1 + findLISLengthRecursive(dp, nums, currentIndex+1, currentIndex);

            int c2 = findLISLengthRecursive(dp, nums, currentIndex+1, previousIndex);
            dp[currentIndex][previousIndex+1] = Math.max(c1, c2);
        }

        return dp[currentIndex][previousIndex+1];
    }

    public int findLISLengthDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++)
                if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
                    dp[i] = dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }
        return maxLength;
    }
}
