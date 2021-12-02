package Maman13;

public class Sudoku {
    private Square3x3[][] _board;

    public Sudoku() {
        this._board = new Square3x3[3][3];
        for (int i = 0; i< this._board.length ; i ++) {
            for (int j = 0; j< this._board[i].length ; j++) {
                this._board[i][j] = new Square3x3();
            }
        }
    }

    public Sudoku(Square3x3[][] square3x3Array) {
        // init new board
        this._board = new Square3x3[3][3];
        // copy values from given array
        for (int i = 0; i < this._board.length; i++) {
            for (int j = 0; j < this._board[i].length; j++) {
                this._board[i][j] = new Square3x3(square3x3Array[i][j]);
            }
        }
    }

    public Boolean isValid() {
        // check that each cube in the board contains 1-9
        for (int i = 0; i < this._board.length; i++) {
            for (int j = 0; j < this._board[i].length; j++) {
                if (!this._board[i][j].allThere()) {
                    return false;
                }
            }
        }

        // check that all the rows contains 1-9
        for (int i = 0; i < this._board.length; i++) {
            boolean[] checkNumbers = new boolean[10];
            for (int j = 0; j < this._board[i].length; j++) { // check whosThereRow for all cells in the board
                boolean[] checkNumbersTemp = new boolean[10];
                this._board[i][j].whosThereRow(i, checkNumbersTemp);// get current whosThere

                // check if number exist more than once
                int identicalNumbers = this.checkIfTwoCellsIsTrue(checkNumbers, checkNumbersTemp);
                if (identicalNumbers != 0) {
                    System.out.println("error in " + i + " row, number: " + identicalNumbers + " exist more then once");
                    return false;
                }

                // merge checkNumbersArray
                this._board[i][j].whosThereRow(i, checkNumbers);
            }

            // check that checkNums Filled with "true"
            for (int j = 1; j < checkNumbers.length; j++) {
                if (!checkNumbers[j]) {
                    System.out.println("error in " + i + " row, not all numbers exist");
                    return false;
                }
            }
        }

        // check that all the columns contains 1-9
        for (int i = 0; i < this._board.length; i++) {
            boolean[] checkNumbers = new boolean[10];
            for (int j = 0; j < this._board[i].length; j++) { // check whosThereCol for all cells in the board
                boolean[] checkNumbersTemp = new boolean[10];
                this._board[j][i].whosThereCol(i, checkNumbersTemp);// get current whosThere

                // check if number exist more then once
                int identicalNumbers = this.checkIfTwoCellsIsTrue(checkNumbers, checkNumbersTemp);
                if (identicalNumbers != 0) {
                    System.out.println("error in " + i + " col, number: " + identicalNumbers + " exist more then once");
                    return false;
                }

                // merge checkNumbersArray
                this._board[j][i].whosThereCol(i, checkNumbers);
            }

            // check that checkNums Filled with "true"
            for (int j = 1; j < checkNumbers.length; j++) {
                if (!checkNumbers[j]) {
                    System.out.println("error in " + i + " col, not all numbers exist");
                    return false;
                }
            }
        }
        return true;
    }

    /* this function compares between two boolean arrays and returns the number of the cell that contains true in both arrays
     * if non exist, returns 0
     */
    private int checkIfTwoCellsIsTrue(boolean[] arr1, boolean[] arr2) {
        // make sure that both arrays are the same size
        if (arr1.length != arr2.length)
            return 0;

        // go over arrays
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] && arr2[i])
                return i;

        }

        // passed tests
        return 0;
    }

}
