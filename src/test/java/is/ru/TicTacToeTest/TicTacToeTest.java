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
			OXX
		*/
		assertTrue(game.isGameOver());
	}

	@Test
	public void testIsGameOverFalse(){
		TicTacToe game = new TicTacToe();
		game.makeMove(game.getPlayerTurn(), 1);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 5);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 2);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 6);
		/*
			XX
			 OO
		*/
		assertTrue(!game.isGameOver());
	}

	@Test
	public void testWhoIsWinner(){
		TicTacToe game = new TicTacToe();
		game.makeMove(game.getPlayerTurn(), 1);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 5);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 2);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 6);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 3);
		/*
			XXX
			 OO
		*/
		assertEquals("player1 wins", game.whoIsWinner());
	}

		@Test
	public void testWhoIsWinner2(){
		TicTacToe game = new TicTacToe();
		game.makeMove(game.getPlayerTurn(), 2);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 9);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 3);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 5);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 6);
		game.switchPlayerTurn();
		game.makeMove(game.getPlayerTurn(), 1);
		/*
			XXX
			 OO
		*/
		assertEquals("player2 wins", game.whoIsWinner());
	}

		@Test
	public void testWhoIsWinnerTie(){
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
			OXX
		*/
		assertEquals("It's a tie", game.whoIsWinner());
	}
}
