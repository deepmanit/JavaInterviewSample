package FiibPattern;
/*At every step, we have three options: either jump 1 step, 2 steps, or 3 steps.
So our algorithm will look like this:*/
public class Staircase {
    public int CountWays(int n) {
        if(n ==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int s1 = CountWays(n-1);
        int s2 = CountWays(n-2);
        int s3 = CountWays(n-3);
        return s1+s2+s3;
    }

    public int CountWaysTop(int n) {
        int dp[] = new int[n+1];
        return CountWaysRecursive(dp, n);
    }

    public int CountWaysRecursive(int[] dp, int n) {
        if( n == 0)
            return 1; // base case, we don't need to take any step, so there is only one way

        if(n == 1)
            return 1; // we can take one step to reach the end, and that is the only way

        if(n == 2)
            return 2; // we can take one step twice or jump two steps to reach at the top

        if(dp[n] == 0) {
            // if we take 1 step, we are left with 'n-1' steps;
            int take1Step = CountWaysRecursive(dp, n-1);
            // similarly, if we took 2 steps, we are left with 'n-2' steps;
            int take2Step = CountWaysRecursive(dp, n-2);
            // if we took 3 steps, we are left with 'n-3' steps;
            int take3Step = CountWaysRecursive(dp, n-3);
            dp[n] = take1Step + take2Step + take3Step;
        }

        return dp[n];
    }
    public int CountWaysDP(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        return dp[n];
    }

    /*public static void main(String[] args) {
    Staircase sc = new Staircase();
    System.out.println(sc.CountWays(3));
    System.out.println(sc.CountWays(4));
    System.out.println(sc.CountWays(5));
  }*/
}
