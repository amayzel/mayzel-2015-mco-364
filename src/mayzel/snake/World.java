package mayzel.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JOptionPane;

public class World {

	private final int boxh = 15;
	private final int boxw = 15;
	private final int gridh = 25;
	private final int gridw = 25;
	
	private SnakeBody snake;
	private Food food;
	private int score;
	private int direction =  Direction.NO_DIRECTION;
	public World() {
		snake = new SnakeBody();
		generateDefaultSnake();
		food = new Food();
		placeFood();
	}

	public void generateDefaultSnake(){
		score = 0;
		snake.clear();

		snake.add(new Point(0,2));
		snake.add(new Point(0,1));
		snake.add(new Point(0,0));
	}

	public void placeFood(){
		Random num = new Random();
		int xRand = num.nextInt(gridw);
		int yRand = num.nextInt(gridh);
		Point random = new Point(xRand,yRand);
		while(snake.contains(random)){
			xRand = num.nextInt(gridw);
			yRand = num.nextInt(gridh);
			random = new Point(xRand,yRand);
		}
		food.setLocation(random);
	}
	
	private void move(int direction) {
		Point head = snake.peekFirst();
		Point newPt = head;
		switch(direction){
		case (Direction.NORTH):{
			newPt = new Point(head.x, head.y-1);
			break;
		}
		case (Direction.SOUTH):{
			newPt = new Point(head.x, head.y+1);
			break;
		}
		case (Direction.WEST):{
			newPt = new Point(head.x-1, head.y);
			break;
		}
		case (Direction.EAST):{
			newPt = new Point(head.x+1, head.y);
			break;
		}

		}

		snake.remove(snake.peekLast());

		if(newPt.equals(food)){
			Point addPt = (Point) newPt.clone(); 

			switch(direction){
			case (Direction.NORTH):{
				newPt = new Point(head.x, head.y-1);
				break;
			}
			case (Direction.SOUTH):{
				newPt = new Point(head.x, head.y+1);
				break;
			}
			case (Direction.WEST):{
				newPt = new Point(head.x-1, head.y);
				break;
			}
			case (Direction.EAST):{
				newPt = new Point(head.x+1, head.y);
				break;
			}

			}
			score++;
			snake.add(addPt);
			placeFood();

		}
		else if(newPt.x < 0 || newPt.x > gridw - 1){
			JOptionPane.showMessageDialog(null, "Sorry! You lost","Game Over!", JOptionPane.ERROR_MESSAGE);
			generateDefaultSnake();
			return;
		}
		else if(newPt.y < 0 || newPt.y > gridh - 1){
			JOptionPane.showMessageDialog(null, "Sorry! You lost","Game Over!", JOptionPane.ERROR_MESSAGE);
			generateDefaultSnake();
			return;
		}
		else if(snake.contains(newPt)){
			JOptionPane.showMessageDialog(null, "Sorry! You lost","Game Over!", JOptionPane.ERROR_MESSAGE);
			generateDefaultSnake();
			return;
		}

		snake.add(newPt);

	}

	
	public void drawBoard(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(10, 10, 580, 580);
	}

	public void drawSnake(Graphics g){
		g.setColor(Color.green);
		Point p;
		for(int i=0;i<snake.getSize();i++){
			p = snake.getPoint(i);
			g.fillRect(p.x*boxw, p.y*boxh, boxw, boxh);
		}
		g.setColor(Color.BLACK);
		
	}
	
	public void drawFood(Graphics g){
		g.setColor(Color.RED);
		g.fillOval(food.getX()*boxw, food.getY()*boxh, boxw, boxh);
		g.setColor(Color.BLACK);
	}


	
	
	

}
