package LCS;

public class LongestCommonSubString {
    public int findLCSLength(String s1, String s2) {
        return findLCSLengthRecursive(s1, s2, 0, 0, 0);
    }

    private int findLCSLengthRecursive(String s1, String s2, int i1, int i2, int count) {
        if(i1 == s1.length() || i2 == s2.length())
            return count;
        if(s1.charAt(i1) == s2.charAt(i2))
        {
            count =  findLCSLengthRecursive(s1,s2,i1+1,i2+1,count+1);
        }
        int c1 = findLCSLengthRecursive(s1,s2,i1+1,i2,0);
        int c2 = findLCSLengthRecursive(s1,s2,i1,i2+1,0);
        return Math.max(count,Math.max(c1,c2));

    }
    public int findLCSLengthDP(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0;
        for(int i=1; i <= s1.length(); i++) {
            for(int j=1; j <= s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }
        return maxLength;
    }

}
