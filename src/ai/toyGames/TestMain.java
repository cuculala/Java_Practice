package ai.toyGames;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TestMain {

	public static void main(String []args){
		EightPuzzleBoard board = new EightPuzzleBoard();
		int [] goalState = {1,2,3,4,5,6,7,8,0};
		EightPuzzleBoard goal  =new EightPuzzleBoard(goalState);
		PriorityQueue<EightPuzzleBoard> frontier = new PriorityQueue<EightPuzzleBoard>(10,new Comparator<EightPuzzleBoard>(){
			@Override
			public int compare(EightPuzzleBoard o1, EightPuzzleBoard o2) {
				if (o1.h>o2.h)
					return o1.h;
				if(o2.h>o1.h)
					return o2.h;
				return o1.h;
			}
		});
		
		Action [] actions = new Action[4];
		
		actions[0]= new Action("DOWN");
		actions[1]= new Action("RIGHT");
		actions[2] =new Action("LEFT");
		actions[3] =new Action("UP");
		for(int i = 0; i< 3;i++)
			System.out.println(actions[i].name.equals(actions[i+1].name));
		
		List<EightPuzzleBoard> visited = new ArrayList<EightPuzzleBoard>();
		frontier.add(board);
		
		while(!frontier.isEmpty()){
			EightPuzzleBoard current = frontier.poll();
			if (current.equals(goal)){
				current.displayBoard();
				return;
			}
			current.displayBoard();
			for(int i =0 ; i< actions.length;i++){
				Action a = actions[i];
				System.out.println(a.name);
				if (current.IsBlankMoveable(a)){
					current.moveBlank(a);
					System.out.print(current.displayBoard());
					
					if(!visited.contains(current)){
						visited.add(current);
						frontier.add(current);						
					}
				}
			}
		}

	}
}
