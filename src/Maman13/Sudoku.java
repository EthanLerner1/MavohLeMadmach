package Maman13;


/**
 * represents a Sudoku board
 *
 * @author Ethan Lerner
 * @version 05/12/2021
 */
public class Sudoku {
    private Square3x3[][] _board;

    private final int BOARD_SIZE = 3;

    /**
     * default constructor for sudoku board.
     * inits all cells to new empty Square3x3
     */
    public Sudoku() {
        this._board = new Square3x3[this.BOARD_SIZE][this.BOARD_SIZE]; // init new board of square3x3
        // in each cell create a new square3x3 filled with -1
        for (int i = 0; i < this._board.length; i++) {
            for (int j = 0; j < this._board[i].length; j++) {
                this._board[i][j] = new Square3x3();
            }
        }
    }

    /**
     * constructor, takes the values from the given squqre3x3Array and copies it into this._board
     *
     * @param square3x3Array 3x3 to copy values from
     */
    public Sudoku(Square3x3[][] square3x3Array) {
        // under the circumstance that square3x3Array is a valid array
        // init new board
        this._board = new Square3x3[this.BOARD_SIZE][this.BOARD_SIZE];
        // copy values from given array
        for (int i = 0; i < this._board.length; i++) {
            for (int j = 0; j < this._board[i].length; j++) {
                this._board[i][j] = new Square3x3(square3x3Array[i][j]);
            }
        }
    }

    /**
     * this function checks if the current sudoku board is valid
     *
     * @return true if the board is valid, else, false
     */
    public boolean isValid() {
        // finals
        final int VALUES_ARRAY_SIZE = 10;

        // go over entire square and check that each square/row/col is valid
        for (int i = 0; i < this._board.length; i++) {
            boolean[] rowValues = new boolean[VALUES_ARRAY_SIZE];
            boolean[] colValues = new boolean[VALUES_ARRAY_SIZE];
            for (int j = 0; j < this._board[i].length; j++) {
                // check that cube contains all numbers between 1-9
                if (!this._board[i][j].allThere()) {
                    return false; // not all values exist in current cube
                }

                // whos there row and col
                this._board[i][j].whosThereRow(i, rowValues);
                this._board[j][i].whosThereCol(i, colValues);

            }
            // check that row and col includes all numbers between 1-9
            if (!this.containsAllNumbers(rowValues) || !this.containsAllNumbers(colValues)) {
                return false; // not all numbers exist in current col/row
            }
        }
        // passed all tests
        return true;
    }

    /*
     * this function checks that a boolean array contains true in each of his cells except from index =0
     */
    private boolean containsAllNumbers(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) { // go over entire array
            if (!arr[i]) { // if not true return false
                return false;
            }
        }
        // contains only true
        return true;
    }


}
