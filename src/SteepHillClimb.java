import java.util.*;

public class SteepHillClimb {
	public static void search(Lineup l)
	{
		performSearch(l);
	}
	
	
	public static void performSearch(Lineup l)
	{
		Lineup succ = l;
		int cost = 3;
		while(!l.isGoalState()){
			
			HashSet<Lineup> neighbors = l.generateSuccessors();
			for(Lineup nn : neighbors){
				if(nn.isGoalState()){
					System.out.println("The total cost was:"+cost);
					System.exit(0);
				}
				else if(nn.moreForwardPass(succ)){
					succ = nn;
				}
				else if(nn.goaliePass()){
					succ = nn;
				}
			}
			if(succ.moreForwardPass(l)){
				l = succ;
			}
			else if(succ.goaliePass()){
				l = succ;
			}
			cost++;
			System.out.println(l);
		}
	}
}

