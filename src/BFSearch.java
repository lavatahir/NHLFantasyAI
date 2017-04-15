import java.util.*;



public class BFSearch {

	public BFSearch(){
		//queue = new LinkedList<Integer>();
	}
	
	
	public static void search(Lineup l)
	{
		/*
		l.addPlayer(l.randForward[l.r.nextInt(l.randForward.length)]);
		System.out.println(l);
		l.addPlayer(l.randDefense[l.r.nextInt(l.randDefense.length)]);
		System.out.println(l);
		l.addPlayer(l.randGoalie[l.r.nextInt(l.randGoalie.length)]);
		System.out.println(l);
		*/
		
		Node root = new Node(l);
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		System.out.println(queue.size());

		performSearch(queue);
	}

	private static boolean checkRepeatsParent(Node n)
	{
		boolean retValue = false;
		Node checkNode = n;

		while (n.getParent() != null && !retValue)
		{
			if (n.getParent().getGameState().equals(checkNode.getGameState()))
			{
				retValue = true;
			}
			n = n.getParent();
		}

		return retValue;
	}

	public static void performSearch(Queue<Node> q)
	{
		
		HashSet<Lineup> visitedStates = new HashSet<Lineup>();
		while (!q.isEmpty()) 
		{
			Node tempNode = (Node) q.poll();
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
						System.out.println("The number of moves was: " + (tempNode.getCost()+3));

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
				System.out.println("The number of moves was: " + (tempNode.getCost()+3));

				System.exit(0);
			}
		}

		System.out.println("no solution");
	}
	
}
