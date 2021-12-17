package Maman14;

public class Ex14 {
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
}
