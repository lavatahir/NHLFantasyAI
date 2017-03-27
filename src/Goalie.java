
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
	
	public String toString(){
		String s = "";
		s+= name + "\n";
		s+= "W:"+ +wins + " Saves:" + saves;
		return s;
	}
	public boolean equals(Player p){
		if(p instanceof Goalie){
			if(((Goalie) p).getSaves() == this.getSaves() && ((Goalie) p).getWins() == this.getWins() && ((Goalie) p).getName().equals(this.getName())){
				return true;
			}
		}
		return false;
	}
}
