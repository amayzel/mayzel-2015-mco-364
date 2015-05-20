package mayzel.paint;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class DrawListener extends BrushListener {
	
	public DrawListener(Canvas canvas) {
		super(canvas);
	}
		

	@Override
	public void draw(Graphics g) {
		g.drawRect(startX, startY, lastX-startX, lastY-startY);
	}

	/*private Canvas canvas;
	private Color color;
	private String choice;
	private int lastX;
	private int lastY;

	public DrawListener(Canvas canvas, Color color, String choice) {
		this.canvas = canvas;
		this.color = color;
		this.choice = choice;
	}

	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		graphics.drawLine(x, y, x, y);
		lastX = x;
		lastY = y;
		
		//canvas.repaint();

	}

	@Override
	public void mouseReleased(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		
		Graphics graphic = canvas.getGraphics();
		//graphic.drawRect(lastX, lastY, x-lastX, y-lastY);
		graphic.drawLine(lastX, lastY, lastX, y);
		graphic.drawLine(lastX, lastY, x, lastY);
		graphic.drawLine(lastX, y, x, y);
		graphic.drawLine(x, lastY, x, y);
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();

		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(color);
		if (choice.equals("pencil.jpg")) {
			graphics.drawLine(lastX, lastY, x, y);
			lastX = x;
			lastY = y;
		} else if (choice.equals("rect.jpg")) {
			Graphics graphic = canvas.getGraphics();
			//graphic.drawRect(lastX, lastY, x-lastX, y-lastY);
			graphic.drawLine(lastX, lastY, lastX, y);
			graphic.drawLine(lastX, lastY, x, lastY);
			graphic.drawLine(lastX, y, x, y);
			graphic.drawLine(x, lastY, x, y);
			graphic.setColor(Color.white);
			/*if (lastX < x && lastY < y) {// right down
				graphic.fillRect(lastX + 1, lastY + 1, x - lastX - 1, y - lastY - 1);
			} else if (lastX > x && lastY > y) {// left up
				graphic.fillRect(x + 1, y + 1, lastX - x - 1, lastY - y - 1);
			} else if (lastX < x && lastY > y) {// right up
				graphic.fillRect(lastX + 1, y + 1, x - lastX - 1, lastY - y - 1);
			} else if (lastX > x && lastY < y) {// left down
				graphic.fillRect(x + 1, lastY + 1,  lastX -x - 1 , y - lastY - 1);
			}*/
/*}
canvas.repaint();

}*/	

}
