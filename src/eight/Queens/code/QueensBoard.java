package eight.Queens.code;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class QueensBoard {

	private static final boolean True = false;
	int [][] queenBoard;
	int numQueens;
	int totalQueensAttacked;
	
	int ObjectiveValue;
	public QueensBoard(int EightQueen){
		int size = EightQueen;
		queenBoard = new int[size][size];
		numQueens = 0;
		ObjectiveValue =0 ;
	}
	
	public void setQueen(int x, int y){
		queenBoard[x][y] = 1;
		numQueens++;
		setObjectiveValue();
	}
	
	void removeQueen(int x, int y){
		queenBoard[x][y]=0;
		numQueens--;
		setObjectiveValue();
	}
	public void setQueen(Point p){
		setQueen(p.x, p.y);
	}
	
	int getValueAt(Point p){
		return queenBoard[p.x][p.y];
	}
	
	int getValueAt(int x, int y ){
		return queenBoard[x][y];
	}
	public void moveQueento(Point p ){
		for(int i = 0 ;i < 8 ; i++){
			removeQueen(i, p.y);
		}
		setQueen(p);
	}
	void removeQueen(Point p){
		if(getValueAt(p)==1)
			removeQueen(p.x, p.y);
			
	}
	public List<Point> AllqueenPoints(){
		List<Point> listQueens = new ArrayList<Point>();
		for(int i = 0; i < 8;i++){
			for(int  j = 0 ; j < 8;j++){
				if (getValueAt(i, j)==1){
					listQueens.add(new Point(i,j));
				}
			}
		}
		return listQueens;
	}
	public void setBoard(List<Point> queenPoints){
		for(int i = 0 ;i< queenPoints.size();i++){
			setQueen(queenPoints.get(i));
			
		}
	}
	
	public boolean isUnderAttack(Point queen, Point test){
		boolean yesNo = false;
		if(isHorizontalAttack(queen, test))
			yesNo = True;
		else if(isVerticalAttack(queen, test))
			yesNo = True;
		else if(isMajorDiagonalAttack(queen, test))
			yesNo = True;
		else if(isMinorDiagonalAttack(queen, test))
			yesNo = True;
		return yesNo;
		
	}
	
	public boolean isHorizontalAttack(Point queen, Point test){
		return queen.x == test.x;
	}
	
	public boolean isVerticalAttack(Point queen, Point test){
		return queen.y == test.y;
	}
	
	public boolean isMajorDiagonalAttack(Point queen, Point test){
		return queen.y-queen.x == test.y-test.x;
	}
	public boolean isMinorDiagonalAttack(Point queen, Point test){
		return queen.y+queen.x == test.y+test.x;
	}
	
	public boolean IsqueenAddableAt(Point p){
		List<Point> allqueens = AllqueenPoints();
		if (allqueens.isEmpty())
			return true;
		for(Point queen: allqueens ){
			if(isUnderAttack(queen, p))
				return false;
		}
		return true;
	}
	
	public boolean QueensSolved(){
		if (numQueens!=8)
			return false;
		List<Point> allqueens = AllqueenPoints();
		List<Point> others = allqueens;
		for(Point current: allqueens){
			
			others.remove(current);
			for(Point next: others){
				return isUnderAttack(next, current);
			}
		}
		
		return true;
	}
	
	public int numQueensAttacked(){
		if(numQueens==0)
			return -1;
		List<Point> allqueens = AllqueenPoints();
		List<Point> others = allqueens;
		int count = 0;
		for(Point current: allqueens){
			
			others.remove(current);
			for(Point next: others){
				 if(isUnderAttack(next, current));
				 count++;
				 
			}
		}
		return count;
	}
	
	void setObjectiveValue(){
		ObjectiveValue = 32 - numQueensAttacked();
	}
	int getObjectivefunction(){
		return ObjectiveValue;
	}
	
}
