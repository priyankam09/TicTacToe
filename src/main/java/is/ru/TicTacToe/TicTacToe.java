package is.ru.TicTacToe;
import java.util.Scanner;
public class TicTacToe {

	private Player player1;
	private Player player2;
	private Board board;

	public TicTacToe() {
		player1 = new Player("player1", 'X');
		player2 = new Player("player2", 'O');
		board = new Board();
		play();
	}

	public void play() {
		 getNames();
		 boolean playerTurn = true;
		 do{
		 	if(playerTurn) {
		 		int move = getMove(player1);
		 		while(move < 1 && move > 9) {
		 			System.out.println("Input must be between 1 and 9");
		 			move = getMove(player1);
		 		}
		 		while(board.isTileSet(move)){
		 			System.out.println("Tile is set enter another tile");
		 			move = getMove(player1);
		 		}
		 		makeMove(player1, move);
		 		playerTurn = false;
		 	}
		 	else {
		 		int move = getMove(player2);
		 		while(move < 1 && move > 9) {
		 			System.out.println("Input must be between 1 and 9");
		 			move = getMove(player2);
		 		}
		 		while(board.isTileSet(move)){
		 			System.out.println("Tile is set enter another tile");
		 			move = getMove(player2);
		 		}
		 		makeMove(player2, move);
		 		playerTurn = true;
		 	}
		 	board.display();
		 }while(!isGameOver());

		 if(!board.hasWinner()){
		 	System.out.println("It's a tie");
		 }
		 else {
		 	System.out.println(whoIsWinner().getName() + " won!");
		 }

	}

	private int getMove(Player player){
		Scanner in = new Scanner(System.in);
		System.out.print(player.getName() + " move: ");
		int move = in.nextInt();
		return move;
	}

	private void getNames(){
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the TicTacToe game!");
		System.out.print("Enter name for player1: ");
		player1.setName(in.nextLine());
		System.out.print("Enter name for player2: ");
		player2.setName(in.nextLine());
	}

	private void makeMove(Player player, int move){
		board.setTile(move, player.getSymbol());
	}

	private boolean isGameOver(){
		return board.isFull() || board.hasWinner();
	}

	private Player whoIsWinner(){
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
