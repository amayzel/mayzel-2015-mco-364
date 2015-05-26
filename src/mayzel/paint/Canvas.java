package mayzel.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private BufferedImage image;
	private Color color = Color.BLACK;
	private BrushListener listener = new PencilListener(this);
	
	public Canvas(int width, int height) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, width, height);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.setColor(color);
		graphics.drawImage(image, 0, 0, null);
		if(listener !=null){
			listener.draw(graphics);
		}
	}
	
	public BufferedImage getImage(){
		return image;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setBrushListener(BrushListener listener) {
		this.listener = listener;
	}


}
