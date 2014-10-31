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
    	return '0';
    }

    public void display(){
        return;
    }

    public boolean isTileSet(int tile){
    	return false;
    }

    public void setTile(int tile, char symbol){
		return;
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

