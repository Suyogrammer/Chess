
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer implements Player {

    private Random random = new Random();

    @Override
    public boolean makeMove(Board board, Color color) {
        List<int[]> legalMoves = new ArrayList<>();

        //Generate all legal moves
        for(int r=0; r<8; r++){
            for (int c=0; c<8; c++){
                Piece piece = board.getPieceAt(r, c);
                if(piece != null && piece.getColor()==color){
                    for(int tr=0; tr<8; tr++){
                        for(int tc=0; tc<8; tc++){
                            if(MoveValidator.isValidMove(board, r, c, tr, tc)){
                                legalMoves.add(new int[]{r,c,tr,tc});
                            }
                        }
                    }
                }
            }
        }
        //No moves available
        if(legalMoves.isEmpty()) return false;

        //Pick a random move
        int[] move = legalMoves.get(random.nextInt(legalMoves.size()));
        board.movePiece(move[0], move[1], move[2], move[3]);
        return true;
    }
    
}
