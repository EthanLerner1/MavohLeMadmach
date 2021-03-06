package Maman13;

/**
 * represents a square with 3x3 dimensions
 *
 * @author Ethan Lerner
 * @version 02/12/2021
 */
public class Square3x3 {

    // region properties
    private int[][] _square;

    private final int DEFAULT_VALUE = -1;
    private final int ARRAY_SIZE = 3;

    // endregion

    // region constructors

    /**
     * default constructor: init a 3x3 square with -1 in all of its cells
     */
    public Square3x3() {
        this._square = new int[this.ARRAY_SIZE][this.ARRAY_SIZE];
        // initialize the two-dimensional array
        for (int i = 0; i < this._square.length; i++) {
            for (int j = 0; j < this._square[0].length; j++) {
                this._square[i][j] = DEFAULT_VALUE;
            }
        }
    }

    /**
     * this constructor copy a given array avlues into this square property
     *
     * @param array values to fill this square with
     */
    public Square3x3(int[][] array) {
        this._square = new int[this.ARRAY_SIZE][this.ARRAY_SIZE]; // init square

        // copy values from given array
        for (int i = 0; i < this._square.length; i++) {
            for (int j = 0; j < this._square[0].length; j++) {
                if (array.length - 1 < i || array[i].length - 1 < j) {
                    this._square[i][j] = DEFAULT_VALUE; // if the given array is too small to fill this.square
                } else {
                    this._square[i][j] = array[i][j]; // copy values
                }
            }
        }
    }

    /**
     * copy constructor, gets one square3x3 and creates a new one with the same values
     *
     * @param other Square3x3 to copy values from
     */
    public Square3x3(Square3x3 other) {
        this._square = new int[this.ARRAY_SIZE][this.ARRAY_SIZE];
        // copy values from given array
        for (int i = 0; i < this.ARRAY_SIZE; i++) {
            for (int j = 0; j < this.ARRAY_SIZE; j++) {
                this._square[i][j] = other._square[i][j]; // copy values
            }
        }
    }

    // endregion

    // region methods

    /**
     * returns the value inside the cell located at (row,col)
     *
     * @param row for the retrieved cell
     * @param col for the retrieved cell
     * @return value inside the specified cell
     */
    public int getCell(int row, int col) {
        if (row >= this._square.length || col >= this._square[0].length) { // if user values are out of range
            return DEFAULT_VALUE;
        }
        return this._square[row][col];
    }

    /**
     * sets the cell (row, col) int the array to given value.
     * if the row/col are invalid inputs (not 0,1,2) nothing happens
     *
     * @param row   for the wanted cell
     * @param col   for the wanted cell
     * @param value new value for the wanted cell
     */
    public void setXY(int row, int col, int value) {
        if (row >= this._square.length || row < 0 || col >= this._square[0].length || col < 0) { // if user values are out of range
            return;
        }
        this._square[row][col] = value; // set wanted location (row,col) to the given value
    }

    /**
     * return a String representation of the array
     *
     * @return string representation of the array
     */
    public String toString() {
        String ret = ""; // init string
        for (int i = 0; i < this.ARRAY_SIZE; i++) { // go over all the cells in the square
            for (int j = 0; j < this.ARRAY_SIZE; j++) {
                if (j == 0) { // if first in row dont add \t
                    ret += this._square[i][j];
                } else {
                    ret += "\t" + this._square[i][j]; // else add \t
                }
            }
            ret += "\n"; // every new line add \n
        }
        return ret;
    }

    /**
     * this function checks if the current square includes all the numbers between 1-9
     *
     * @return true if all the numbers between 1-9 exist. else false.
     */
    public boolean allThere() {
        for (int i = 1; i <= 9; i++) { // go over all the numbers between 1-9
            if (!this.numberInSquare(i)) { // check if current number is inside the square
                return false;
            }
        }
        return true;
    }

    /**
     * this function checks if values between 1-9 exist in a given row,
     * if they exist it sets true in the corresponding place in values array
     *
     * @param row    row to check in
     * @param values values to sets flags in
     */
    public void whosThereRow(int row, boolean[] values) {
        // validate inputs
        if (values == null || values.length != 10) { // check if value is a valid boolean array
            return;
        }
        if (row > 2 || row < 0) { // checks if row is a valid input
            return;
        }

        // go over all 1-9 numbers. and check if their inside the row
        for (int i = 1; i <= 9; i++) {
            if (this.numberInRow(row, i))
                values[i] = true;
        }
    }

    /**
     * this function checks if values between 1-9 exist in a given column,
     * if they exist it sets true in the corresponding place in values array
     *
     * @param col    column to check in
     * @param values values to sets flags in
     */
    public void whosThereCol(int col, boolean[] values) {
        // validate inputs
        if (values == null || values.length != 10) { // check if value is a valid boolean array
            return;
        }
        if (col > 2 || col < 0) { // checks if row is a valid input
            return;
        }

        // check if 1-9 is in the given col
        for (int i = 1; i <= 9; i++) {
            if (this.numberInCol(col, i)) {
                values[i] = true;
            }
        }
    }
    // endregion

    // region helper methods

    // this function checks if a given number is inside the square
    private boolean numberInSquare(int num) {
        for (int i = 0; i < this._square.length; i++) { // go over entire square
            for (int j = 0; j < this._square[i].length; j++) {
                if (this._square[i][j] == num) // if number exists return true;
                    return true;
            }
        }
        return false;
    }

    // checks if a given number exists in a given row
    private boolean numberInRow(int row, int num) {
        for (int i = 0; i < this._square[row].length; i++) { // go over a given row
            if (this._square[row][i] == num) // if number exist return true
                return true;
        }
        return false;
    }

    // checks if a given number exists in a given col
    private boolean numberInCol(int col, int num) {
        for (int i = 0; i < this._square.length; i++) { // go over a given column
            if (this._square[i][col] == num) { // if number exist return true
                return true;
            }
        }
        return false;
    }


    // endregion

}