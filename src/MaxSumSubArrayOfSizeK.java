public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {

        int windowstart = 0;
        int cursum = 0;
        int maxsum =0;
        for(int i = 0 ; i < arr.length; ++i )
        {
            cursum = cursum + arr[i];
            if(i>=k-1)
            {
                maxsum = Math.max(maxsum,cursum);
                cursum-=arr[windowstart];
                ++windowstart;
            }
        }
        return maxsum;
    }
}
