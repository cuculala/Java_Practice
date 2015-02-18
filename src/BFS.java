import java.util.ArrayList;
import java.util.Stack;


public class BFS {
	
	boolean bfsSearch(Graph g, ArrayList<Integer> start, int key){
		
		Queue que = new Queue();
		int startNode = start.get(0);
		que.insert(startNode);
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(start.get(0));
		
		while(que.getSize()>0){
			int firstNode = (int) que.get();
			//Here if found return
			if (firstNode == key) return true;
			ArrayList<Integer> temp = g.adjMatrix.get(firstNode);
			for(int nodes:temp){
				if(!visited.contains(nodes)){
					visited.add(nodes);
					que.insert(nodes);					
				}
			}
		}
		
		
		return false;
		
	}
	
	boolean dfsSearch(Graph g, ArrayList<Integer> start, int key){
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int startNode = start.get(0);
		stack.add(startNode);
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		
		while(stack.size()>0){
			int currentNode = stack.pop();
			if (currentNode == key) return true;
			if (!visited.contains(currentNode)){
				visited.add(currentNode);
				
			for(int node:g.adjMatrix.get(currentNode)){
				stack.push(node);
			}
			}
			
		}
		return false;
	}
	
}


	


class Graph{
	
	
	int V;
	int E;
	ArrayList<ArrayList<Integer>> adjMatrix;
	
	Graph(int v){
		this.V = v;
		this.E = 0;
		adjMatrix = new ArrayList<ArrayList<Integer>>();
		for(int i =0; i < V ; i++)
			adjMatrix.add(new ArrayList<Integer>());		
	}
}




