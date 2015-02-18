package ai.toyGames;

public class ManhattanHeuristic {

	int h(Object state){
		
		EightPuzzleBoard b = (EightPuzzleBoard) state;
		int retval = 0;
		for(int i =0 ; i < 9;i++){
			Point p = b.getPointofValue(i);
			retval += evaluation(p, i);
		}
		return retval;
	}
	
	int evaluation(Point p, int v){
		int x = p.x;
		int y = p.y;
		
		int retval = -1;
		switch(v){
			case 1:
				retval = Math.abs(x - 0) + Math.abs( y - 0 );
			case 2:
				retval = Math.abs(x - 0) + Math.abs(y - 1);
			case 3:
				retval = Math.abs(x - 0 ) + Math.abs( y - 2);
			case 4:
				retval = Math.abs(x - 1 ) + Math.abs(y - 0);
			case 5:
				retval = Math.abs(x - 1) + Math.abs(y - 1);
			case 6:
				retval = Math.abs(x - 1 ) + Math.abs(y - 2);
			case 7:
				retval = Math.abs(x - 2) + Math.abs( y - 0);
			case 8:
				retval = Math.abs(x - 2) + Math.abs(y - 1);
			case 0:
				retval = Math.abs(x - 2) + Math.abs(y - 2);
				
		}
		return retval;
	}
}
