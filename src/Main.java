import CollectionTest.ArrayListTest;
import Java8.StreamTest;
import Knapsack.KnapSackTest;
import LCS.LCSTEST;
import Threading.ThreadingTest;
import TwoPointer.TwoPointerTest;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int MAX_CHARS = 256;
    static String findSubString(String str)
    {
        int strLen = str.length();
        int distcount = 0;
        boolean[] visited = new boolean[MAX_CHARS];
        Arrays.fill(visited, false);
        for (int i = 0; i < strLen; i++) {
            if (visited[str.charAt(i)] == false) {
                visited[str.charAt(i)] = true;
                distcount++;
            }
        }
        int start = 0, start_index = -1;
        int min_len = Integer.MAX_VALUE;

        int count = 0;
        int[] curr_count = new int[MAX_CHARS];
        for (int j = 0 ; j < strLen; ++j)
        {
            curr_count[str.charAt(j)]++;
            if(curr_count[str.charAt(j)] ==1 )
                ++count;
            if(count == distcount)
            {
                while (curr_count[str.charAt(start)] > 1) {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }
                int window_len = j - start +1;
                if(min_len > window_len)
                {
                    min_len = window_len;
                    start_index = start;
                }
            }
        }
        return str.substring(start_index, start_index + min_len);
    }
    static String findSubString(String str, String pat)
    {
        int strLen = str.length();
        int patLen = pat.length();

        if(patLen > strLen)
        {
            System.out.println("no ");
            return  " ";
        }
        int[] patVisited  = new int[256];
        int[] strVisited = new int[256];
        for(int i = 0; i < patLen; ++i)
        {
            patVisited[pat.charAt(i)]++;
        }
        int count = 0;
        int start_index = -1;
        int  min_len = Integer.MAX_VALUE;
        int start = 0;
        for(int j = 0; j < strLen; ++j)
        {
            strVisited[str.charAt(j)]++;
            if(patVisited[str.charAt(j)] !=0
            && strVisited[str.charAt(j)] <= patVisited[str.charAt(j)]
            )
            {
                ++count;
            }

            if(count == patLen)
            {
               while (patVisited[str.charAt(start)] == 0 ||
                        strVisited[str.charAt(start)] > patVisited[str.charAt(start)])
                {
                    if (strVisited[str.charAt(start)] > patVisited[str.charAt(start)])
                        strVisited[str.charAt(start)]--;
                    ++start;
                }
                int len = j - start + 1;
                if(min_len > len)
                {
                    min_len = len;
                    start_index = start;
                }

            }
        }

        if(start_index == -1)
        {
            System.out.println("no string of pattern found");
            return  " ";
        }
        return str.substring(start_index, start_index + min_len);
    }


  static   int get_index(char ch)
    {
        if (ch == 'a')
            return 0;
        else if (ch == 'e')
            return 1;
        else if (ch == 'i')
            return 2;
        else if (ch == 'o')
            return 3;
        else if (ch == 'u')
            return 4;

            // Returns -1 for consonants
        else
            return -1;
    }

    // Function to find the minimum length
   static int findMinLength(String s)
    {
        int [] countArray = new int[5];
        Arrays.fill(countArray,0);
        int start = 0;
        int len = s.length();
        for(int i = 0; i < s.length(); ++i)
        {
            int id = get_index(s.charAt(i));
            if(id != -1)
            {
                countArray[id]++;
            }
            int idx = get_index(s.charAt(start));
            while (idx == -1 || countArray[idx] > 1)
            {
                if(idx != -1)
                {
                    countArray[idx]--;
                }
                ++start;
                if (start < s.length())
                    idx = get_index(s.charAt(start));
            }
            if (countArray[0] > 0 && countArray[1] > 0
                    && countArray[2] > 0 && countArray[3] > 0
                    && countArray[4] > 0) {
                len = Math.min(len, i - start + 1);
            }
        }
        return len;

    }
        public static void main(String[] args) throws InterruptedException{
         /*   String s = "aaeebbeaccaaoiuooooooooiuu";
            System.out.println(findMinLength(s));
            // String str = "aabcbcdbca";
          //  System.out.println("Smallest window containing all distinct"
                //    + " characters is: " + findSubString(str));

            /*System.out.print("Smallest window is :\n " +
                    findSubString(str, pat));
            System.out.println("Hello World!");*/

        /*    System.out.println("Maximum number of fruits: " +
                    MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
            System.out.println("Maximum number of fruits: " +
                    MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));

            System.out.println("Maximum sum of a subarray of size K: "
                    + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
            System.out.println("Maximum sum of a subarray of size K: "
                    + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
        Singleton.getInstance();

            System.out.println("Length of the longest NoRepeatSubstring: " + NoRepeatSubstring.findLength("aabccbb"));
            System.out.println("Length of the longest NoRepeatSubstring: " + NoRepeatSubstring.findLength("abbbb"));
            System.out.println("Length of the longest NoRepeatSubstring: " + NoRepeatSubstring.findLength("abccde"));

            int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
            System.out.println("Smallest subarray length: " + result);
            result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
            System.out.println("Smallest subarray length: " + result);
            result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
            System.out.println("Smallest subarray length: " + result);

            System.out.println(CharacterReplacement.findLength("aabccbb", 2));
            System.out.println(CharacterReplacement.findLength("abbcb", 1));
            System.out.println(CharacterReplacement.findLength("abccde", 1));

            System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
            System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
            System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
            System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
            System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));



            List<Integer> result1 = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
            System.out.println(result1);
            result1 = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
            System.out.println(result1);

            System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
            System.out.println(MinimumWindowSubstring.findSubstring("abdabca", "abc"));
            System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));

            TwoPointerTest.Test();
            KnapSackTest.test();
            LCSTEST.test();
            ArrayListTest.test();*/
            //StreamTest.test();
            ThreadingTest.test();
    }
}
