import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; ++windowEnd)
        {
            char rightChar = arr[windowEnd];
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar,0) + 1);
            while (charFrequencyMap.size() > 2)
            {
                // maxLength = Math.max(maxLength,windowEnd-windowStart +1);
                char charLeft = arr[windowStart];;
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
