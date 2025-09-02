public class Board {
    
    private Piece[][] board;

    public Board(){
        board = new Piece[8][8];
        initializePieces();
    }

    //Initialize board with the pieces
    public void initializePieces(){
        // Black major pieces (row 0)
        board[0][0] = new Piece(Color.BLACK, PieceType.ROOK);
        board[0][1] = new Piece(Color.BLACK, PieceType.NIGHT);
        board[0][2] = new Piece(Color.BLACK, PieceType.BISHOP);
        board[0][3] = new Piece(Color.BLACK, PieceType.QUEEN);
        board[0][4] = new Piece(Color.BLACK, PieceType.KING);
        board[0][5] = new Piece(Color.BLACK, PieceType.BISHOP);
        board[0][6] = new Piece(Color.BLACK, PieceType.NIGHT);
        board[0][7] = new Piece(Color.BLACK, PieceType.ROOK);

        //Black PAWNS
        for(int i=0; i<8; i++){
            board[1][i] = new Piece(Color.BLACK, PieceType.PAWN);
        }

        for(int i=2; i<6; i++){
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }

        //White PAWNS
        for(int i=0; i<8; i++){
            board[6][i] = new Piece(Color.WHITE, PieceType.PAWN);
        }

        // White major pieces (row 7)
        board[7][0] = new Piece(Color.WHITE, PieceType.ROOK);
        board[7][1] = new Piece(Color.WHITE, PieceType.NIGHT);
        board[7][2] = new Piece(Color.WHITE, PieceType.BISHOP);
        board[7][3] = new Piece(Color.WHITE, PieceType.QUEEN);
        board[7][4] = new Piece(Color.WHITE, PieceType.KING);
        board[7][5] = new Piece(Color.WHITE, PieceType.BISHOP);
        board[7][6] = new Piece(Color.WHITE, PieceType.NIGHT);
        board[7][7] = new Piece(Color.WHITE, PieceType.ROOK);
    }

    //Prints the board 
    public void printBoard(){
        for (int i = 0; i < 8; i++) {
            // Piece
            System.out.print(8-i + "   ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null){
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("    a b c d e f g h");
    }
}
