package TwoPointer;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int [] result = new int[arr.length];
        int size = arr.length;
        int left = 0;
        int right = size -1;
        int pos = size -1;
        while (left <= right)
        {
            int leftdata = arr[left]*arr[left];
            int rightdata = arr[right]*arr[right];
            if(leftdata < rightdata) {
                result[pos--] = rightdata;
                --right;
            }
            else {
                result[pos--] = leftdata;
                ++left;
            }


        }
        return  result;
    }
}
