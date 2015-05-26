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

	private Canvas canvas;
	private ModeButton pencilButton;
	private ModeButton rectangleButton;
	private JButton [][] colorButtons;
	private Color color = Color.BLACK;
	public PaintFrame() {

		setSize(800, 600);
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		canvas = new Canvas(600, 600);
		add(canvas, BorderLayout.CENTER);

		Container colors = new Container();
		add(colors, BorderLayout.EAST);
		colors.setLayout(new GridLayout(12, 1));
		colorButtons = new JButton[12][1];
		Color colorArray[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
				new Color(153, 51, 255), Color.PINK, Color.MAGENTA, Color.BLACK, Color.GRAY, Color.WHITE };

		ActionListener colorListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				for (int i = 0; i < colorButtons.length; i++) {
					for (int j = 0; j < colorButtons[i].length; j++) {
						if (event.getSource().equals(colorButtons[i][j])) {
							color = colorButtons[i][j].getBackground();
							canvas.setColor(color);
						}
					}
				}
			}
		};

		for (int i = 0; i < colorButtons.length; i++) {
			for (int j = 0; j < colorButtons[i].length; j++) {
				colorButtons[i][j] = new JButton();
				colorButtons[i][j].setBackground(colorArray[i]);
				colorButtons[i][j].addActionListener(colorListener);
				colors.add(colorButtons[i][j]);

			}
		}

		Container shapes = new Container();
		add(shapes, BorderLayout.NORTH);
		shapes.setLayout(new GridLayout(1, 2));
		
		pencilButton = new ModeButton(new PencilListener(canvas));
		rectangleButton = new ModeButton(new RectangleListener(canvas));
		
		ActionListener drawListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ModeButton button = (ModeButton) e.getSource();
				BrushListener listener = button.getListener();
				canvas.setBrushListener(listener);
				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);
			}
		};
		
		pencilButton.addActionListener(drawListener);
		rectangleButton.addActionListener(drawListener);
		
		pencilButton.setBackground(Color.WHITE);
		pencilButton.setIcon(new ImageIcon("pencil.jpg"));
		shapes.add(pencilButton);
		
		rectangleButton.setBackground(Color.WHITE);
		rectangleButton.setIcon(new ImageIcon("rect.jpg"));
		shapes.add(rectangleButton);
		
	}

	public static void main(String[] args) {
		new PaintFrame().setVisible(true);
	}

}
