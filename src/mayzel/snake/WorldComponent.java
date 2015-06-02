package mayzel.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JComponent;

public class WorldComponent  extends JComponent {
	
	private World world;
	public WorldComponent(World world){
		this.world = world;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		world.drawBoard(g);
		world.drawSnake(g);
		world.drawFood(g);
	}
	
	
}
