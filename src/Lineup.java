import java.util.*;

public class Lineup{

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
	
	public Lineup(ArrayList<ArrayList<Player>> lineup, ArrayList<Player> forwardLine, ArrayList<Player> defenseLine, ArrayList<Player> goalieLine){
		this.lineup = new ArrayList<ArrayList<Player>>(lineup);
		this.forwardLine = new ArrayList<Player>(forwardLine);
		this.defenseLine = new ArrayList<Player>(defenseLine);
		this.goalieLine = new ArrayList<Player>(goalieLine);
	}
	public int playersInLineup(){
		return forwardLine.size() + defenseLine.size() + goalieLine.size();
	}
	public void addPlayer(Player p){
		//Lineup l = new Lineup(lineup, forwardLine, defenseLine, goalieLine, rg);
			if(p instanceof Forward){
				if(forwardLine.size() < 3){
					forwardLine.add(p);
				}
				else{
					forwardLine.remove(forwardLine.size()-1);
					forwardLine.add(p);
				}
			}
			else if(p instanceof Defensemen){
				if(defenseLine.size() < 2){
					defenseLine.add(p);
				}
				else{
					defenseLine.remove(defenseLine.size()-1);
					defenseLine.add(p);
				}
			}
			else if(p instanceof Goalie){
				if(goalieLine.size() == 0){
					goalieLine.add(p);
				}
				else{
					goalieLine.remove(goalieLine.size()-1);
					goalieLine.add(p);
				}
			}
	}
	public String toString(){
		String s = "";
		/*
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
		*/
		s+= "Forwards:\n";
		for(Player p : forwardLine){	
			s+= p + "\n";
			s+="\n";
		}
		s+= "Defensemen:\n";
		for(Player p : defenseLine){	
			s+= p + "\n";
			s+="\n";
		}
		s+= "Goalie:\n";
		for(Player p : goalieLine){	
			s+= p + "\n";
			s+="\n";
		}
		return s;
	}
	//fix this to include equals
	public boolean containsPlayer(Player p){
		for(ArrayList<Player> line : lineup){
			for(Player pLine : line){
				if(p.equals(pLine)){
					return true;
				}
			}
		}
		
		return false;
	}
	public void combination(ArrayList<Forward> arr, int len, int startPosition, ArrayList<Player> forwards){
	        if (len == 0){
	            return;
	        }       
	        for (int i = startPosition; i <= arr.size()-len; i++){
	        	forwards.set(forwards.size() - len, arr.get(i));
	            combination(arr, len-1, i+1, forwards);
	        }
	    }  
	public HashSet<Lineup> generateSuccessors(){
		HashSet<Lineup> successors = new HashSet<Lineup>();
		if(forwardLine.size() < 3){
			int playersMissing = 3 - forwardLine.size();
			for(int i = 0 ; i < playersMissing; i++){
				Lineup l = new Lineup(lineup, forwardLine, defenseLine, goalieLine);
				for(Player p : rg.roster){
					if(!containsPlayer(p)){
						l.addPlayer(p);
					}
				}
				successors.add(l);
			}
			
		}
		
		
		//l = new Lineup(lineup, forwardLine, defenseLine, goalieLine, rg);
		//successors.add(l.addPlayer(rg.roster.get(2)));
		/*
		for(Player p : rg.roster){
			Lineup l = new Lineup(lineup, forwardLine, defenseLine, goalieLine, rg);
			if(!l.containsPlayer(p)){
				l.addPlayer(p);
				successors.add(l);
			}
		}
		*/
		return successors;
	}
	public static void main(String[] args){
		RosterGenerator rg = new RosterGenerator();
		Lineup l = new Lineup();
		/*
		l.addPlayer(rg.getPlayer("Crosby"));
		l.addPlayer(rg.getPlayer("Backstrom"));
		l.addPlayer(rg.getPlayer("Burrows"));
		l.addPlayer(rg.getPlayer("Karlsson"));
		l.addPlayer(rg.getPlayer("Krug"));*/
		/*l.addPlayer(rg.getPlayer("Backstrom"));
		l.addPlayer(rg.getPlayer("Burrows"));
		l.addPlayer(rg.getPlayer("Granlund"));
		l.addPlayer(rg.getPlayer("Karlsson"));
		l.addPlayer(rg.getPlayer("Krug"));
		l.addPlayer(rg.getPlayer("Green"));
		
		l.addPlayer(rg.getPlayer("Jones"));
		l.addPlayer(rg.getPlayer("Condon"));*/
		//System.out.println(l);
		ArrayList<Player> forwards = new ArrayList<Player>();
		l.combination(l.rg.getForwards(), 3, 0, forwards);
		System.out.println(forwards);
		//System.out.println(l.generateSuccessors());
		
		
	}

	
}
