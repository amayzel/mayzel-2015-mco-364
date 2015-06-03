package mayzel.physics;

import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class PhysicsFrame extends JFrame{

	public PhysicsFrame() {
		setSize(400, 400);
		setTitle("Physics Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		final Body body = new Body(new Force(0, 0), new Point2D.Double(0, 0));
		Force point = body.getForce();
		PhysicsCanvas canvas = new PhysicsCanvas(point);
		add(canvas);
		Thread t = new Thread() {

			public void run() {
				while (true) {
					body.getForce().add(new Force(0, 9.8));
					body.update();
					repaint();
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		t.start();

		
	}
	
	public static void main(String[] args){
		new PhysicsFrame().setVisible(true);
	}

}
