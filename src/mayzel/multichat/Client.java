package mayzel.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame{

	public Client() {
		setSize(400, 400);
		setTitle("ChatRoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container chatFrame = getContentPane();
		chatFrame.setLayout(new BorderLayout());
		JTextArea chatArea = new JTextArea();
		chatArea.setBackground(Color.LIGHT_GRAY);
		chatFrame.add(chatArea, BorderLayout.CENTER);
		Container top = new Container();
		top.setLayout(new BorderLayout());
		chatFrame.add(top, BorderLayout.NORTH);
		final JTextField mychat = new JTextField();
		top.add(mychat, BorderLayout.CENTER);
		final JButton button = new JButton("SEND");
		top.add(button, BorderLayout.EAST);
		button.setBackground(Color.CYAN);
		
		try {
			Socket socket = new Socket("localhost", 4433);
			final ReaderListener listener = null;
			ReaderThread reader = new ReaderThread(socket,listener);
			ActionListener buttonListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
							if (event.getSource().equals(button)) {
								listener.onLineRead(mychat.getText());
								mychat.setText("");
							}
				}
			};
			
			button.addActionListener(buttonListener);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args){
		Client chat = new Client();
		chat.setVisible(true);
	}
}
