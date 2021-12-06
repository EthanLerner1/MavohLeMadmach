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
        this._board = new Square3x3[this.BOARD_SIZE][this.BOARD_SIZE];
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
        for (int i = 0; i < this._board.length; i++) {
            boolean[] rowValues = new boolean[10];
            boolean[] colValues = new boolean[10];
            for (int j = 0; j < this._board[i].length; j++) {
                // check that cube contains all numbers between 1-9
                if (!this._board[i][j].allThere()) {
                    return false;
                }

                // whos there row and col
                this._board[i][j].whosThereRow(i, rowValues);
                this._board[j][i].whosThereCol(i, colValues);


            }
            // check that row and col includes all numbers between 1-9
            if (!this.containsAllNumbers(rowValues) || !this.containsAllNumbers(colValues)) {
                return false;
            }
        }
        return true;
    }


    private boolean containsAllNumbers(boolean[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i]) {
                return false;
            }
        }
        return true;
    }


}
