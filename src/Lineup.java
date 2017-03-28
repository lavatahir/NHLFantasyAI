import java.util.*;

public class Lineup{

	private ArrayList<ArrayList<Player>> lineup;
	private ArrayList<Player> forwardLine;
	private ArrayList<Player> defenseLine;
	private ArrayList<Player> goalieLine;
	private static final RosterGenerator rg = new RosterGenerator();
	private static final int goalsCap = 90;
	private static final int assistsCap = 200;
	private static final int shotsCap = 100;
	private static final int pimsCap = 100;
	private static final int winsCap = 30;
	private static final int savesCap = 1500;
	
	public Lineup(){
		lineup = new ArrayList<ArrayList<Player>>();
		forwardLine = new ArrayList<Player>(3);
		defenseLine = new ArrayList<Player>(2);
		goalieLine = new ArrayList<Player>(1);
		lineup.add(forwardLine);
		lineup.add(defenseLine);
		lineup.add(goalieLine);
		//rg = new RosterGenerator();
	}
	
	public Lineup(ArrayList<ArrayList<Player>> lineup, ArrayList<Player> forwardLine, ArrayList<Player> defenseLine, ArrayList<Player> goalieLine){
		this.lineup = new ArrayList<ArrayList<Player>>(lineup);
		this.forwardLine = new ArrayList<Player>(forwardLine);
		this.defenseLine = new ArrayList<Player>(defenseLine);
		this.goalieLine = new ArrayList<Player>(goalieLine);
		//rg = new RosterGenerator();
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
		s+="\n";
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
		List<List<Forward>> forwardLineCombos = getForwardCombos();
		List<List<Defensemen>> DefenseLineCombos = getDefenseCombos();
		ArrayList<Goalie> goalies = rg.getGoalies();
		
		
		
		/*
		for(Player p : rg.roster){
			Lineup l = new Lineup(lineup, forwardLine, defenseLine, goalieLine);
			if(!l.containsPlayer(p)){
				l.addPlayer(p);
				successors.add(l);
			}
		}
		*/
		return successors;
	}
	public boolean isGoalState(){
		
		int lineGoals = 0;
		int lineAssists = 0;
		int lineShots = 0;
		int linePims = 0;
		int lineWins = 0;
		int lineSaves = 0;
		if(forwardLine.size() < 3 || defenseLine.size() < 2 || goalieLine.size() < 1){
			return false;
		}
		for(Player p : forwardLine){
			lineGoals += ((Forward) p).getGoals();
			lineAssists += ((Forward) p).getAssists();
			lineShots += ((Forward) p).getShots();
			linePims += ((Forward) p).getPenaltyMins();
		}
		for(Player p : defenseLine){
			lineGoals += ((Defensemen) p).getGoals();
			lineAssists += ((Defensemen) p).getAssists();
			lineShots += ((Defensemen) p).getShots();
			linePims += ((Defensemen) p).getPenaltyMins();
		}
		for(Player p : goalieLine){
			lineWins += ((Goalie) p).getWins();
			lineSaves += ((Goalie) p).getSaves();
		}
		
		if(lineGoals >= goalsCap && lineAssists >= assistsCap && lineShots >= shotsCap 
				&& linePims >= pimsCap && lineWins >= winsCap && lineSaves >= savesCap){
			System.out.println("G:"+lineGoals + " A:"+lineAssists + " Sh:"+lineShots + " PIMS:"+linePims + " W:"+lineWins + " Sa:"+lineSaves);
			return true;
		}
		return false;
	}
	@Override
    public int hashCode(){
		int lineGoals = 0;
		int lineAssists = 0;
		int lineShots = 0;
		int linePims = 0;
		int lineWins = 0;
		int lineSaves = 0;
		for(Player p : forwardLine){
			lineGoals += ((Forward) p).getGoals();
			lineAssists += ((Forward) p).getAssists();
			lineShots += ((Forward) p).getShots();
			linePims += ((Forward) p).getPenaltyMins();
		}
		for(Player p : defenseLine){
			lineGoals += ((Defensemen) p).getGoals();
			lineAssists += ((Defensemen) p).getAssists();
			lineShots += ((Defensemen) p).getShots();
			linePims += ((Defensemen) p).getPenaltyMins();
		}
		for(Player p : goalieLine){
			lineWins += ((Goalie) p).getWins();
			lineSaves += ((Goalie) p).getSaves();
		}
        int result = 1;
        result = lineGoals + lineAssists + lineShots +linePims +lineWins +lineSaves;
        return result;
	}
	public double findCost(){
		return 1;
	}
	
	public void subsetForwards(ArrayList<Forward> possiblecombos, int k, int start, int currLen, boolean[] used, ArrayList<Forward> allcombos) {
		if (currLen == k) {
			for (int i = 0; i < possiblecombos.size(); i++) {
				if (used[i] == true) {
					allcombos.add(possiblecombos.get(i));
				}
			}
			
			return;
		}
		if (start == possiblecombos.size()) {
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subsetForwards(possiblecombos, k, start + 1, currLen + 1, used, allcombos);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subsetForwards(possiblecombos, k, start + 1, currLen, used, allcombos);
	}
	public void subsetDefense(ArrayList<Defensemen> possiblecombos, int k, int start, int currLen, boolean[] used, ArrayList<Defensemen> allcombos) {
		if (currLen == k) {
			for (int i = 0; i < possiblecombos.size(); i++) {
				if (used[i] == true) {
					allcombos.add(possiblecombos.get(i));
				}
			}
			
			return;
		}
		if (start == possiblecombos.size()) {
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subsetDefense(possiblecombos, k, start + 1, currLen + 1, used, allcombos);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subsetDefense(possiblecombos, k, start + 1, currLen, used, allcombos);
	}
	static <T> List<List<T>> chopped(List<T> list, final int L) {
	    List<List<T>> parts = new ArrayList<List<T>>();
	    final int N = list.size();
	    for (int i = 0; i < N; i += L) {
	        parts.add(new ArrayList<T>(
	            list.subList(i, Math.min(N, i + L)))
	        );
	    }
	    return parts;
	}
	public List<List<Forward>> getForwardCombos(){
		ArrayList<Forward> possiblecombos = rg.getForwards();
		
		ArrayList<Forward> allcombos = new ArrayList<Forward>();
		boolean[] B = new boolean[possiblecombos.size()];
		
		subsetForwards(possiblecombos, 3, 0, 0, B, allcombos);
		List<List<Forward>> forwardcombos = chopped(allcombos, 3);
		return forwardcombos;
	}
	public List<List<Defensemen>> getDefenseCombos(){
		ArrayList<Defensemen> possiblecombos = rg.getDefensemen();
		
		ArrayList<Defensemen> allcombos = new ArrayList<Defensemen>();
		boolean[] B = new boolean[possiblecombos.size()];
		
		subsetDefense(possiblecombos, 3, 0, 0, B, allcombos);
		List<List<Defensemen>> defensecombos = chopped(allcombos, 3);
		return defensecombos;
	}
	
	
	public void testList(List<Integer> test){
	
	}
	public static void main(String[] args){
		RosterGenerator rg = new RosterGenerator();
		//System.out.println(rg.getForwards());
		Lineup l = new Lineup();
		
		
		
		System.out.println(l.getForwardCombos().size());
		System.out.println(l.getDefenseCombos().size());
		
		String list1[] = new String []{"A", "B", "C", "D"};
		String list2[] = new String []{"E", "F", "G", "H"};
		String list3[] = new String[]{};
		for(String s : list1){
			//for(int i = 0 ; i < ){
				//list3
			//}
		}
		
		/*
		l.addPlayer(rg.getPlayer("Crosby"));
		l.addPlayer(rg.getPlayer("Backstrom"));
		l.addPlayer(rg.getPlayer("Burrows"));
		l.addPlayer(rg.getPlayer("Karlsson"));
		l.addPlayer(rg.getPlayer("Krug"));
		l.addPlayer(rg.getPlayer("Jones"));*/
		/*l.addPlayer(rg.getPlayer("Backstrom"));
		l.addPlayer(rg.getPlayer("Burrows"));
		l.addPlayer(rg.getPlayer("Granlund"));
		l.addPlayer(rg.getPlayer("Karlsson"));
		l.addPlayer(rg.getPlayer("Krug"));
		l.addPlayer(rg.getPlayer("Green"));
		
		l.addPlayer(rg.getPlayer("Jones"));
		l.addPlayer(rg.getPlayer("Condon"));*/
		//System.out.println(l);
		//ArrayList<Player> forwards = new ArrayList<Player>();
		//l.combination(l.rg.getForwards(), 3, 0, forwards);
		//System.out.println(forwards);
		//System.out.println(l.generateSuccessors());
		//System.out.println(l.isGoalState());
		//BFSearch.search(l);
		
	}
	

	
}
