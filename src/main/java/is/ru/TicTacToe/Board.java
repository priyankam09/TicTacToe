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
		int i = getRow(tile);
		int j = getColumn(tile);
    	return tiles[i][j];
    }

    public void display(){
        return;
    }

    public boolean isTileSet(int tile){

		int i = getRow(tile);
		int j = getColumn(tile);
    	if(tiles[i][j] == ' '){
    		return false;
    	}else
    		return true;
    }

    public void setTile(int tile, char symbol){
		int i = getRow(tile);
		int j = getColumn(tile);
		tiles[i][j] = symbol;
    }

    public boolean hasWinner(){
    	return false;
    }

    public boolean hasRow(char symbol){
    	return false;
    }

    public boolean isFull(){
    	for(int i = 0; i < TILES; i++){
			for (int j = 0; j < TILES; j++){
				if(tiles[i][j] == ' '){
					return false;
				}
			}
		}
		return true;
    }

    private int getRow(int tile){
    	return (tile + 2) % 3;
    }

    private int getColumn(int tile){
		return (tile - 1) / 3;
    }
}

