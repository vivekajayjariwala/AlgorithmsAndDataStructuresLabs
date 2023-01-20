//public class SearchForVector {
//    public static void main(String[]
//                                    args) {






//        int[][] Generator = {
//                {1, 1, 1, 0, 0, 0, 0},
//                {1, 0, 0, 1, 1, 0, 0},
//                {0, 1, 0, 1, 0, 1, 0},
//                {1, 1, 0, 1, 0, 0, 1}
//        };
//        for (int i = 0; i < 4; i++) {
//            System.out.print("[");
//            for (int j = 0; j < 7; j++)
//            {
//                System.out.print(G[i][j]
//                        + ", ");
//            }
//        }
//        int[] c1, c2, c3, c4, c5;

//        c1 = new int[7];
//        c2 = new int[7];
//        c3 = new int[7];
//        c4 = new int[7];
//        c5 = new int[7];

//        insertArray(c1);
//        insertArray(c2);
//        insertArray(c3);
//        insertArray(c4);
//        insertArray(c5);


//        compute(c1, G);
//        compute(c2, G);
//        compute(c3, G);
//        compute(c4, G);
//        compute(c5, G);
//    }
//    public static void
//    insertArray(int[] c)
//    {

//        double number;
//        for (int i = 0; i < 7; i++) {
//            number = Math.random();
//            if (number > 0.5)
//            {
//                number = 1;
//            }
//            else
//            {
//                number = 0;
//            }
//            c[i] = (int)number;
//        }
//    }
//    public static int search(int r,
//                                int[][] G)
//    {
//        int hw = 0;
//        for (int i = 0; i < 7; i++) {
//            if (G[r][i] == 1)
//            {
//                hw++;
//            }
//        }
//        return hw;
//    }
//    public static int findingNumber(int
//                                            r, int[][] G, int[] c)
//    {
//        int same = 0;for (int i = 0; i
//            < 7; i++) {
//        if (G[r][i] == c[i])
//        {
//            same++;
//        }
//    }
//        return same;
//    }
//    public static int
//    findingSmallest(int a, int b)
//    {
//        if (a < b)
//        {
//            return a;
//        }
//        else
//        {
//            return b;
//        }
//    }
//    public static int
//    findNext(int a, int b)
//    {
//        if (a > b)
//        {
//            return a;
//        }
//        else
//        {
//            return b;
//        }
//    }
//    public static void
//    compute(int[] c, int[][] G)
//    {
//
//        for (int j = 0; j < 7; j++) {
//            System.out.print(c[j] + ",
//                    ");
//        }
//        System.out.println("\b\b]");
//        int same1, same2, same3, same4;
//        same1 = findingNumber(0, G, c);
//        same2 = findingNumber(1, G, c);
//        same3 = findingNumber(2, G, c);
//        same4 = findingNumber(3, G, c);
//        int closest = 0;
//        int sf1 = findingClosest(same1,
//                same2);
//        int sf2 = findingClosest(same3,
//                same4);
//        closest = findingClosest(sf1,
//                sf2);
//        int hw1, hw2, hw3, hw4;
//        hw1 = findingHW(0, G);
//        hw2 = findingHW(1, G);
//        hw3 = findingHW(2, G);
//        hw4 = findingHW(3, G);
//        int sf3 = findingSmallest(hw1,
//                hw2);
//        int sf4 = findingSmallest(hw3,
//                hw4);
//
//        int smallestHW =
//                findingSmallest(sf3, sf4);
//        if (smallestHW < (7 - closest))
//        {
//            closest = 0;
//        }
//        int row = 0;
//        boolean check = true;
//        if (closest == 0)
//        {
//            check = false;

//        }
//        else if (closest == same1)
//        {
//            row = 1;
//        }
//        else if (closest == same2)
//        {
//            row = 2;
//        }
//        else if (closest == same3)
//        {
//            row = 3;
//        }
//        else
//        {
//            row = 4;
//        }
//        if (check)
//        {
//            for (int j = 0; j < 7; j++)
//            {
//                System.out.print(G[row -
//                        1][j] + ", ");
//            }
//            System.out.println("\b\b]");
//        }
//    }
//}