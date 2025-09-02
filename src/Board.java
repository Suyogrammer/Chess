public class Board {
    
    private String[][] board;

    public Board(){
        board = new String[8][8];
        initializeBoard();
    }

    //Initialize board with 8*8 2d arraygrid
    public void initializeBoard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = ".";
            }
        }
    }

    //Prints the board 
    public void printBoard(){
        for (int i = 0; i < 8; i++) {
            System.out.print(8-i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
