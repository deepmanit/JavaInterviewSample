package LCS;

public class LCSTEST {
    public static void test()
    {
        LongestCommonSubString lcs = new LongestCommonSubString();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}
