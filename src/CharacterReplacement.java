import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character,Integer> letterFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); ++windowEnd)
        {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar,letterFrequencyMap.getOrDefault(rightChar,0) +1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
            if(windowEnd-windowStart +1 - maxRepeatLetterCount > k)
            {
                char charLeft = str.charAt(windowStart);
                letterFrequencyMap.put(charLeft,letterFrequencyMap.get(charLeft) -1);
                ++windowStart;
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);

            }
        return maxLength;
        }

}
