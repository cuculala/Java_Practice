import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class UCS {

		int costSoFar, currentNode, startNode;
		PriorityQueue<Integer> frontier;
		Graph g;
		ArrayList<Integer> start;
		int key;
		
		UCS(Graph g,ArrayList<Integer> start, int key ){
			this.frontier = new PriorityQueue<Integer>(10, new CostComparator());
			this.start = start;
			this.key = key;
			costSoFar = 0;
		}
		
		boolean uniformCost (){
		

		startNode = start.get(0);
		costSoFar = 0;
		frontier.add(startNode);
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(startNode);
		int previousNodeCost=0;
		while(frontier.size()>0){
			
			currentNode = (int)frontier.poll();
			costSoFar = currentNode + previousNodeCost;
			if (currentNode == key) return true;
			
			ArrayList<Integer> temp = g.adjMatrix.get(currentNode);
			for(int nodes:temp){
				if(!visited.contains(nodes)){
					visited.add(nodes);
					frontier.add(nodes);					
				}
			}
			 previousNodeCost = currentNode;
			
		}
		
		
		return false;
		
	}
		
		int getCostSoFar(){
			return costSoFar;
		}
	
}

class CostComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		return Integer.compare((int)o1, (int)o2);
	}

	
}