public class Piece {
    private PieceType pieceType;
    private Color color;

    public Piece(Color color, PieceType pieceType){
        this.color = color;
        this.pieceType = pieceType;
    }

    public String toString() {
        // Return a symbol based on type and color. 
        //Uppercase for WHITE and lowercase for BLACK.
        String symbol = pieceType.name().substring(0,1);
        return (color == Color.WHITE) ? symbol.toUpperCase() : symbol.toLowerCase();
    }
}
