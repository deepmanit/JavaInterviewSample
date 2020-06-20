package TwoPointer;


    public class TwoPointerTest
    {
        public static void Test()
        {
            System.out.println("TwoPointerTest");

            int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
            System.out.println("RemoveDuplicates " + RemoveDuplicates.remove(arr));

            arr = new int[] { 2, 2, 2, 11 };
            System.out.println("RemoveDuplicates " + RemoveDuplicates.remove(arr));

            int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
            for (int num : result)
                System.out.print(num + " ");
            System.out.println();

            result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
            for (int num : result)
                System.out.print(num + " ");
            System.out.println();
            System.out.println("Triple zero");
            System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
            System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
            System.out.println("TripletSumCloseToTarget");
            System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
            System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
            System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
            System.out.println("TripletWithSmallerSum");
            System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
            System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

            System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
            System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));

             arr = new int[] { 1, 0, 2, 1, 0 };
            DutchFlag.sort(arr);
            for (int num : arr)
                System.out.print(num + " ");
            System.out.println();

            arr = new int[] { 2, 2, 0, 1, 2, 0 };
            DutchFlag.sort(arr);
            for (int num : arr)
                System.out.print(num + " ");

            System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
            System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
            System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
            System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));

            System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 4, 1, 2, -1, 1, -3 }, 1));
            System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2));

            System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
            System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
            System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
            System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
        }
    }

