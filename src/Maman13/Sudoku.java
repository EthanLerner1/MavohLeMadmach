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
    public boolean isValid() { // error not a good function fails with the input in the main
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

    public String toString(){
        String ret = "";
        for (int i=0 ; i<this._board.length ; i++){
            ret+="-------------------------------\n";
            for (int j=0 ; j<this._board[0].length ; j++){
                ret += this._board[i][j].toString();
            }
        }
        return ret;
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

    public static void main(String[] args) {
        Square3x3[] firstRow = new Square3x3[3];
        int[][] firstCell = {{1, 6, 8}, {7, 9, 2}, {5, 3, 4}};
        firstRow[0] = new Square3x3(firstCell);
        int[][] secondCell = {{9,2,3}, {6,5,4}, {8,1,7}};
        firstRow[1] = new Square3x3(secondCell);
        int[][] thirdCell = {{4,5,7}, {1,8,9}, {2,3,6}};
        firstRow[2] = new Square3x3(thirdCell);

        Square3x3[] secondRow = new Square3x3[3];
        int[][] SfirstCell = {{3,1,9}, {8,4,7}, {2,5,6}};
        secondRow[0] = new Square3x3(SfirstCell);
        int[][] SsecondCell = {{2,8,5}, {1,3,6}, {4,7,9}};
        secondRow[1] = new Square3x3(SsecondCell);
        int[][] SthirdCell = {{7,6,4}, {5,9,2}, {8,1,3}};
        secondRow[2] = new Square3x3(SthirdCell);

        Square3x3[] thirdRow = new Square3x3[3];
        int[][] TfirstCell = {{4,8,5}, {6,2,1}, {9,7,3}};
        thirdRow[0] = new Square3x3(TfirstCell);
        int[][] TsecondCell = {{3,6,2}, {7,9,8}, {5,4,1}};
        thirdRow[1] = new Square3x3(TsecondCell);
        int[][] TthirdCell = {{9,7,1}, {3,4,5}, {6,2,8}};
        thirdRow[2] = new Square3x3(TthirdCell);

        Square3x3[][] board = {firstRow, secondRow, thirdRow};
        Sudoku sud = new Sudoku(board);
        System.out.println(sud.toString());
        System.out.println(sud.isValid());
    }
}
