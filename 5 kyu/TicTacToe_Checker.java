public class TicTacToe_Checker {
    /**
     * If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved, wouldn't we? Our goal is to create a function that will check that for us!
     *
     * Assume that the board comes in the form of a 3x3 array, where the value is 0 if a spot is empty, 1 if it is an "X", or 2 if it is an "O", like so:
     *
     * [[0, 0, 1],
     *  [0, 1, 2],
     *  [2, 1, 0]]
     * We want our function to return:
     *
     * -1 if the board is not yet finished AND no one has won yet (there are empty spots),
     * 1 if "X" won,
     * 2 if "O" won,
     * 0 if it's a cat's game (i.e. a draw).
     * You may assume that the board passed in is valid in the context of a game of Tic-Tac-Toe.
     */

    public static int isSolved(int[][] board) {
        int width = board.length;
        int winner = -1;
        boolean hasEmpty = false;
        // row / column same.
        for (int i = 0; i < width; i += 1) {
            if (equal(board[i][0], board[i][1], board[i][2])) {
                winner = board[i][0];
            }
            if (equal(board[0][i], board[1][i], board[2][i])) {
                winner = board[0][i];
            }
            for (int k = 0; k < width; k += 1) {
                if (board[i][k] == 0) {
                    hasEmpty = true;
                }
            }
        }

        // diagonal same.
        if (equal(board[0][0], board[1][1], board[2][2])) {
            winner = board[0][0];
        }
        if (equal(board[2][0], board[1][1], board[0][2])) {
            winner = board[2][0];
        }

        if (winner < 0 && !hasEmpty) {
            winner = 0;
        }
        return winner;
    }

    private static boolean equal(int a, int b, int c) {
        if (a == b && a == c && a != 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        int[][] board = new int[][] {
                {1, 2, 1},
                {0, 0, 2},
                {0, 2, 1}
        };

        System.out.println(isSolved(board));
    }
}
