package ai.toyGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightPuzzleBoard extends ManhattanHeuristic {
	
	public static final Action UP = new Action("UP");
	public static final Action DOWN = new Action("DOWN");
	public static final Action LEFT = new Action("LEFT");
	public static final Action RIGHT = new Action("RIGHT");
	int h;
	private int[] state; 
	
	EightPuzzleBoard(){
		state = new int[]{1,3,4,2,0,8,7,6,5};
		System.out.print(displayBoard() );
		h = h(this);
	}
	
	EightPuzzleBoard(int [] b){
		state  = new int [b.length];
		System.arraycopy(b, 0, state, 0, b.length);
	}
	
	public int getValueat(Point p){
		return getValueat(p.x,p.y);
	}
	
	Point getPointofValue(int val){
		int index = getIndexof(val);
		return new Point(getX(index),getY(index));
	}
	public int getValueat(int x , int y ){
		return state[getIndexfromCoordinate(x, y)];
	}
	
	Point getLocationof(int val){
		int index = getIndexof( val);
		return new Point(getX(index),getY(index));
	}
	
	int getIndexof(int val){
		for(int i = 0 ; i<9; i++){
			if (state[i]==val){
				return i;
			}
		}
		return -1;
	}
	
	int getX(int index){
		return index/3;
	}
	int getY(int index){
		return index%3;
	}
	
	int getIndexfromCoordinate(int x, int y){
		return 3 * x + y;
	}
	
	int getIndexofBlank(){
		return getIndexof(0);
	}
	
	void setValue(int x, int y, int val){
		int index = getIndexfromCoordinate(x, y);
		state[index] = val;
		
	}
	
	void setValue(Point p, int val){
		setValue(p.x,p.y,val);
	}
	void swapValues(Point p1, Point p2, int val1, int val2){
		
		setValue(p1, val2);
		setValue(p2,val1);
		h = h(this);
		
	}
	
	public boolean equals(Object o){
		if (this==o)
			return true;
		if (o==null || (this.getClass() !=o.getClass()))
			return false;
		EightPuzzleBoard temp = (EightPuzzleBoard)o;
		
		for(int i = 0 ; i < 9; i++){
			if(this.getIndexof(i)!=temp.getIndexof(i))
				return false;
		}
		return true;
	}
	
	void moveBlankRight(){
		int indexBlank = getIndexof(0);
		int xBlank = getX(indexBlank);
		int yBlank = getY(indexBlank);
		
		if(yBlank!=2){
			Point p1  = new Point(xBlank,yBlank);
			Point p2 = new Point(xBlank, yBlank+1);
			swapValues(p1, p2, 0, getValueat(p2));
		}
	}
	
	void moveBlankLeft(){
		int indexBlank = getIndexof(0);
		int xBlank = getX(indexBlank);
		int yBlank = getY(indexBlank);
		
		if(yBlank!=0){
			Point p1  = new Point(xBlank,yBlank);
			Point p2 = new Point(xBlank, yBlank-1);
			swapValues(p1, p2, 0, getValueat(p2));
		}
	}
	
	void moveBlankDown(){
		int indexBlank = getIndexof(0);
		int xBlank = getX(indexBlank);
		int yBlank = getY(indexBlank);
		
		if(xBlank!=2){
			Point p1  = new Point(xBlank,yBlank);
			Point p2 = new Point(xBlank+1, yBlank);
			swapValues(p1, p2, 0, getValueat(p2));
		}
	}
	void moveBlankUp(){
		int indexBlank = getIndexof(0);
		int xBlank = getX(indexBlank);
		int yBlank = getY(indexBlank);
		
		if(xBlank!=0){
			Point p1  = new Point(xBlank,yBlank);
			Point p2 = new Point(xBlank-1, yBlank);
			swapValues(p1, p2, 0, getValueat(p2));
		}
	}
	
	
	List<Point> getAllCoordinates(){
		List<Point> allPoints = new ArrayList<Point>();
		for(int i = 0 ; i < 9;i++){
			int index = getIndexof(i);
			Point p = new Point(getX(index),getY(index));
			allPoints.add(p);
		}
		return allPoints;
	}
	
	public void setBoard(List<Point> allPoints){
		
		for(int i = 0; i < allPoints.size();i++){
			Point p  = allPoints.get(i);
			setValue(p.x, p.y, i);
		}
	}
	public void moveBlank(Action move){
		if(move.name.equals(LEFT.name)){
			moveBlankLeft();
		}
		else if(move.name.equals(RIGHT.name)){
			moveBlankRight();
		}
		else if (move.name.equals(UP.name)){
			moveBlankUp();
		}else if (move.name.equals(DOWN.name)){
			moveBlankDown();
		}
	}
	
	public boolean IsBlankMoveable(Action move){
		boolean no = false;
		Point blankPoint = getPointofValue(0);
		if(move.name.equals(LEFT.name)){
			System.out.println("Left Moveable");
			return (blankPoint.y!=0);
		}
		else if(move.name.equals(RIGHT.name)){
			return (blankPoint.y!=2);
		}
		else if (move.name.equals(UP.name)){
			System.out.println("UP Moveable");
			return (blankPoint.x!=0);
		}else if (move.name.equals(DOWN.name)){
			return (blankPoint.x!=2);
		}
		
		return no;
	}
	
	public String displayBoard(){
		String board = state[0]+" "+state[1]+" "+state[2]+"\n"
				+state[3]+" "+state[4]+" "+state[5]+"\n"
				+state[6]+" "+state[7]+" "+state[8]+"\n";
		return board;
	}
}

class Point{
	int x,y;
	
	Point(int a, int b){
		x = a; y = b;
	}
	
	int getx(){
		return x;
	}
	int gety(){
		return y;
	}
	
	public String toString (){
		return String.format("(%d, %d)", x,y);
	}
}

class Action {
	public static  String name;
	
	public Action(String name){
		this.name = name;
	}
}