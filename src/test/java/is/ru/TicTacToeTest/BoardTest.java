/*Test class for board */
package is.ru.TicTacToe;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import static org.hamcrest.core.IsEqual.equalTo;

public class BoardTest {
       public static void main(String args[]) {
       org.junit.runner.JUnitCore.main("is.ru.stringcalculator.BoardTest");
    }

    @Test
    public void testSetTile(){
       Board board = new Board();
               board.setTile(1, 'X');
               assertEquals('X', board.getTile(1));
    }
    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Test
    public void testGetTileOutOfBounds(){
    
    	ex.expect(IndexOutOfBoundsException.class);
    	ex.expectMessage(equalTo("Tile out of bounds"));

    	Board board = new Board();
        board.getTile(-1);
    }

    @Test
    public void testSetTileOutOfBounds(){
    
    	ex.expect(IndexOutOfBoundsException.class);
    	ex.expectMessage(equalTo("Tile out of bounds"));

    	Board board = new Board();
        board.setTile(-1, 'X');
    }
}