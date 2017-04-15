import java.util.*;

public class SteepHillClimb {
	public static void search(Lineup l)
	{
		performSearch(l);
	}
	
	
	public static void performSearch(Lineup l)
	{
		/*
		l.addPlayer(l.randForward[l.r.nextInt(l.randForward.length)]);
		System.out.println(l);
		l.addPlayer(l.randDefense[l.r.nextInt(l.randDefense.length)]);
		System.out.println(l);
		l.addPlayer(l.randGoalie[l.r.nextInt(l.randGoalie.length)]);
		System.out.println(l);
		*/
		
		Lineup succ = l;
		int cost = 3;
		while(!l.isGoalState()){
			int nextLineTotalScore = 0;
			Lineup nextLineupClosest = null;
			
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
				if(nn.getTotalScore() > nextLineTotalScore){
					nextLineTotalScore = nn.getTotalScore();
					nextLineupClosest = nn;
				}
			}
			
			if(succ.moreForwardPass(l)){
				l = succ;
			}
			else if(succ.goaliePass()){
				l = succ;
			}
			else{
				l = nextLineupClosest;
			}
			cost++;
			System.out.println(l);
		}
	}
}

