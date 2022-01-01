package Maman14;

public class Ex14 {
    // region first task

    /**
     * this function calculates minimal distance between two numbers in given array.
     * this function has the time complexity of O(n), n = number of values in the given array.
     * explanation: because the function go over the array only once.
     * this function has the place complexity of O(1). because it only creates 3 integers
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

    // region second task

    /**
     * this function gets a complexity ordered matrix and checks if a given number is in the matrix
     * complexity: time: O(log(n)) -> using binary search,
     * place: O(log(n)) -> calling O(1) function (isInQ) log(n) times
     *
     * @param mat complexity ordered matrix
     * @param num num to find in the matrix
     * @return true if the number is in the matrix. else, false
     */
    public static boolean search(int[][] mat, int num) {
        // setting matrix borders
        int xStart = 0, yStart = 0, yEnd = mat.length, xEnd = mat[0].length;

        // keep narrowing borders (xStart, xEnd...) until you found the square which the number is in.
        // and then, enter one of the stopping conditions
        // this loop happens log(n) times. this is why both time and space complexity of this loop is O(log(n))
        while (true) {
            // stopping conditions
            if (yEnd - 1 == yStart)// if matrix have only one cell
                return mat[yStart][xStart] == num;
            if (yEnd - yStart == 2) // two by two matrix
                return mat[yStart][xStart] == num || mat[yStart][xStart + 1] == num ||
                        mat[yStart + 1][xStart] == num || mat[yStart + 1][xStart + 1] == num;

            // checking in which quarter num is
            int inQ = isInQ(mat, yStart, xStart, yEnd, xEnd, num);

            // move borders according to quarter the number is in
            switch (inQ) {
                case -1:
                    // num not found in any quarter
                    return false;
                case 1:
                    // num found in first quarter
                    yEnd = yEnd / 2 + yStart / 2;
                    xEnd = xEnd / 2 + xStart / 2;
                    break;
                case 2:
                    // num found in second quarter
                    yEnd = yEnd / 2 + yStart / 2;
                    xStart = xStart / 2 + xEnd / 2;
                    break;
                case 3:
                    // num found in third quarter
                    yStart = yStart / 2 + yEnd / 2;
                    xStart = xStart / 2 + xEnd / 2;
                    break;
                case 4:
                    // num found in fourth quarter
                    yStart = yStart / 2 + yEnd / 2;
                    xEnd = xEnd / 2 + xStart / 2;
                    break;
            }

        }


    }

    /*
     * this function checks in which quarter of the matrix the number is in.
     * inside the given borders
     * time complexity - O(1)
     * space complexity - O(1)
     * borders: [yStart, xStart, yEnd, xEnd]
     */
    private static int isInQ(int[][] mat, int yStart, int xStart, int yEnd, int xEnd, int num) {
        // setting relative square sizes
        int squareHeight = yStart + (yEnd - yStart) / 2;
        int squareWidth = xStart + (xEnd - xStart) / 2;

        // checking q1
        boolean inQ1 = (mat[yStart][xStart] <= num) && (mat[squareHeight - 1][xStart] >= num);
        if (inQ1) {
            return 1;
        }

        // checking q2
        boolean inQ2 = (mat[yStart][squareWidth] <= num) && (mat[squareHeight - 1][squareWidth] >= num);
        if (inQ2) {
            return 2;
        }

        // checking q3
        boolean inQ3 = (mat[yEnd / 2][squareWidth] <= num) && (mat[yEnd - 1][squareWidth] >= num);
        if (inQ3) {
            return 3;
        }

        // checking q4
        boolean inQ4 = (mat[yEnd / 2][xStart] <= num) && (mat[yEnd - 1][xStart] >= num);
        if (inQ4) {
            return 4;
        }

        // not found
        return -1;
    }

    // endregion

    // region third task

    /**
     * this function gets an int array and checks if it can be split into two equal
     *
     * @param arr int arr to check
     * @return true if the array can be divided into two equal summed parts else, false
     */
    public static boolean equalSplit(int[] arr) {
        final int DEFAULT_VALUE = 0;
        return equalSplitR(arr, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    /*
     * recursive function to to the check for equalSplit.
     * this function tries to devide the arr into two equal parts by summing every time different cell in the arr.
     * arr: given array
     * index: index in the arr to check next
     * sum1: first sum option
     * sum2: second sum option
     * sumCount1: how many cells are summed in sum1
     * sumCount2: how many cells are summed in sum2
     */
    public static boolean equalSplitR(int[] arr, int index, int sum1, int sum2, int sumCount1, int sumCount2) {
        // stop condition: check if the end of the arr is reached
        if (arr.length == index)
            return sum1 == sum2 && sumCount1 == sumCount2;

        // adding current cell to sum1
        boolean addToSum1 = equalSplitR(arr, index + 1, sum1 + arr[index], sum2, sumCount1 + 1, sumCount2);
        // adding current cell to sum2
        boolean addToSum2 = equalSplitR(arr, index + 1, sum1, sum2 + arr[index], sumCount1, sumCount2 + 1);
        return addToSum1 || addToSum2;
    }

    // endregion

    // region fourth task

    /**
     * this function checks if the number is special according to the rules defined in this question
     *
     * @param n check if this number is special
     * @return true, if the number is special. else, false.
     */
    public static boolean isSpecial(int n) {
        final int startDivide = 2;
        // check that n is a full positive natural number
        if (n > 0)
            return isSpecialR(n, startDivide);
        return false;
    }
    /*
     * recursive function to check if the number is special
     * numIndex: index of the relevant number. as the function runs, this index change according to the current divider.
     * divideBy: current stage divide by.
     */
    private static boolean isSpecialR(int numIndex, int divideBy) {
        // if the number index is lower than the current divider, this number is surely a won't fall
        if (numIndex < divideBy)
            return true;
        // if the number index divides by the divider, then the number will fall
        else if (numIndex % divideBy == 0)
            return false;
        // recursive call
        return isSpecialR(numIndex - (numIndex / divideBy), divideBy + 1);
    }
    // endregion


}
