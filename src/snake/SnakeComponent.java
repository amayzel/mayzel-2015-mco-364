package snake;

import java.awt.Graphics;

import javax.swing.JComponent;

public class SnakeComponent  extends JComponent {
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//dont hardcode it- generalize to component size (so resizable)
		g.drawLine(10, 10, 590, 10); 
		g.drawLine(10, 10, 10, 590);
		g.drawLine(590, 590, 10, 590);
		g.drawLine(590, 590, 590, 10);
	}
	

}
