package mayzel.physics;

public class Force {
	
	private double x;
	private double y;
	public Force(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Force force){
		this.x += force.getX();
		this.y += force.getY();

	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	

}
