package mayzel.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ChooseColorListener implements ActionListener {

	private Canvas canvas;
	private JButton[][] colorButtons;
	private String typeChoice;
	private BrushListener listener;
	
	public ChooseColorListener(Canvas canvas, JButton [][] colorButtons, String typeChoice, BrushListener listener) {
		this.canvas = canvas;
		this.colorButtons = colorButtons;
		this.typeChoice = typeChoice;
		this.listener = listener;
	}
	
	
		@Override
		public void actionPerformed(ActionEvent event) {
			for (int i = 0; i < colorButtons.length; i++) {
				for (int j = 0; j < colorButtons[i].length; j++) {
					if (event.getSource().equals(colorButtons[i][j])) {
						BrushListener listener = new DrawListener(canvas/*, colorButtons[i][j].getBackground(), typeChoice*/);
						//canvas.setBrushListener();
						canvas.addMouseListener(listener);
						canvas.addMouseMotionListener(listener);
						
					}
				}
			}

		}


}
