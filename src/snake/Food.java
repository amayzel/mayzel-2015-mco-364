package snake;

import java.awt.Point;

public class Food {

	private Point food;
	public Food() {
		food = new Point();
	}
	
	public void setLocation(int x, int y){
		food.setLocation(x, y);
	}
	
	public void setLocation(Point p){
		food.setLocation(p);
	}
	
	public int getX(){
		return food.x;
	}
	
	public int getY(){
		return food.y;
	}

}
