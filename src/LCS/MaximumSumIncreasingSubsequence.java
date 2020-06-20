package LCS;

import java.util.Map;

public class MaximumSumIncreasingSubsequence {
    public int findMSIS(int[] nums) {
        return findMSISRecursive(nums, 0, -1, 0);
    }

    private int findMSISRecursive(int[] nums, int currentIndex, int previousIndex, int sum) {
        if(currentIndex == nums.length)
            return sum;

        // include nums[currentIndex] if it is larger than the last included number
        int s1 = sum;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            s1 = findMSISRecursive(nums, currentIndex+1, currentIndex, sum + nums[currentIndex]);

        // excluding the number at currentIndex
        int s2 = findMSISRecursive(nums, currentIndex+1, previousIndex, sum);

        return Math.max(s1, s2);
    }
    private int findMSISRecursive(Map<String, Integer> dp, int[] nums, int currentIndex, int previousIndex, int sum) {
        if(currentIndex == nums.length)
            return sum;

        String subProblemKey = currentIndex + "-" + previousIndex + "-" + sum;
        if(!dp.containsKey(subProblemKey)) {
            // include nums[currentIndex] if it is larger than the last included number
            int s1 = sum;
            if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
                s1 = findMSISRecursive(dp, nums, currentIndex+1, currentIndex, sum + nums[currentIndex]);

            // excluding the number at currentIndex
            int s2 = findMSISRecursive(dp, nums, currentIndex+1, previousIndex, sum);
            dp.put(subProblemKey, Math.max(s1, s2));
        }

        return dp.get(subProblemKey);
    }
    public int findMSISDP(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = nums[i];
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i])
                    dp[i] = dp[j] + nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
