package mayzel.paint;

import javax.swing.JButton;

public class ModeButton extends JButton {

	private BrushListener listener;
	
	public ModeButton(BrushListener listener) {
		 this.listener = listener;
	}
	
	public BrushListener getListener(){
		return listener;
	}

}

