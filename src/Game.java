public class Game {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Color currentTurn;

    public Game(Player white, Player black) {
        board = new Board();
        whitePlayer = white;
        blackPlayer = black;
        currentTurn = Color.WHITE;
    }

    public void start() {
        board.printBoard();
        while (true) {
            boolean moved;
            if (currentTurn == Color.WHITE) {
                moved = whitePlayer.makeMove(board, currentTurn);
            } else {
                moved = blackPlayer.makeMove(board, currentTurn);
            }

            if (moved) {
                board.printBoard();
                currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
            }
        }
    }
}
