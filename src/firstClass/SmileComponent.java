package firstClass;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	boolean wink = false;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(190, 80, 400, 400);
		g.setColor(Color.BLUE);
		g.fillOval(300, 150, 50, 50);
		g.setColor(Color.WHITE);
		g.fillOval(330, 180, 15, 15);
		if (!wink) {
			g.setColor(Color.BLUE);
			g.fillOval(430, 150, 50, 50);
			g.setColor(Color.WHITE);
			g.fillOval(460, 180, 15, 15);
			wink = true;
		} else {
			g.setColor(Color.YELLOW);
			g.fillOval(430, 150, 50, 50);
			g.setColor(Color.BLUE);
			g.drawArc(430, 165, 60, 50, 35, 130);
			wink = false;
		}
		g.setColor(Color.RED);
		g.fillArc(290, 250, 200, 170, 0, -180);
	}

}
