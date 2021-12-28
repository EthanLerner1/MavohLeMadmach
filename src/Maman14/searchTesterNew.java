package Maman14;

/**
 * Amit Yanay
 * searchTester
 */
public class searchTesterNew extends Ex14 {



    public static void main(String[] args) {

        System.out.println("--- Time complexity: O(logn), Space Complexity: O(1) ---\n");
        print("****Checking 1x1 array****");
        int[][] searchArray = new int[][]{{2}};
        boolean arr1x1t = search(searchArray, 2);
        boolean arr1x1f = search(searchArray, 3);
        if (arr1x1t) print("Returned OK for number 2");
        else err(2, false);
        if (!arr1x1f) print("Returned OK for number 3");
        else err(3, true);
        print("");

        print("****Checking 8x8 array****\n");
        print("---First quarter ---");
        check(true, 16);
        check(true, 18);
        check(true, 20);
        check(true, 8);
        print("***Numbers which are not in the array: ");
        check(false, 5);
        check(false, 7);
        check(false, 31);
        check(false, 11);

        print("");
        print("---Second quarter ---");
        check(true, 34);
        check(true, 42);
        check(true, 52);
        check(true, 60);
        print("***Numbers which are not in the array: ");
        check(false, 35);
        check(false, 41);
        check(false, 51);
        check(false, 55);

        print("");
        print("---Third quarter ---");

        check(true, 76);
        check(true, 68);
        check(true, 92);
        check(true, 88);
        print("***Numbers which are not in the array: ");
        check(false, 75);
        check(false, 67);
        check(false, 83);
        check(false, 91);

        print("");
        print("---Fourth quarter ---");

        check(true, 100);
        check(true, 106);
        check(true, 114);
        check(true, 126);
        print("***Numbers which are not in the array: ");
        check(false, 103);
        check(false, 109);
        check(false, 119);
        check(false, 125);

        System.out.println("\n**** Checking 16x16 array *****");
        print("");
        print("---First quarter ---");

        for (int i = 6; i <= 22; i+=2) {
            check16(true, i);
        }
        print("***Numbers which are not in the array: ");
        for (int i = 5; i <= 21; i+=2) {
            check16(false, i);
        }

        print("");
        print("---Second quarter ---");

        for (int i = 134; i <= 150; i+=2) {
            check16(true, i);
        }
        print("***Numbers which are not in the array: ");
        for (int i = 131; i <= 147; i+=2) {
            check16(false, i);
        }

        print("");
        print("--- Third quarter ---");

        check16(true, 280);
        check16(true, 328);
        check16(true, 334);
        check16(true, 372);
        check16(true, 410);
        check16(true, 412);
        check16(true, 508);
        check16(true, 368);
        print("***Numbers which are not in the array: ");
        for (int i = 263; i <= 279; i+=2) {
            check16(false, i);
        }

        print("");
        print("--- Fourth quarter ---");

        for (int i = 426; i <= 442; i+=2) {
            check16(true, i);
        }
        print("***Numbers which are not in the array: ");
        for (int i = 425; i <= 443; i+=2) {
            check16(false, i);
        }
    }

    private static void print(String sen) {
        System.out.println(sen);
    }

    private static void check(boolean needToFind, int num) {
        final int[][] arr = new int[][] {
                {2,4,10,12,34,36,42,44},
                {8,6,16,14,40,38,48,46},
                {26,28,18,20,58,60,50,52},
                {32,30,24,22,64,62,56,54},
                {98,100,106,108,66,68,74,76},
                {104,102,112,110,72,70,80,78},
                {122,124,114,116,90,92,82,84},
                {128,126,120,118,96,94,88,86}
        };
        if (needToFind && !search(arr, num)) {
            err(num, true);
        } else if (!needToFind && search(arr, num)) {
            err(num, false);
        } else {
            print(String.format("Returned OK for %s", num));
        }
    }

    private static void check16(boolean needToFind, int num) {
        int[][] arr = new int[][]{
                {2,4,10,12,34,36,42,44,130,132,138,140,162,164,170,172},
                {8,6,16,14,40,38,48,46,136,134,144,142,168,166,176,174},
                {26,28,18,20,58,60,50,52,154,156,146,148,186,188,178,180},
                {32,30,24,22,64,62,56,54,160,158,152,150,192,190,184,182},
                {98,100,106,108,66,68,74,76,226,228,234,236,194,196,202,204},
                {104,102,112,110,72,70,80,78,232,230,240,238,200,198,208,206},
                {122,124,114,116,90,92,82,84,250,252,242,244,218,220,210,212},
                {128,126,120,118,96,94,88,86,256,254,248,246,224,222,216,214},
                {422,424,430,432,454,456,462,464,258,260,302,304,326,328,334,336},
                {428,426,436,434,460,458,468,466,300,280,308,306,332,330,340,338},
                {446,448,438,440,478,480,470,472,318,320,310,312,350,352,342,344},
                {452,450,444,442,484,482,476,474,324,322,316,314,356,354,348,346},
                {518,520,526,528,486,488,494,496,390,392,398,400,358,360,366,368},
                {524,522,532,530,492,490,500,498,396,394,404,402,364,362,372,370},
                {542,544,534,536,510,512,502,504,414,416,406,408,382,384,374,376},
                {548,546,540,538,516,514,508,506,420,418,412,410,388,386,380,378}
        };
        if (needToFind && !search(arr, num)) {
            err(num, true);
        } else if (!needToFind && search(arr, num)) {
            err(num, false);
        } else {
            print(String.format("Returned OK for %s", num));
        }
    }

    private static void err(int num, boolean find) {
        if (!find) {
            System.out.printf("ERROR - Didn't find number %s%n", num);
        }
        else {
            System.out.printf("ERROR - Found number you shouldn't find %s%n", num);
        }
    }

    private static int Rect(int w, int h) {
        return w*h;
    }



}
