package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        // TODO: Write your code here
        for(int start = 0; start < arr.length - 2; ++start)
        {
            if (start > 0 && arr[start] == arr[start - 1]) // skip same element to avoid duplicate triplets
                continue;
            //int leftdata = arr[start];
            int left = start +1;
            int right = arr.length -1;
            while (left <= right)
            {
                if(arr[left] + arr[start] + arr[right] == 0)
                {
                    List<Integer> res = new ArrayList<>();
                    triplets.add(Arrays.asList(arr[start],arr[left],arr[right]));
                    ++left;
                    --right;
                }
                else if(arr[left] + arr[start] + arr[right] < 0)
                {
                    ++left;
                }
                else
                {
                    --right;
                }
            }

        }
        return triplets;
    }
}
