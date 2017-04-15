import java.util.*;

public class SimpleHillClimb {
	public static void search(Lineup l)
	{
		performSearch(l);
	}
	
	
	public static void performSearch(Lineup l)
	{	
		int cost = 3;
		while(!l.isGoalState()){
			HashSet<Lineup> neighbors = l.generateSuccessors();
			for(Lineup nn : neighbors){
				if(nn.isGoalState()){
					System.out.println("The total cost was:"+cost);
					System.exit(0);
				}
				else if(nn.getTotalScore() > l.getTotalScore() || nn.moreForwardPass(l) || nn.goaliePass() || nn.defensePass()){
					l = nn;
				}
				/*
				else if(nn.moreForwardPass(l)){
					l = nn;
				}
				else if(nn.goaliePass()){
					l = nn;
				}
				else if(nn.defensePass()){
					l = nn;
				}
				*/
				
			}
			cost++;
			System.out.println(l);
		}
	}
}
