import java.util.*;

public class Lineup {

	private ArrayList<ArrayList<Player>> lineup;
	private ArrayList<Player> forwardLine;
	private ArrayList<Player> defenseLine;
	private ArrayList<Player> goalieLine;
	private RosterGenerator rg;
	public Lineup(){
		lineup = new ArrayList<ArrayList<Player>>();
		forwardLine = new ArrayList<Player>(3);
		defenseLine = new ArrayList<Player>(2);
		goalieLine = new ArrayList<Player>(1);
		lineup.add(forwardLine);
		lineup.add(defenseLine);
		lineup.add(goalieLine);
		rg = new RosterGenerator();
	}
	
	public Lineup(ArrayList<ArrayList<Player>> lineup, ArrayList<Player> forwardLine, ArrayList<Player> defenseLine, ArrayList<Player> goalieLine,RosterGenerator rg){
		this.lineup = lineup;
		this.forwardLine = forwardLine;
		this.defenseLine = defenseLine;
		this.goalieLine = goalieLine;
		this.rg = rg;
	}
	public int playersInLineup(){
		return forwardLine.size() + defenseLine.size() + goalieLine.size();
	}
	public void addPlayer(Player p){
		if(lineup.size() < 5){
			if(p instanceof Forward){
				if(forwardLine.size() < 3){
					lineup.get(0).add(p);
				}
				else{
					lineup.get(0).remove(lineup.get(0).size()-1);
					lineup.get(0).add(p);
				}
			}
			else if(p instanceof Defensemen){
				if(lineup.get(1).size() < 2){
					lineup.get(1).add(p);
				}
				else{
					lineup.get(1).remove(lineup.get(1).size()-1);
					lineup.get(1).add(p);
				}
			}
			else if(p instanceof Goalie){
				if(lineup.get(2).size() == 0){
					lineup.get(2).add(p);
				}
				else{
					lineup.get(2).remove(lineup.get(2).size()-1);
					lineup.get(2).add(p);
				}
			}
		}
	}
	public String toString(){
		String s = "";
		for(int i = 0; i < lineup.size(); i++){
			if(i == 0){
				s+= "Forwards:\n";
			}
			else if(i == 1){
				s+= "Defensemen:\n";
			}
			else if(i == 2){
				s+= "Goalie:\n";
			}
			for(Player p : lineup.get(i)){
				s+= p + "\n";
			}
			s+="\n";
		}
		return s;
	}
	//fix this to include equals
	public boolean containsPlayer(Player p){
		if(forwardLine.contains(p)) return true;
		else if (defenseLine.contains(p)) return true;
		else if(goalieLine.contains(p)) return true;
		
		return false;
	}
	public HashSet<Lineup> generateSuccessors(){
		HashSet<Lineup> successors = new HashSet<Lineup>();
		Lineup l = new Lineup(lineup, forwardLine, defenseLine, goalieLine, rg);
		if(l.playersInLineup() < 5){
			for(Player p : l.rg.roster){
				if(!l.containsPlayer(p)){
					System.out.println("WE HERE WITH"+p);
					l.addPlayer(p);
					successors.add(l);
					return successors;
				}
			}
		}
		
		return successors;
	}
	public static void main(String[] args){
		RosterGenerator rg = new RosterGenerator();
		Lineup l = new Lineup();
		
		l.addPlayer(rg.getPlayer("Crosby"));
		/*l.addPlayer(rg.getPlayer("Backstrom"));
		l.addPlayer(rg.getPlayer("Burrows"));
		l.addPlayer(rg.getPlayer("Granlund"));
		l.addPlayer(rg.getPlayer("Karlsson"));
		l.addPlayer(rg.getPlayer("Krug"));
		l.addPlayer(rg.getPlayer("Green"));
		
		l.addPlayer(rg.getPlayer("Jones"));
		l.addPlayer(rg.getPlayer("Condon"));*/
		System.out.println(l);
		System.out.println(l.generateSuccessors());
	}
}
