import java.util.ArrayList;
import java.util.Stack;


public class ID_DFS {

	boolean found  = false;
	int LIMIT = Integer.MAX_VALUE;

void IDDFS (Graph g, int goal, ArrayList<Integer> start){
	int count = 1;
	while(!found || count < LIMIT ){
		found  = DepthLimited(g, goal, start, count++);
	}
	System.out.println(count); 
}

	
boolean DepthLimited (Graph g, int goal, ArrayList<Integer> start, int maxDepth){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int startNode = start.get(0);
		stack.add(startNode);
		int depth = 0;
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		while(stack.size()>0 & depth <= maxDepth){
			
			
			int currentNode = stack.pop();
			if (currentNode == goal) return true;
			if (!visited.contains(currentNode)){
				visited.add(currentNode);
				
			for(int node:g.adjMatrix.get(currentNode)){
				stack.push(node);
			}
			
			}
			depth++;
			
		}
		
		return false;
		
	}
	
}


