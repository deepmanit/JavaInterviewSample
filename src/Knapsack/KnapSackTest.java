package Knapsack;

public class KnapSackTest {
    public static void test()
    {
        Knapsack01 ks = new Knapsack01();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);


        maxProfit = ks.solveKnapsackusingTopDown(profits, weights, 7);
        System.out.println("Total knapsack profit topDown ---> " + maxProfit);
        maxProfit = ks.solveKnapsackusingTopDown(profits, weights, 6);
        System.out.println("Total knapsack profit topDown ---> " + maxProfit);

        maxProfit = ks.solveKnapsackusingDP(profits, weights, 7);
        System.out.println("Total knapsack profit topDown ---> " + maxProfit);
        maxProfit = ks.solveKnapsackusingDP(profits, weights, 6);
        System.out.println("Total knapsack profit topDown ---> " + maxProfit);
        System.out.println("PartitionSet Subset Sum");
        PartitionSet ps = new PartitionSet();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(ps.canPartition(num));
        System.out.println(ps.canPartitionTopDown(num));
        System.out.println(ps.canPartitionDp(num));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(ps.canPartition(num));
        System.out.println(ps.canPartitionTopDown(num));
        System.out.println(ps.canPartitionDp(num));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(ps.canPartition(num));
        System.out.println(ps.canPartitionTopDown(num));
        System.out.println(ps.canPartitionDp(num));


        PartitionSetSumDiff ps1 = new PartitionSetSumDiff();
        int[] num1 = {1, 2, 3, 9};
        System.out.println(ps1.canPartition(num1));
        System.out.println(ps1.canPartitionTopDown(num1));
        System.out.println(ps1.canPartitionDP(num1));
        num1 = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps1.canPartition(num1));
        System.out.println(ps1.canPartitionTopDown(num1));
        System.out.println(ps1.canPartitionDP(num1));
        num1 = new int[]{1, 3, 100, 4};
        System.out.println(ps1.canPartition(num1));
        System.out.println(ps1.canPartitionTopDown(num1));
        System.out.println(ps1.canPartitionDP(num1));

        CountSubSetOfGiveSum ss = new CountSubSetOfGiveSum();
        num = new int[] {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        System.out.println(ss.countSubsetsTopDown(num, 4));
        System.out.println(ss.countSubsetsDP(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
        System.out.println(ss.countSubsetsTopDown(num, 9));
        System.out.println(ss.countSubsetsDP(num, 9));
    }
}
