package TwoPointer;

public class DutchFlag {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length -1;
        for(int i = 0; i <= right; )
        {
            if(arr[i] == 0)
            {
                swap(arr,i,left);
                ++i;
                ++left;
            }
            else if(arr[i] ==2)
            {
                swap(arr,i,right);
                --right;

            }
            else
            {
                ++i;
            }
        }
    }
}
