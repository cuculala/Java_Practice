package ai.toyGames;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestClass {

	EightPuzzleBoard board; 
	 
	Point gapPoint;
	ManhattanHeuristic heu;
	int h;
	
			
	public TestClass(int[] b) {
		board = new EightPuzzleBoard(b);
		
		heu = new ManhattanHeuristic();
		gapPoint = board.getLocationof(0);
		h = heu.h(board);
	}
	public TestClass(EightPuzzleBoard b){
		board = b;
		
		heu = new ManhattanHeuristic();
		gapPoint = board.getLocationof(0);
		h = heu.h(board);
	}
	EightPuzzleBoard getboard(){
		return board;
	}
	public static void main(String []args){
		
		int []Initialstate = {1,2,3,4,5,6,7,8,0};
		int [] goalState = {1,2,3,4,5,6,7,8,0};
		List<Action> actions = new ArrayList<Action>();
		
		actions.add(new Action("DOWN"));
		actions.add(new Action("RIGHT"));
		actions.add(new Action("LEFT"));
		actions.add(new Action("UP"));
		
		PriorityQueue<TestClass> frontier = new PriorityQueue<TestClass>(10,new Comparator<TestClass>(){

			@Override
			public int compare(TestClass o1, TestClass o2) {
				
				if (o1.h > o2.h)
					return o1.h;
				else if(o2.h > o1.h)
					return o2.h;
				return o1.h;
					
			}
		});
		
		List<EightPuzzleBoard> visited = new ArrayList<EightPuzzleBoard>();
		
		TestClass newgame = new TestClass(Initialstate);
		TestClass goal = new TestClass(goalState);
		frontier.add(newgame);
		while(!frontier.isEmpty()){
			TestClass current = frontier.poll();
			visited.contains(current.getboard());
			EightPuzzleBoard temp = current.getboard();
			
			if (current.board.equals(goal.board))
				return;
			for(Action a: actions){
				if( temp.IsBlankMoveable(a) )
					//temp.moveBlank(a);
				if(!visited.contains(temp)){
						
					}
			}	
						
				}	
					
			}
			
		}

