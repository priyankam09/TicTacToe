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
    	// RowAcross \
    	if(getTile(1) != ' ' && getTile(1) == getTile(5) && getTile(1) == getTile(9)){
    		return true;
    	} // RowAcross /
    	if (getTile(3) != ' ' && getTile(3) == getTile(5) && getTile(3) == getTile(7)){
    		return true;
    	} // RowHorizontally -
    	for(int i = 1; i <= TILES; i++){
    		if (getTile(i) != ' ' && getTile(i) == getTile(i + 1) && getTile(i) == getTile(i + 2)) {
    			return true;
    		}
    	} // RowVertically |
		for(int i = 1; i <= TILES; i++){
    		if (getTile(i) != ' ' && getTile(i) == getTile(i + 3) && getTile(i) == getTile(i + 6)) {
    			return true;
    		}
    	}
    	return false;
    }

    public boolean hasThreeInRow(char symbol){
    	// RowAcross \
    	if(getTile(1) == symbol && getTile(5) == symbol && getTile(9) == symbol){
    		return true;
    	} // RowAcross /
    	if (getTile(3) == symbol && getTile(5) == symbol && getTile(7) == symbol){
    		return true;
    	} // RowHorizontally -
    	for(int i = 1; i <= TILES; i++){
    		if (getTile(i) == symbol && getTile(i + 1) == symbol && getTile(i + 2) == symbol) {
    			return true;
    		}
    	} // RowVertically |
		for(int i = 1; i <= TILES; i++){
    		if (getTile(i) == symbol && getTile(i + 3) == symbol && getTile(i + 6) == symbol) {
    			return true;
    		}
    	}
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

