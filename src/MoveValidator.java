public class MoveValidator {
    
    public static boolean isValidMove(Board board, int fromRow, int fromCol, int toRow, int toCol){
        Piece piece = board.getPieceAt(fromRow, fromCol);
        if (piece == null) return false; //No Piece
        if (fromRow==toRow && fromCol==toCol) return false; //Same square

        switch (piece.getPieceType()) {
            case PAWN:
                return validatePawnMove(board, fromRow, fromCol, toRow, toCol, piece.getColor());
            case ROOK:
                return validateRookMove(board, fromRow, fromCol, toRow, toCol);
            case NIGHT:
                return validateNightMove(board, fromRow, fromCol, toRow, toCol, piece.getColor());
            case BISHOP:
                return validateBishopMove(board, fromRow, fromCol, toRow, toCol);
            case KING:
                return validateKingMove(board, fromRow, fromCol, toRow, toCol, piece.getColor());
            case QUEEN:
                return validateQueenMove(board, fromRow, fromCol, toRow, toCol);
            default:
                return false;
        }
    }

    // -------PAWN-------
    public static boolean validatePawnMove(Board board, int fromRow, int fromCol, int toRow, int toCol, Color color){
        int direction = (color == Color.WHITE) ? -1 : 1;
        Piece piece = board.getPieceAt(toRow, toCol);

        //Move 1 forward
        if(toCol==fromCol && toRow==fromRow + direction && piece == null) return true;

        //Move 2 forward only from its initial column (row 1 and row 6)
        if (toCol==fromCol && toRow==fromRow+2*direction && piece==null 
            && ((color == Color.WHITE && fromRow==6) || (color==Color.BLACK && fromRow==1)))
            return true;

        //Move diagonally
        if (Math.abs(toCol-fromCol) == 1 && toRow==fromRow+direction && piece!=null && piece.getColor()!=color) return true;

        return false;
    }

    // -------ROOK--------
    public static boolean validateRookMove(Board board, int fromRow, int fromCol, int toRow, int toCol){
        Piece pieceAt = board.getPieceAt(fromRow, fromCol);
        Piece targetPiece = board.getPieceAt(toRow, toCol);

        if (targetPiece != null && pieceAt.getColor() == targetPiece.getColor()) return false;

        // Vertical Move
        if(toCol == fromCol){
            int step = (toRow > fromRow) ? 1 : -1;
            for(int i=fromRow+step; i!=toRow; i+=step){
                //Check for obstacles
                if(board.getPieceAt(i, fromCol) != null) return false;
            }
            return true;
        }
        
        // Horizontal
        if(toRow == fromRow){
            int step = (toCol > fromCol) ? 1 : -1;
            for(int i=fromCol+step; i!=toCol; i+=step){
                //Check for obstacles
                if(board.getPieceAt(i, fromRow) != null) return false;
            }
            return true;
        }
        return false;
    }

    // -------KNIGHT--------
    public static boolean validateNightMove(Board board, int fromRow, int fromCol, int toRow, int toCol, Color color){
        Piece piece = board.getPieceAt(toRow, toCol);
        if(piece != null && piece.getColor()==color) return false;

        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        return ((rowDiff==2 && colDiff==1) || (rowDiff==1 && colDiff==2));
    }

    // -------BISHOP--------
    public static boolean validateBishopMove(Board board, int fromRow, int fromCol, int toRow, int toCol){
        Piece pieceAt = board.getPieceAt(fromRow, fromCol);
        Piece targetPiece = board.getPieceAt(toRow, toCol);

        if(targetPiece!=null && pieceAt.getColor()==targetPiece.getColor()) return false;

        //Diagonal Moves
        int rowDiff = Math.abs(toRow - fromRow);
        int colDiff = Math.abs(toCol - fromCol);

        if(rowDiff != colDiff) return false;

        int rowStep = (rowDiff>0) ? 1 : -1;
        int colStep = (colDiff>0) ? 1 : -1;

        int r = fromRow+rowStep;
        int c = fromCol+colStep;

        while(r != toRow && c != toCol){
            if(board.getPieceAt(r, c) != null) return false;
            r+=rowStep;
            c+=colStep;
        }

        return true;
    }

    // -------KING--------
    public static boolean validateKingMove(Board board, int fromRow, int fromCol, int toRow, int toCol, Color color){
        Piece piece = board.getPieceAt(toRow, toCol);

        if(piece!=null && piece.getColor()==color) return false;
        int rowDiff = Math.abs(toRow-fromRow);
        int colDiff = Math.abs(toCol-fromCol);

        //Move 1 sqaure in any direction
        return rowDiff<=1 && colDiff<=1; 
    }

    // -------QUEEN--------
    public static boolean validateQueenMove(Board board, int fromRow, int fromCol, int toRow, int toCol){
        //BISHOP+ROOK
        return validateBishopMove(board, fromRow, fromCol, toRow, toCol) && validateRookMove(board, fromRow, fromCol, toRow, toCol);
    }
}
