//https://leetcode.com/problems/design-tic-tac-toe/
class TicTacToe {
    
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n=n;
        this.rows = new int[n];
        this.cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int playerModified = player % 2 == 0 ? 1 : -1;
        rows[row]+=playerModified;
        cols[col]+=playerModified;
        if(row==col){
            diagonal+=playerModified;
        }
        if(row+col==n-1){
            antiDiagonal+=playerModified;
        }
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
