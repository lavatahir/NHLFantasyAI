
public class Node {
	private Lineup gameState;
	private Node parentNode;
	private double cost;
	private double hCost;
	private double fCost;
	
	public Node(Lineup s){
		gameState = s;
		parentNode = null;
		cost = 0;
		hCost = 0;
		fCost = 0;
	}
	public Node(Lineup gameState, Node parent){
		this.gameState = gameState;
		this.parentNode = parent;
		cost = 0;
		hCost = 0;
		fCost = 0;
	}
	public Node(Node prev, Lineup m, double c, double h){
		parentNode = prev;
		gameState = m;
		cost = c;
		hCost = h;
		fCost = cost+hCost;
	}
	
	public double getCost() {
		return cost;
	}
	public double getHCost() {
		return hCost;
	}
	public double getFCost() {
		return fCost;
	}
	public Lineup getGameState(){
		return gameState;
	}
	public Node getParent(){
		return parentNode;
	}
}
