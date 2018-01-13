package decision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author Mayank Gupta
 * @Date 12/6/17
 */
public class NQueens {

    private static final char QUEEN = 'Q';
    private static final char NULL = '\u0000';
    private char[][] board;
    private char[][] queenBoard;

    private Stack<Position> stack = new Stack<>();

    private ArrayList<ArrayList<String>> result = new ArrayList<>();

    public static void main(String[] args) {

        NQueens nQueens = new NQueens();

        nQueens.solveNQueens(8);

    }

    private ArrayList<ArrayList<String>> solveNQueens(int a) {

        board = new char[a][a];
        queenBoard = new char[a][a];

        for (int i = 0; i < queenBoard.length; i++) {
            Arrays.fill(queenBoard[i], '.');
        }

        solve(a, 0, 0);

        return result;

    }

    private void solve(int numOfQueens, int start,
                       int queenNo) {

        if (numOfQueens == 0) {
            ArrayList<String> output = new ArrayList<>();
            for (char[] aQueenBoard : queenBoard) {

                StringBuilder stringBuilder = new StringBuilder();

                for (char anAQueenBoard : aQueenBoard) {

                    if( anAQueenBoard != '.' ) stringBuilder.append(QUEEN);
                    else stringBuilder.append(anAQueenBoard);
                }

                output.add(stringBuilder.toString());

            }

            result.add(output);
            unplaceQueen();
            return;
        }

        for (int i = start; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (isSafe(i, j)) {
                    placeQueen(i, j, queenNo);
                    solve(numOfQueens - 1, i + 1, queenNo + 1);
                }
            }
        }

        if (numOfQueens > 0 && stack.size() > 0) {
            unplaceQueen();
        }


    }

    private void placeQueen(int i, int j, int queenNo) {

        char queen = (char) (QUEEN + (char) queenNo);
        board[i][j] = queen;
        queenBoard[i][j] = queen;
        stack.push(new Position(i, j));
        markPlaces(i, j, NULL, queen);
    }

    private void unplaceQueen() {

        Position pos = stack.pop();
        int i = pos.getX();
        int j = pos.getY();
        char queen = board[i][j];
        board[i][j] = NULL;
        queenBoard[i][j] = '.';

        markPlaces(i, j, queen, NULL);

    }

    private void markPlaces(int i, int j, char existingBoardValue, char boardValue) {

        int k = 0;
        int l = 0;

        int sum = i + j;
        int diff = i - j;

        for (k = 0; k < board.length; k++) {

            for (l = 0; l < board[k].length; l++) {

                if (((k + l == sum) || k - l == diff) && board[k][l] == existingBoardValue) {
                    board[k][l] = boardValue;
                }
            }
        }

        for (k = 0; k < board.length; k++) {

            if (board[k][j] == existingBoardValue) board[k][j] = boardValue;
        }

        for (l = 0; l < board[i].length; l++) {
            if (board[i][l] == existingBoardValue) board[i][l] = boardValue;
        }

    }

    private boolean isSafe(int i, int j) {

        return board[i][j] == '\u0000';

    }

    class Position {

        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

    }


}
