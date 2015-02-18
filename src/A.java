import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class A {
	
	Map<Node, Double> visited = new HashMap<Node,Double>();
	Map<Node, Node> came_from = new HashMap<Node,Node>();
	Node  start;
	
	List<Node> printpath (Node goal){
		List<Node> path = new ArrayList<Node>();
		Node current = goal;
		path.add(current);
		
		while (current!= start){
			System.out.println(current.nodeName + " ==>> ");
			current = came_from.get(current);	
			path.add(current);
		}
		return path;
	}
	
	boolean AstarSearch(Node start, Node goal){
		this.start = start;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(20, new Comparator<Node>(){

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.f_score < o2.f_score)
					return -1;
				else if(o1.f_score > o2.f_score)
					return 1;
				else
					return 0;
			}
	
		});
		
		start.setgScore(0.0);
		frontier.add(start);
		visited.put(start, 0.0);
		
		while(!frontier.isEmpty()){
			Node current = frontier.poll();
			
			if(current.nodeName == goal.nodeName)
				return true;
			for(Edge e: current.edges){
				Node neighbour = e.target;
				double stepCost = e.cost;
				double costSoFar = current.g_score + stepCost;
				double evaluationFunction = costSoFar + neighbour.h_score;
				
				if(!visited.containsKey(neighbour)|| evaluationFunction < visited.get(neighbour)){
					
					visited.put(neighbour, evaluationFunction);
					neighbour.setgScore(costSoFar);
					neighbour.setfScore(evaluationFunction);
					if(visited.containsKey(neighbour))
						frontier.remove(neighbour);//if already existing neighbour, replaces with new evaluation function
					frontier.add(neighbour);
				}
			}
			
		}
		return false;
	}
	
}

class Node {
	
	String nodeName;
	double g_score;
	double f_score;
	final double h_score;
	Node parent;
	ArrayList<Edge> edges;
	
	Node(String name, double h){
		h_score = h;
		nodeName = name;
	}
	void setgScore(double g){
		g_score = g;
	}
	void setfScore(double f){
		f_score = f;
	}
}


class Edge {
	Node target;
	double cost;
	//String relation;
	
	Edge(Node target, double cost){
		this.cost = cost;
		this.target =target;
		//relation = target.nodeName + ;
	}
	
}