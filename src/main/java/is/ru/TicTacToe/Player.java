package is.ru.TicTacToe;

public class Player {
	private String name;
	private int score;
	private char symbol;

	public Player(String newName, char newSymbol) {
		name = newName;
		score = 0;
		symbol = newSymbol;
	}
	

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public int getScore() {
		return score;
	}
	
	public void increaseScore() {
		this.score++;
	}
	
	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}

