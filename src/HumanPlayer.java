
import java.util.Scanner;

public class HumanPlayer implements Player {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public boolean makeMove(Board board, Color color) {
        System.out.println(color + "s Turn");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        if(parts.length != 2){
            System.out.println("Invalid Input");
            return false;
        }
        int fromCol  = parts[0].charAt(0) - 'a';
        int fromRow = 8 - (parts[0].charAt(1) - '0');
        int toCol = parts[1].charAt(0) - 'a';
        int toRow = 8 - (parts[1].charAt(1) - '0');

        Piece piece = board.getPieceAt(fromRow, fromCol);

        if(piece == null && piece.getColor() == color){
            System.out.println("No valid piece");
            return false;
        }

        if(MoveValidator.isValidMove(board, fromRow, fromCol, toRow, toCol)){
            board.movePiece(fromRow, fromCol, toRow, toCol);
            return true;
        } else {
            System.out.println("Invalid move");
        }
        return false;
    }
    
}
