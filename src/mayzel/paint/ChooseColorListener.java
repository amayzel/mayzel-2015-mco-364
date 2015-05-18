package mayzel.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChooseColorListener implements ActionListener {

	private Canvas canvas;
	private JButton[][] colorButtons;
	private String typeChoice;
	
	public ChooseColorListener(Canvas canvas, JButton [][] colorButtons, String typeChoice) {
		this.canvas = canvas;
		this.colorButtons = colorButtons;
		this.typeChoice = typeChoice;
	}
	
	
		@Override
		public void actionPerformed(ActionEvent event) {
			for (int i = 0; i < colorButtons.length; i++) {
				for (int j = 0; j < colorButtons[i].length; j++) {
					if (event.getSource().equals(colorButtons[i][j])) {
						DrawListener listener = new DrawListener(canvas, colorButtons[i][j].getBackground(), typeChoice);
						canvas.addMouseListener(listener);
						canvas.addMouseMotionListener(listener);
						
					}
				}
			}

		}


}
