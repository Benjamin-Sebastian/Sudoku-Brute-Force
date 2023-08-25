package Sudoku;

import java.util.ArrayList;
import java.util.Stack;

public class SudokuBoard {
    public Cell[][] board;

    public SudokuBoard() {
        this.board = new Cell[][] {
                { new Cell(), new Cell(), new Cell(3, false) },
                { new Cell(2, false), new Cell(), new Cell() },
                { new Cell(), new Cell(), new Cell() },

        };
        // for (int i = 0; i < board.length; i++) {
        // for (int j = 0; j < board[i].length; j++) {
        // board[i][j] = 0;
        // }
        // }
    }

    public boolean checkValidMove(int num, int x, int y) {
        if (!board[x][y].isMutable()) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(x);
        ArrayList<Integer> visitedRows = new ArrayList<Integer>(1);
        while (!stack.isEmpty()) {
            int row = stack.pop();
            if (visitedRows.contains(row)) {
                continue;
            }
            int col = y;
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                continue;
            }
            if (board[row][col].getVal() == num) {
                return false;
            }
            visitedRows.add(row);
            stack.push(row + 1);
            stack.push(row - 1);

        }
        stack.push(y + 1);
        stack.push(y - 1);
        ArrayList<Integer> visitedCols = new ArrayList<Integer>(1);

        while (!stack.isEmpty()) {
            int col = stack.pop();
            if (visitedCols.contains(col)) {
                continue;
            }
            int row = x;
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
                continue;
            }
            if (board[row][col].getVal() == num) {
                return false;
            }
            visitedCols.add(col);
            stack.push(col + 1);
            stack.push(col - 1);

        }

        return true;

    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < board.length; i++) {
            out += "|";
            for (int j = 0; j < board[i].length; j++) {
                out += board[i][j].getVal();
                out += "|";
            }
            out += "\n";

        }
        return out;
    }

}
