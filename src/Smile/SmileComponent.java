package Smile;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent {

	boolean wink = false;
	int width;
	int height;
	double x;
	boolean go = true;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		width = this.getWidth();
		height = this.getHeight();
		if(go){
			x = height *.18;
			go = false;
		}
		g.setColor(Color.YELLOW);
		g.fillOval((int) (width*.25), (int) (height*.15), (int) (width*.50), (int) (height*.70));
		g.setColor(Color.BLUE);
		g.fillOval((int) (width*.38), (int) (height*.27), (int) (width*.07), (int) (height*.09));
		g.setColor(Color.WHITE);
		g.fillOval((int) (width*.425), (int) (height*.32), (int) (width*.02), (int) (height*.027));
		g.setColor(Color.BLUE);
		g.fillOval((int) (width*.543), (int) (height*.27), (int) (width*.07), (int) (height*.09));
		g.setColor(Color.WHITE);
		g.fillOval((int) (width*.588), (int) (height*.32), (int) (width*.02), (int) (height*.027));			
		if(!wink){
				g.setColor(Color.YELLOW);
				g.fillOval((int) (width*.543), (int) x++, (int) (width*.07), (int) (height*.09));
			if(x >= height*.27){
				x = height*.18;
			}
			wink = false;
		}
		g.setColor(Color.RED);
		g.fillArc((int) (width*.38), (int) (height*.45), (int) (width*.25), (int) (height*.32), 0, -180);
	}

}
