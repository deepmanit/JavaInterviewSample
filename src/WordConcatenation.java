
/*Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".
Example 2:

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {

        Map<String,Integer> wordFreqMap = new HashMap<>();
        for (String word:words ) {
            wordFreqMap.put(word,wordFreqMap.getOrDefault(word,0)+1);
        }
        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();
        for(int windowEnd = 0; windowEnd < str.length() - wordsCount*wordLength; ++ windowEnd)
        {

            Map<String, Integer> wordsSeen = new HashMap<>();
            for(int windowStart = 0; windowStart < wordsCount; ++windowStart)
            {
                int nextWordIndex = windowEnd + windowStart*wordsCount;
                String word = str.substring(nextWordIndex, nextWordIndex+wordLength);
                if(!wordFreqMap.containsKey(word))
                    break;
                wordsSeen.put(word,wordsSeen.getOrDefault(words,0)+1);
                if(wordsSeen.get(word) > wordFreqMap.getOrDefault(word, 0))
                    break;
                if(windowStart +1 == wordsCount)
                {
                    resultIndices.add(windowEnd);
                }
            }
        }
        return  resultIndices;

    }

}
