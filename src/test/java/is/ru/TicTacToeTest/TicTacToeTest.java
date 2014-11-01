package is.ru.TicTacToe;
import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("TicTacToe.TicTacToeTest");
	}

	@Test
	public void testSwitchPlayerTurn(){
		TicTacToe game = new TicTacToe();
		game.switchPlayerTurn();
		assertEquals("player2", game.getPlayerTurn().getName());
	}

	@Test
	public void testIsGameOver(){
		TicTacToe game = new TicTacToe();
		game.makeMove(game.getPlayerTurn(), 1);
		game.makeMove(game.getPlayerTurn(), 2);
		game.makeMove(game.getPlayerTurn(), 3);
		assertTrue(game.isGameOver());
	}

	@Test
	public void testIsGameOver2(){
		TicTacToe game = new TicTacToe();
		game.makeMove(game.getPlayerTurn(), 1);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 2);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 3);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 5);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 4);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 6);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 8);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 7);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 9);

		/*
			XOX
			XOO
			OXO
		*/
		assertTrue(game.isGameOver());
	}
}
