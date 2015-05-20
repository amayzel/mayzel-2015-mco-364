package mayzel.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private ModeButton pencilButton;
	private ModeButton rectangleButton;
	public PaintFrame() {

		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		final Canvas canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

		String typeChoice= "rect.jpg";

		// default is black
		BrushListener listener = new DrawListener(canvas/*, Color.BLACK, typeChoice*/);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);

		// Picking a color
		Container colors = new Container();
		add(colors, BorderLayout.EAST);
		colors.setLayout(new GridLayout(12, 1));

		final JButton colorButtons[][] = new JButton[12][1];
		Color colorArray[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
				new Color(153, 51, 255), Color.PINK, Color.MAGENTA, Color.BLACK, Color.GRAY, Color.WHITE };

		ChooseColorListener cclistener = new ChooseColorListener(canvas, colorButtons, typeChoice, listener);

		for (int i = 0; i < colorButtons.length; i++) {
			for (int j = 0; j < colorButtons[i].length; j++) {
				colorButtons[i][j] = new JButton();
				colorButtons[i][j].setBackground(colorArray[i]);
				colorButtons[i][j].addActionListener(cclistener);
				colors.add(colorButtons[i][j]);

			}
		}

		// Picking a draw type
		Container shapes = new Container();
		add(shapes, BorderLayout.NORTH);
		shapes.setLayout(new GridLayout(1, 2));

		JButton[][] drawType = new JButton[2][1];
		String imageNames[] = { "pencil.jpg", "rect.jpg"};

		for (int i = 0; i < drawType.length; i++) {
			for (int j = 0; j < drawType[i].length; j++) {
				typeChoice = imageNames[i];
				drawType[i][j] = new JButton();
				drawType[i][j].setBackground(Color.WHITE);
				drawType[i][j].setIcon(new ImageIcon(imageNames[i]));
				drawType[i][j].addActionListener(cclistener);
				shapes.add(drawType[i][j]);
			}
		}

	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
