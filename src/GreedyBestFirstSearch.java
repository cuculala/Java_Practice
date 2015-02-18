import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class GreedyBestFirstSearch {
	
	int Goal;
	Graph g;
	ArrayList<Integer> start;
	public GreedyBestFirstSearch(int Goal, ArrayList<Integer> start, Graph g) {
	
		this.Goal = Goal;
		this.g = g;
		this.start = start;
		
	}
	
	boolean GBFS(){
	
		PriorityQueue<Integer> frontier= new PriorityQueue<Integer>(10, new HeuristicComparator());
		int firstNode = start.get(0);
		frontier.add(firstNode);
		
		while(!frontier.isEmpty()){
			int currentNode = frontier.poll();
			int smallestHeurist = Integer.MAX_VALUE, smallestNode;
			if (currentNode == Goal)
				return true; //Greedy solution found
			for (int nodes: g.adjMatrix.get(currentNode)){
				if(heuristic(nodes) < smallestHeurist)
					smallestNode = nodes;
			}
			
			frontier.add(smallestHeurist);
			
		}
		return false;
	
	
	}

	int heuristic(int o1){
		return (int)(Math.sqrt(o1*o1));
	}

	
	
}

 class HeuristicComparator implements Comparator<Integer>{
	
	static int heuristic(int o1){
		return (int) (Math.sqrt(o1*o1-100));
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return Integer.compare(heuristic((int)o1), heuristic((int)o2));
	}
	
	
}
