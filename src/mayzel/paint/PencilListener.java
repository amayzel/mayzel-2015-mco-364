package mayzel.paint;

import java.awt.Graphics;

public class PencilListener extends BrushListener {


	private Canvas canvas;
	public PencilListener(Canvas canvas) {
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void draw(Graphics g) {
		Graphics graphics = canvas.getImage().getGraphics();
		graphics.setColor(canvas.getColor());
		graphics.drawLine(startX, startY, lastX, lastY);
		startX = lastX;
		startY = lastY;
	}

}
