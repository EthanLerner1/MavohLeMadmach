package Maman13; /**  kilroy
 *               _____   here
 *         was  /     \    
 *     ____    /(.) (.)\    ____
 * ---/    \------| |------/    \---
 *    |/\/\/      | |      |/\/\/
 *                \_/  
 *   created by B.A.
 */
import Maman13.Square3x3;
import Maman13.Sudoku;

import java.util.Scanner;
public class SudokuTesterNew
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Sudoku board = new Sudoku();
        
        System.out.print("Test #1 - First constructur & isValid:.....................");
        if (!board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: false");
        
        //valid Board #1
        int [][] sqr0 = new int[][] {{1,6,8},{7,3,2},{5,9,4}};
        int [][] sqr1 = new int[][] {{9,2,3},{6,5,4},{8,1,7}};
        int [][] sqr2 = new int[][] {{4,5,7},{1,8,9},{2,3,6}};
        int [][] sqr3 = new int[][] {{3,1,9},{8,4,7},{2,5,6}};
        int [][] sqr4 = new int[][] {{2,8,5},{1,3,6},{4,7,9}};
        int [][] sqr5 = new int[][] {{7,6,4},{5,9,2},{8,1,3}};
        int [][] sqr6 = new int[][] {{4,8,5},{6,2,1},{9,7,3}};
        int [][] sqr7 = new int[][] {{3,6,2},{7,9,8},{5,4,1}};
        int [][] sqr8 = new int[][] {{9,7,1},{3,4,5},{6,2,8}};
        
        Square3x3[][] sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);

        board = new Sudoku(sqrBoard);
        
        System.out.print("Test #2 - Board #1: Secound constructur & Valid Board:.....");
        if (board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: true");
        
        //Invalid Board #2
        sqr0 = new int[][] {{1,9,8},{7,3,2},{5,6,4}};
        sqr1 = new int[][] {{9,2,3},{6,5,4},{8,1,7}};
        sqr2 = new int[][] {{4,5,7},{1,8,9},{2,3,6}};
        sqr3 = new int[][] {{3,1,9},{8,4,7},{2,5,6}};
        sqr4 = new int[][] {{2,8,5},{1,3,6},{4,7,9}};
        sqr5 = new int[][] {{7,6,4},{5,9,2},{8,1,3}};
        sqr6 = new int[][] {{4,8,5},{6,2,1},{9,7,3}};
        sqr7 = new int[][] {{3,6,2},{7,9,8},{5,4,1}};
        sqr8 = new int[][] {{9,7,1},{3,4,5},{6,2,8}};

        sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);
        board = new Sudoku(sqrBoard);
        
        System.out.print("Test #3 - Board #2: InValid Board:.........................");
        if (!board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: false");
        

        //valid Board #3
        sqr0 = new int[][] {{5,3,4},{6,7,2},{1,9,8}};
        sqr1 = new int[][] {{6,7,8},{1,9,5},{3,4,2}};
        sqr2 = new int[][] {{9,1,2},{3,4,8},{5,6,7}};
        sqr3 = new int[][] {{8,5,9},{4,2,6},{7,1,3}};
        sqr4 = new int[][] {{7,6,1},{8,5,3},{9,2,4}};
        sqr5 = new int[][] {{4,2,3},{7,9,1},{8,5,6}};
        sqr6 = new int[][] {{9,6,1},{2,8,7},{3,4,5}};
        sqr7 = new int[][] {{5,3,7},{4,1,9},{2,8,6}};
        sqr8 = new int[][] {{2,8,4},{6,3,5},{1,7,9}};

        sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);
        board = new Sudoku(sqrBoard);
        
        System.out.print("Test #4 - Board #3: Valid Board:...........................");
        if (board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: true");
        

        //invalid Board #4
        sqr0 = new int[][] {{3,5,4},{6,7,8},{1,9,2}};
        sqr1 = new int[][] {{6,7,8},{9,1,5},{3,4,2}};
        sqr2 = new int[][] {{9,1,2},{3,4,8},{5,7,6}};
        sqr3 = new int[][] {{8,5,6},{4,2,9},{7,1,3}};
        sqr4 = new int[][] {{7,6,1},{8,5,3},{9,2,4}};
        sqr5 = new int[][] {{4,2,3},{7,9,1},{8,5,6}};
        sqr6 = new int[][] {{9,6,5},{2,8,7},{3,4,1}};
        sqr7 = new int[][] {{5,3,7},{4,1,9},{2,8,6}};
        sqr8 = new int[][] {{2,8,4},{6,3,5},{1,7,9}};

        sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);
        board = new Sudoku(sqrBoard);
        
        System.out.print("Test #5 - Board #4: invalid rows:..........................");
        if (!board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: false");
            
        

        //invalid Board #5
        sqr0 = new int[][] {{3,5,4},{6,7,8},{1,9,2}};
        sqr1 = new int[][] {{6,7,8},{9,1,2},{3,4,5}};
        sqr2 = new int[][] {{9,1,2},{3,4,8},{5,7,6}};
        sqr3 = new int[][] {{8,5,6},{4,2,9},{7,1,3}};
        sqr4 = new int[][] {{8,6,1},{7,5,3},{9,2,4}};
        sqr5 = new int[][] {{4,2,3},{7,9,1},{8,5,6}};
        sqr6 = new int[][] {{9,6,5},{2,8,7},{3,4,1}};
        sqr7 = new int[][] {{5,3,7},{4,1,9},{2,8,6}};
        sqr8 = new int[][] {{2,8,4},{6,3,9},{1,7,5}};

        sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);
        board = new Sudoku(sqrBoard);
        
        System.out.print("Test #6 - Board #5: invalid columns:.......................");
        if (!board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: false");
        

        //invalid Board #6
        sqr0 = new int[][] {{5,3,4},{6,7,1},{2,9,8}};
        sqr1 = new int[][] {{6,7,8},{1,9,5},{3,4,2}};
        sqr2 = new int[][] {{9,1,2},{3,4,8},{5,6,7}};
        sqr3 = new int[][] {{8,5,9},{4,2,6},{7,1,3}};
        sqr4 = new int[][] {{5,6,1},{8,7,3},{9,2,4}};
        sqr5 = new int[][] {{4,2,3},{7,9,1},{8,5,6}};
        sqr6 = new int[][] {{9,6,1},{2,8,7},{3,4,5}};
        sqr7 = new int[][] {{5,3,7},{4,1,9},{2,8,6}};
        sqr8 = new int[][] {{2,6,4},{8,3,5},{1,7,9}};

        sqrBoard = new Square3x3[3][3];
        sqrBoard[0][0] = new Square3x3(sqr0);
        sqrBoard[0][1] = new Square3x3(sqr1);
        sqrBoard[0][2] = new Square3x3(sqr2);
        sqrBoard[1][0] = new Square3x3(sqr3);
        sqrBoard[1][1] = new Square3x3(sqr4);
        sqrBoard[1][2] = new Square3x3(sqr5);
        sqrBoard[2][0] = new Square3x3(sqr6);
        sqrBoard[2][1] = new Square3x3(sqr7);
        sqrBoard[2][2] = new Square3x3(sqr8);
        board = new Sudoku(sqrBoard);
        System.out.print("Test #7 - Board #6: invalid rows and columns:..............");
        if (!board.isValid())
            System.out.println("OK");
        else
            System.out.println("Error - your board: " + board.isValid() + "Expect: false");
    }
}
