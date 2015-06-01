package mayzel.physics;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class PhysicsCanvas extends JPanel{

	private Force point;
	public PhysicsCanvas(Force point) {
		this.point = point;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.translate(200,200);
		graphics.drawOval((int)point.getX(),(int)point.getY(),4 ,4);
	}

}
