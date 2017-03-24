
public class Goalie implements Player{
	private String name;
	private int saves;
	private int wins;
	
	public Goalie(String name , int saves, int wins){
		this.name = name;
		this.saves = saves;
		this.wins = wins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
