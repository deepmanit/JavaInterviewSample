public class MinSizeSubArraySum {

    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int i = 0 ; i < arr.length; ++i)
        {
            windowSum = windowSum + arr[i];
            while (windowSum >= S)
            {
                minLength = Math.min(minLength,i - windowStart + 1);
                windowSum-=arr[windowStart];
                ++windowStart;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
