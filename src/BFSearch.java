import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BFSearch {

	public BFSearch(){
		//queue = new LinkedList<Integer>();
	}
	public static void bfsSolution(Lineup m){
		Queue<Node> queue = new LinkedList<Node>();
		HashSet<Lineup> visitedStates = new HashSet<Lineup>();
		
		queue.add(new Node(m,null));
		
		while(!(queue.isEmpty())){
			Node currentNode = (Node) queue.poll();
			if(currentNode.getGameState().isGoalState())
			{
				Stack<Node> solutionPath = new Stack<Node>();
				solutionPath.push(currentNode);
				currentNode = currentNode.getParent();

				while (currentNode.getParent() != null)
				{
					solutionPath.push(currentNode);
					currentNode = currentNode.getParent();
				}
				solutionPath.push(currentNode);

				int loopSize = solutionPath.size();

				for (int i = 0; i < loopSize; i++)
				{
					currentNode = solutionPath.pop();
					System.out.println(currentNode.getGameState());
				}
				
				System.exit(0);
			}
			else
			{
				visitedStates.add(currentNode.getGameState());
				System.out.println("size of successors:" + currentNode.getGameState().generateSuccessors().size());
				for(Lineup mSuc : currentNode.getGameState().generateSuccessors()){
					queue.add(new Node(currentNode,mSuc, currentNode.getCost()+ mSuc.findCost(), 0));
				}
				
			}
		}

		System.out.println("no solution");			
	}
	
	
	public static void search(Lineup l)
	{
		Node root = new Node(l);
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

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
					System.out.println(s + " size:" + visitedStates.size());
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
				System.out.println("The number of moves was: " + tempNode.getCost());

				System.exit(0);
			}
		}

		System.out.println("no solution");
	}
	
}
