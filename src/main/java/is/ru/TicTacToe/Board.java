package is.ru.TicTacToe;

public class Board {
    public static final int TILES = 3;
    private char[][] tiles;

    public Board(){
        tiles = new char[TILES][TILES];
        for(int i = 0; i < TILES; i++){
            for(int j = 0; j < TILES; j++){
                tiles [i][j] = ' ';
            }
        }
    }
    public char getTile(int tile) {

    	if(tile > 0 && tile < 10){
			int i = (tile + 2) % 3;
			int j = (tile - 1) / 3;
			return tiles[i][j];
		}else
			throw new IndexOutOfBoundsException("Tile out of bounds");
    }

    public void display(){
        return;
    }

    public void setTile(int tile, char symbol){
		
		if(tile > 0 && tile < 10){
			int i = (tile + 2) % 3;
			int j = (tile - 1) / 3;
			if(getTile(tile) == ' '){
				tiles[i][j] = symbol;
			}else
				throw new IndexOutOfBoundsException("Tile already set");
		}else
			throw new IndexOutOfBoundsException("Tile out of bounds");

    }

    public boolean hasWinner(){
    	return false;
    }

    public boolean hasRow(char symbol){
    	return false;
    }

    public boolean isFull(){
        return false;
    }
}

