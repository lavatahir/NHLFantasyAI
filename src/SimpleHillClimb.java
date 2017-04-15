import java.util.*;

public class SimpleHillClimb {
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
		
		int cost = 3;
		while(!l.isGoalState()){
			HashSet<Lineup> neighbors = l.generateSuccessors();
			for(Lineup nn : neighbors){
				if(nn.isGoalState()){
					System.out.println("The total cost was:"+cost);
					System.exit(0);
				}
				else if(nn.moreForwardPass(l)){
					l = nn;
				}
				else if(nn.goaliePass()){
					l = nn;
				}
			}
			cost++;
			System.out.println(l);
		}
		//System.out.println(l);
		
		/*
		while(!l.isGoalState()){
			HashSet<Lineup> neighbors = l.generateSuccessors();
			System.out.println(neighbors.size());
			Lineup temp = null;
			for(Lineup nn : neighbors){
				if(nn.isGoalState()){
					System.out.println(l);
					System.out.println();
					System.out.println("The number of moves was: " + 1);
				}
				System.out.println(nn.getTotalScore());
				if(nn.getTotalScore() > l.getTotalScore()){
					
					l = nn;
					neighbors = l.generateSuccessors();
					System.out.println("WE HERE");
				}
				temp = nn;
			}
			l = temp;

		}
		if(l.isGoalState()){
			System.out.println(l);
			System.out.println();
			System.out.println("The number of moves was: " + 1);
		}*/
		/*
		HashSet<Lineup> visitedStates = new HashSet<Lineup>();
		Node tempNode = (Node) q.poll();
		while (!q.isEmpty()) 
		{
			
			visitedStates.add(tempNode.getGameState());
			if (!tempNode.getGameState().isGoalState()) 
			{
				HashSet<Lineup> tempSuccessors = tempNode.getGameState().generateSuccessors(); 
				for(Lineup s : tempSuccessors){
					Node newNode = new Node(tempNode,s, tempNode.getCost()+ s.findCost(), 0);
					if (newNode.getGameState().isGoalState()) {
						Stack<Node> solutionPath = new Stack<Node>();
						solutionPath.push(newNode);
						tempNode = newNode.getParent();

						while (tempNode.getParent() != null)
						{
							solutionPath.push(tempNode);
							tempNode = tempNode.getParent();
						}
						solutionPath.push(tempNode);

						int loopSize = solutionPath.size();

						for (int i = 0; i < loopSize; i++)
						{
							tempNode = solutionPath.pop();
							System.out.println(tempNode.getGameState());
							System.out.println();
						}
						System.out.println("The number of moves was: " + tempNode.getCost());

						System.exit(0);
					}
					if(!visitedStates.contains(newNode.getGameState()) && !checkRepeatsParent(newNode)){
						q.add(newNode);
						visitedStates.add(newNode.getGameState());
					}
				}
			}
			else
			{
				Stack<Node> solutionPath = new Stack<Node>();
				solutionPath.push(tempNode);
				
				while (tempNode.getParent() != null)
				{
					tempNode = tempNode.getParent();
					solutionPath.push(tempNode);
					tempNode = tempNode.getParent();
				}
				solutionPath.push(tempNode);

				int loopSize = solutionPath.size();

				for (int i = 0; i < loopSize; i++)
				{
					tempNode = solutionPath.pop();
					System.out.println(tempNode.getGameState());
					System.out.println();
				}
				System.out.println("The number of moves was: " + tempNode.getCost());

				System.exit(0);
			}
		}

		System.out.println("no solution");
		*/
	}
}
