package Sudoku;

public class Main {
    public static void main(String[] args) {
        SudokuBoard game = new SudokuBoard();
        int len = game.board.length;
        System.out.println(game);
        int x = 0;
        int y = 0;

        while (x < len || y < len) {
            int[] xy = findNextMutableCell(game, x, y);
            x = xy[0];
            y = xy[1];

            if (!incrementCell(game, x, y)) {
                xy = findLastMutableCell(game, x, y);
                x = xy[0];
                y = xy[1];
                continue;
            } else {
                if ((x == len-1 && y == len-1)) {
                break;
            }
                if (y < game.board.length - 1) {
                    y++;
                } else {
                    y = 0;
                    x++;
                }
            }
            
        }
    }

    private static int[] findNextMutableCell(SudokuBoard game, int x, int y) {
        while (!game.board[x][y].isMutable()) {
            if (y < game.board.length - 1) {
                y++;
            } else {
                y = 0;
                x++;
            }
        }
        return new int[] { x, y };

    }

    private static int[] findLastMutableCell(SudokuBoard game, int x, int y) {
        do {
            if (y > 0) {
                y--;
            } else {
                y = game.board.length;
                x--;
            }
        } while (!game.board[x][y].isMutable());
        return new int[] { x, y };
    }

    private static boolean incrementCell(SudokuBoard game, int x, int y) {
        int num = game.board[x][y].getVal() + 1;
        while (!game.checkValidMove(num, x, y)) {
            num++;
            if (num > game.board.length) {
                return false;
            }
        }
        game.board[x][y].setVal(num);
        System.out.println(game);

        return true;
    }
}