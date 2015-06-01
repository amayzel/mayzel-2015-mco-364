package mayzel.paint;

import java.awt.Graphics;

public class RectangleListener extends BrushListener {

	private Canvas canvas;

	public RectangleListener(Canvas canvas) {
		super(canvas);
		this.canvas = canvas;
	}

	@Override
	public void draw(Graphics graphic) {
			if (lastX > startX && lastY > startY) {// right down
				graphic.drawRect(startX, startY, lastX - startX, lastY - startY);
			} else if (lastX < startX && lastY < startY) {// left up
				graphic.drawRect(lastX, lastY, startX - lastX, startY - lastY);
			} else if (lastX > startX && lastY < startY) {// right up
				graphic.drawRect(startX, lastY, lastX - startX, startY - lastY);
			} else if (lastX < startX && lastY > startY) {// left down
				graphic.drawRect(lastX, startY, startX - lastX, lastY - startY);
			}
	}
}
