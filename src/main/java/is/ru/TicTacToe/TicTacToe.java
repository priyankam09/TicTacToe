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

	public String getScoreMessager(){
		return player1.getName() + ":" + player1.getScore() + "  |  " 
				+ player2.getName() + ":" + player2.getScore();
	}

	public void resetBoard(){
		board = new Board();
	}

	public boolean playAgain(){
		Scanner in = new Scanner(System.in);
		System.out.println("Want to play again? y/n");
		String ans = in.nextLine();
		if (ans.equals("y") || ans.equals("Y")) {
			return true;
		}
		return false;
	}

	public int getMove(Player player){
		Scanner in = new Scanner(System.in);
		System.out.print(player.getName() + " move: ");
		int move = in.nextInt();
		if(move < 1 || move > 9) {
		 	System.out.println("Input must be between 1 and 9");
		 	move = getMove(player);
		 }
		 if(board.isTileSet(move)){
		 	System.out.println("Tile is set enter another tile");
		 	move = getMove(player);
		 }
		return move;
	}

	public void getNames(){
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the TicTacToe game!");
		System.out.print("Enter name for player1: ");
		player1.setName(in.nextLine());
		System.out.print("Enter name for player2: ");
		player2.setName(in.nextLine());
	}

	public void makeMove(Player player, int move){
		board.setTile(move, player.getSymbol());
	}

	public boolean isGameOver(){
		return board.isFull() || board.hasWinner();
	}

	public Player whoIsWinner(){
		if(board.hasThreeInRow(player1.getSymbol())){ // did player1 win ?
			player1.increaseScore();
			return player1;
		}
		else{
			player2.increaseScore();
			return player2;
		}
	}


	public static void main(String[] args) {
		new TicTacToe();
	}
}
