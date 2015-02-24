package snake;

import java.awt.Point;
import java.util.LinkedList;

public class SnakeBody {

	private LinkedList<Point> snake;

	public SnakeBody() {
		snake = new LinkedList<Point>();
	}
	
	public void add(Point p){
		snake.add(p);
	}
	
	public Point peekFirst(){
		return snake.peekFirst();
	}
	
	public Point peekLast(){
		return snake.peekLast();
	}
	
	public void remove(Point p){
		snake.remove(p);
	}
	
	public void removeLast(){
		snake.removeLast();
	}
	
	public Point getPoint(int index){
		return snake.get(index);
	}
	
	public int getSize(){
		return snake.size();
	}
	
	public void clear(){
		snake.clear();
	}
	
	public boolean contains(Point p){
		return snake.contains(p);
	}
}
