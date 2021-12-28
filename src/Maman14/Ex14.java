package Maman14;

public class Ex14 {
    // region first task

    /**
     * this function calculates minimal distance between two numbers in given array.
     * this function has the time complexity of O(n), n = number of values in the given array.
     *
     * @param a array to search in
     * @param x number to get minimal distance from
     * @param y number to get minimal distance to
     * @return the minimal distance between x and y
     */
    public static int findMinDiff(int[] a, int x, int y) {
        int i = 0; // index for going over the array
        int startMeasure = 0; // index to start measuring from
        int minDiff = Integer.MAX_VALUE; // default value is Integer.MAX_VALUE

        // finding first time x or y appears
        for (; i < a.length; i++) {
            if (a[i] == x || a[i] == y) {
                startMeasure = i;
                break;
            }
        }

        // go over the rest of the array and search for minimal distance
        for (; i < a.length; i++) {
            if (a[i] == x || a[i] == y) { // if current cell contains x or y
                if (a[i] != a[startMeasure]) { // if current cell doesn't contains same value (x/y) as "startMeasure" var
                    minDiff = Math.min(minDiff, i - startMeasure); // set minimal diff
                }
                startMeasure = i; // set start measure from to the current index
            }
        }

        // return minimal difference found
        return minDiff;
    }

    // endregion


    public static boolean search(int[][] mat, int num) {
        int xStart = 0, yStart = 0, yEnd = mat.length, xEnd = mat[0].length;

        while (true) {
            if (yEnd - 1 == yStart)
                return mat[yStart][xStart] == num;
            if (yEnd - yStart == 2)
                return mat[yStart][xStart] == num || mat[yStart][xStart + 1] == num ||
                        mat[yStart + 1][xStart] == num || mat[yStart + 1][xStart + 1] == num;


            int inQ = isInQ(mat, yStart, xStart, yEnd, xEnd, num);
            switch (inQ) {
                case -1:
                    return false;
                case 1:
                    yEnd = yEnd / 2 + yStart / 2;
                    xEnd = xEnd / 2 + xStart / 2;
                    break;
                case 2:
                    yEnd = yEnd / 2 + yStart / 2;
                    xStart = xStart / 2 + xEnd / 2;
                    break;
                case 3:
                    yStart = yStart / 2 + yEnd / 2;
                    xStart = xStart / 2 + xEnd / 2;
                    break;
                case 4:
                    yStart = yStart / 2 + yEnd / 2;
                    xEnd = xEnd / 2 + xStart / 2;
                    break;
            }

        }


    }

    /*
     * borders: [yStart, xStart, yEnd, xEnd]
     */
    private static int isInQ(int[][] mat, int yStart, int xStart, int yEnd, int xEnd, int num) {
        boolean inQ1 = (mat[yStart][xStart] <= num) && (mat[yStart + (yEnd - yStart) / 2 - 1][xStart] >= num);
        if (inQ1) {
            return 1;
        }

        boolean inQ2 = (mat[yStart][xStart + ((xEnd - xStart) / 2)] <= num) && (mat[yStart + (yEnd - yStart) / 2 - 1][xStart + ((xEnd - xStart) / 2)] >= num);
        if (inQ2) {
            return 2;
        }

        boolean inQ3 = (mat[yEnd / 2][xStart + ((xEnd - xStart) / 2)] <= num) && (mat[yEnd - 1][xStart + ((xEnd - xStart) / 2)] >= num);
        if (inQ3) {
            return 3;
        }

        boolean inQ4 = (mat[yEnd / 2][xStart] <= num) && (mat[yEnd - 1][xStart] >= num);
        if (inQ4) {
            return 4;
        }
        return -1;
    }

    // region task 4
    public static boolean equalSplit(int[] arr) {
        return true;
    }

    public static boolean isSpecial(int n) {
        return true;
    }
    // endregion


}
