import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;


public class AStar {

	int goal;
	int currentNode, evaluation;
	ArrayList<Integer> start;
	Graph g;
	
	HashMap<Integer, Integer> costSoFar;
	PriorityQueue<Integer> frontier = new PriorityQueue<Integer>(10);
	
void AStar(Graph g, int goal, int currentNode, ArrayList<Integer> start) {
		
		this.goal = goal;
		this.currentNode = currentNode;
		this.start = start;
		this.g = g;
		costSoFar = new HashMap<Integer,Integer>();
	}
	
	boolean AStarSearch(){
		
		int firstNode = start.get(0);
		costSoFar.put(firstNode, 0);
		
		if (firstNode == goal)
			return true;
		
		
		while(!frontier.isEmpty()){
			currentNode = frontier.poll();
			if (currentNode == goal)
				return true;
			ArrayList<Integer> temp = g.adjMatrix.get(currentNode);
			
			for(int nodes:temp){
				int newCost = (int) costSoFar.get(currentNode) + nodes;
				
				
				
				if(!costSoFar.containsKey(nodes)|| newCost < costSoFar.get(nodes)){					
					costSoFar.put(nodes,newCost);
					evaluation = newCost + heuristic(nodes);
					frontier.add(nodes);		
					
				}
			}
			 
			
		}
		
		
		return false;
	}
	
	
	int heuristic(int Node){
		return (int)(Math.sqrt(Node*Node-goal*goal));
	}
	
}
