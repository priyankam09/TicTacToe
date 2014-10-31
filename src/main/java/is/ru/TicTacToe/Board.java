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
    public char getTile(int i, int j) {
    	return tiles[i][j];
    }

    public void display(){
        return;
    }

    public void setTile(int tile, char symbol){
		
		if(tile > 0 && tile < 10){
			int i = (tile + 2) % 3;
			int j = (tile - 1) / 3;
			tiles[i][j] = symbol;
		}
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

