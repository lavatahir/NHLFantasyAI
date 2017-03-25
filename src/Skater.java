
public abstract class Skater implements Player{
	private String name;
	private int goals;
	private int assists;
	private int shots;
	private int penaltyMins;
	
	public Skater(String name, int goals, int assists, int shots, int penaltyMins){
		this.name = name;
		this.goals = goals;
		this.assists = assists;
		this.shots = shots;
		this.penaltyMins = penaltyMins;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public int getPenaltyMins() {
		return penaltyMins;
	}

	public void setPenaltyMins(int penaltyMins) {
		this.penaltyMins = penaltyMins;
	}
	public String toString(){
		String s = "";
		s+= name + "\n";
		s+= "G:"+goals + " A:" + assists +  " S:" + shots + " PIM" + penaltyMins;
		return s;
	}
}
