package mayzel.network;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrameClient extends JFrame {

	private JButton button;
	private JTextArea area;
	private JTextField feild;

	public ChatFrameClient() {
		setSize(400, 400);
		setTitle("MyClientChat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLocationRelativeTo(null);

		Container cont = getContentPane();
		BorderLayout layout = new BorderLayout();
		cont.setLayout(layout);

		button = new JButton("SEND");
		cont.add(button, BorderLayout.NORTH);

		area = new JTextArea();
		area.setBackground(Color.lightGray);
		cont.add(area, BorderLayout.CENTER);

		feild = new JTextField();
		cont.add(feild, BorderLayout.SOUTH);

		ChatClient client = new ChatClient();
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (event.getSource().equals(button)) {
					area.insert(feild.getText(), 0);
				}
			}
		};
	button.addActionListener(listener);
	}

	public static void main(String[] args) {
		ChatFrameClient chat = new ChatFrameClient();
		chat.setVisible(true);

	}

}
