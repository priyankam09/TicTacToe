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
		int i, j;
		switch(tile) {
		case 1:
		case 2:
		case 3:
			i = 0;
			j = tile - 1;
			break;
		case 4:
		case 5:
		case 6:
			i = 1;
			j = tile - 4;
			break;
		case 7:
		case 8:
		case 9:
			i = 2;
			j = tile - 7;
			break;
		default:
			i = -1;
			j = -1;
		}
		if(!(i == -1 && j == -1)) {
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

