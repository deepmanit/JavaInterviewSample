import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        //Input: String="cbbebi", K=3
        //Output: 5
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); ++windowEnd)
        {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0) + 1);
            while (charFrequencyMap.size() > k)
            {
               // maxLength = Math.max(maxLength,windowEnd-windowStart +1);
                char charLeft = str.charAt(windowStart);
                charFrequencyMap.put(charLeft,charFrequencyMap.get(charLeft) -1);
                if(charFrequencyMap.get(charLeft) == 0) {
                    charFrequencyMap.remove(charLeft);
                }
                ++windowStart;
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart +1);
        }
        return maxLength;

    }
}
