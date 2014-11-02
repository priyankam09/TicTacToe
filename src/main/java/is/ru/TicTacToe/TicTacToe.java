package is.ru.TicTacToe;
import java.util.Scanner;
public class TicTacToe {

	private Player player1;
	private Player player2;
	private Board board;
	private boolean playerTurn;

	public TicTacToe() {
		player1 = new Player("player1", 'X');
		player2 = new Player("player2", 'O');
		board = new Board();
		playerTurn = true;
	}

	public String play(int move) {
		String symbol = Character.toString(getPlayerTurn().getSymbol());
		makeMove(getPlayerTurn(), move);
		switchPlayerTurn();
		return symbol;
	} 

	public void switchPlayerTurn() {
		playerTurn = !playerTurn;
	}

	public Player getPlayerTurn() {
		if (this.playerTurn){
			return player1;
		}
		else {
			return player2;
		}
	}

	public void resetBoard(){
		board = new Board();
	}

	public void makeMove(Player player, int move){
		board.setTile(move, player.getSymbol());
	}

	public boolean isGameOver(){
		return board.isFull() || board.hasWinner();
	}

	public String whoIsWinner(){
		if(board.hasThreeInRow(player1.getSymbol())){ // did player1 win ?
			return player1.getName() + " wins";
		}
		else if (board.hasThreeInRow(player2.getSymbol())) {
			return player2.getName() + " wins";
		}
		else {
			return "It's a tie";
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
	}
}
