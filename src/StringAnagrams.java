import java.util.*;

public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        Map<Character,Integer> charCount = new HashMap<>();
        for(char ch:pattern.toCharArray())
        {
            charCount.put(ch,charCount.getOrDefault(ch,0)+1);
        }
        int windowstart = 0;
        int matched = 0;
        for (int windowEnd = 0; windowEnd<str.length(); windowEnd++)
        {
            char rightchar = str.charAt(windowEnd);
            if(charCount.containsKey(rightchar))
            {
                charCount.put(rightchar,charCount.get(rightchar) -1);
                if(charCount.get(rightchar) ==0)
                    ++matched;
            }
            if(matched == charCount.size())
                result.add(windowstart);
            if(windowEnd >= pattern.length())
            {
                char leftChar = str.charAt(windowstart++);
                if(charCount.containsKey(leftChar))
                {
                    if(charCount.get(leftChar) ==0)
                         --matched;

                    charCount.put(leftChar,charCount.get(leftChar) +1);

                }
            }
        }
        return result;

    }
}
