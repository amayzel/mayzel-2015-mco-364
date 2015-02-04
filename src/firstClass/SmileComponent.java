package firstClass;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(190, 80, 400, 400);
		g.setColor(Color.BLUE);
		g.fillOval(300, 150, 50, 50);
		g.fillOval(450, 150, 50, 50);
		g.setColor(Color.RED);
		g.drawArc(290, 250, 200, 170, 0, -180);
		
	}



}
