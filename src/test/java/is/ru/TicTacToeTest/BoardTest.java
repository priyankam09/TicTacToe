/*Test class for board */
package is.ru.TicTacToe;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
	public static void main(String args[]) {	
     	org.junit.runner.JUnitCore.main("is.ru.stringcalculator.BoardTest");
    }

    @Test
    public void testSetTile(){
    	Board board = new Board();
		board.setTile(1, 'X');
		assertEquals('X', board.getTile(0, 0));	
    }

}