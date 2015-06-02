package mayzel.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class BrushListener implements MouseListener, MouseMotionListener{

	protected int startX;
	protected int startY;
	protected int lastX;
	protected int lastY;
	private Graphics g;
	private Canvas canvas;
	
	public BrushListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		lastX = event.getX();
		lastY = event.getY();
		canvas.repaint();
	}
	
	@Override
	public void mousePressed(MouseEvent event) {
		startX = event.getX();
		startY = event.getY();
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		Graphics g = canvas.getImage().getGraphics();
		g.setColor(canvas.getColor());
		BrushListener l = canvas.getBrushListener();
		l.draw(g);
	}
	
	abstract public void draw(Graphics g);

	@Override
	public void mouseMoved(MouseEvent event) {}
	@Override
	public void mouseClicked(MouseEvent event) {}
	@Override
	public void mouseEntered(MouseEvent event) {}
	@Override
	public void mouseExited(MouseEvent event) {}
}
