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
		
	}

	private boolean isGameOver(){
		return false;
	}

	private Player whoIsWinner(){
		return player1;
	}


	public static void main(String[] args) {
		new TicTacToe();
	}
}
