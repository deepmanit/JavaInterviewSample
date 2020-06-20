package TwoPointer;


public class RemoveDuplicates {
   public static int remove(int[] arr)
    {
        int slow = 1;
        int fast = 1;
        for(; fast<arr.length;++fast)
        {
            if(arr[slow -1] !=arr[fast])
            {
                arr[slow] = arr[fast];
                ++slow;
            }
        }
        return  slow;
    }
}
