package is.ru.TicTacToe;
import static org.junit.Assert.assertEquals;
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
}
