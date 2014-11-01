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

    @Test
    public void testTileIsSet(){
    	Board board = new Board();
    	board.setTile(9, 'O');
    	assertTrue(board.isTileSet(9));
    }

    @Test
    public void testIsBoardFull(){
    	Board board = new Board();
    	for(int i = 1; i < 10; i++){
    		board.setTile(i, 'O');
    	}
    	assertTrue(board.isFull());
    }

    @Test
    public void testIsBoardEmpty(){
    	Board board = new Board();
    	assertTrue(!board.isFull());
    }

    @Test
    public void testRowVertically(){
    	Board board = new Board();
    	board.setTile(1, 'O');
    	board.setTile(4, 'O');
    	board.setTile(7, 'O');
    	assertTrue(board.hasThreeInRow('O'));
    }

    @Test
    public void testRowHorizontally(){
    	Board board = new Board();
    	board.setTile(1, 'O');
    	board.setTile(2, 'O');
    	board.setTile(3, 'O');
    	assertTrue(board.hasThreeInRow('O'));
    }

    @Test
    public void testRowVerticallyFalse(){
    	Board board = new Board();
    	board.setTile(1, 'O');
    	board.setTile(5, 'O');
    	board.setTile(3, 'O');
    	assertTrue(!board.hasThreeInRow('O'));
    }

    @Test
    public void testRowAcross(){
    	Board board = new Board();
    	board.setTile(1, 'O');
    	board.setTile(5, 'O');
    	board.setTile(9, 'O');
    	assertTrue(board.hasThreeInRow('O'));
    }

    @Test
    public void testThreeInRowFalse(){
    	Board board = new Board();
    	board.setTile(2, 'O');
    	board.setTile(5, 'O');
    	board.setTile(7, 'O');
    	assertTrue(!board.hasThreeInRow('O'));
    }

    @Test
    public void testHasWinnerAcross(){
    	Board board = new Board();
    	board.setTile(6, 'X');
    	board.setTile(1, 'O');
    	board.setTile(2, 'X');
    	board.setTile(3, 'O');
    	board.setTile(7, 'X');
    	board.setTile(5, 'O');
    	board.setTile(8, 'X');
    	board.setTile(9, 'O');
    	/*
    		O X O
    		  O X
    		X X O
		*/
    	assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerVertically(){
        Board board = new Board();
        board.setTile(1, 'O');
        board.setTile(2, 'X');
        board.setTile(4, 'O');
        board.setTile(5, 'O');
        board.setTile(6, 'X');
        board.setTile(7, 'O');
        board.setTile(8, 'X');
        board.setTile(9, 'X');
        /*
            O X 
            O O X
            O X X
        */
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerHorizontally(){
        Board board = new Board();
        board.setTile(1, 'O');
        board.setTile(2, 'O');
        board.setTile(3, 'O');
        board.setTile(6, 'X');
        board.setTile(8, 'X');
        board.setTile(9, 'X');
        /*
            O O O 
                X
              X X
        */
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerAcross2(){
        Board board = new Board();
        board.setTile(6, 'X');
        board.setTile(1, 'X');
        board.setTile(2, 'X');
        board.setTile(3, 'O');
        board.setTile(7, 'O');
        board.setTile(5, 'O');
        board.setTile(8, 'X');
        board.setTile(9, 'O');
        /*
            X X O
              O X
            O X O
        */
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasNoWinner(){
        Board board = new Board();
        board.setTile(6, 'X');
        board.setTile(1, 'X');
        board.setTile(2, 'X');
        board.setTile(3, 'O');
        board.setTile(5, 'O');
        board.setTile(8, 'X');
        board.setTile(9, 'O');
        /*
            X X O
              O X
              X O
        */
        assertTrue(!board.hasWinner());
    }
}