
public abstract class Skater implements Player{

	private int goals;
	private int assists;
	private int shots;
	private int penaltyMins;
	
	public Skater(int goals, int assists, int shots, int penaltyMins){
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
	
}
