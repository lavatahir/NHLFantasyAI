
public class Goalie implements Player{

	private int saves;
	private int wins;
	
	public Goalie(int saves, int wins){
		this.saves = saves;
		this.wins = wins;
	}

	public int getSaves() {
		return saves;
	}

	public void setSaves(int saves) {
		this.saves = saves;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	
}
