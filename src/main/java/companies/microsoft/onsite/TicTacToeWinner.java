package companies.microsoft.onsite;

public class TicTacToeWinner {

    public String tictactoe(int[][] moves) {

        int[] aRow = new int[3];
        int[] bRow = new int[3];

        int[] aCol = new int[3];
        int[] bCol = new int[3];

        int aD1 = 0;
        int bD1 = 0;

        int aD2 = 0;
        int bD2 = 0;

        for(int i = 0 ; i < moves.length;i++ ) {

            int row = moves[i][0];
            int column = moves[i][1];

            if(i % 2 == 0 ) {

                if(++aRow[row] == 3 || ++aCol[column] == 3 || row == column && ++aD1 == 3 || row + column == 2 && ++aD2 == 3 ) {
                    return "A";
                }
            } else {

                if(++bRow[row] == 3 || ++bCol[column] == 3 || row == column && ++bD1 == 3 || row + column == 2 && ++bD2 == 3 ) {
                    return "B";
                }
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
