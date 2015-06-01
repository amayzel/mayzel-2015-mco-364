package mayzel.physics;

import java.awt.geom.Point2D;

public class PhysicsCommandLineMain {

	public static void main(String[] args) {
		Body body = new Body(new Force(0, 0), new Point2D.Double(0, 0));
		System.out.println(body.getPosition());
		for (int i = 0; i < 4; i++) {
			body.getForce().add(new Force(0, -9.8));
			body.update();
			System.out.println(body.getPosition());
		}

	}

}
