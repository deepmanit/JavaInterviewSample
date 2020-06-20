package TwoPointer;

import java.util.Arrays;

public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        int size = arr.length;
        if(size < 2)
            throw new IllegalArgumentException("size is less than 2");
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }
    public static int searchPair(int[] arr,int targetSum,int first)
    {
        int low = first+1;
        int high = arr.length -1;
        int count=0;
        while(low < high)
        {
            if(arr[low] + arr[high] < targetSum) {
                count += high - low;
                ++low;
            }
            else {
                high--; // we need a pair with a smaller sum
            }
        }
        return count;
    }
}
