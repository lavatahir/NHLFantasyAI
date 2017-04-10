import java.util.*;


public class AStar {
	public static void search(Lineup board, char heuristic)
	{
		board.addPlayer(board.randForward[board.r.nextInt(board.randForward.length)]);
		System.out.println(board);
		board.addPlayer(board.randDefense[board.r.nextInt(board.randDefense.length)]);
		System.out.println(board);
		board.addPlayer(board.randGoalie[board.r.nextInt(board.randGoalie.length)]);
		System.out.println(board);
		
		
		Node root = new Node(board,null);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
	
		
		while (!q.isEmpty()) // while the queue is not empty
		{
			Node tempNode = (Node) q.poll();
			
	
			if (!tempNode.getGameState().isGoalState())
			{
				/*
				ArrayList<Lineup> tempSuccessors = new ArrayList<Lineup>();
				for(Pair p : tempNode.getGameState().getAllPossibleMoves()){
					Lineup successor = tempNode.getGameState().move(p);
					tempSuccessors.add(successor);
				}
				*/
				HashSet<Lineup> tempSuccessors = tempNode.getGameState().generateSuccessors(); 
						
				ArrayList<Node> nodeSuccessors = new ArrayList<Node>();
	
				for (Lineup s : tempSuccessors)
				{
					Node checkedNode = new Node(tempNode,s, tempNode.getCost()+ s.findCost(),s.getTotalScore());
					
					if (!checkRepeats(checkedNode))
					{
						nodeSuccessors.add(checkedNode);
					}
					
				}
	
				if (nodeSuccessors.size() == 0)
					continue;
	
				Node lowestNode = nodeSuccessors.get(0);
	
				for (int i = 0; i < nodeSuccessors.size(); i++)
				{
					if (lowestNode.getFCost() < nodeSuccessors.get(i)
							.getFCost())
					{
						lowestNode = nodeSuccessors.get(i);
						
					}
				}
	
				int lowestValue = (int) lowestNode.getFCost();
	
				for (int i = 0; i < nodeSuccessors.size(); i++)
				{
					if (nodeSuccessors.get(i).getFCost() == lowestValue)
					{
						q.add(nodeSuccessors.get(i));
						
					}
				}
			}
			else
			{
				Stack<Node> solutionPath = new Stack<Node>();
				solutionPath.push(tempNode);
				tempNode = tempNode.getParent();
	
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
		}
	
		System.out.println("no solution");
	
	}

	private static boolean checkRepeats(Node n)
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
}
