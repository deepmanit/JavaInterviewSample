package TwoPointer;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 2)
            throw new IllegalArgumentException();
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i +1;
            int right = arr.length -1;
            while (left < right)
            {
                int targetDiff = targetSum - arr[i] - arr[left] -arr[right];
                if(targetDiff ==0)
                    return targetSum - targetDiff;
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference)
                        && targetDiff > smallestDifference))
                    smallestDifference = targetDiff; // save the closest and the biggest difference

                if (targetDiff > 0)
                    left++; // we need a triplet with a bigger sum
                else
                    right--; // we need a triplet with a smaller sum


            }
        }
        return targetSum - smallestDifference;
    }

}
