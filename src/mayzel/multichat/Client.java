package mayzel.multichat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ReaderListener, KeyListener{

	private JTextArea chatArea;
	private JTextField mychat;
	private JButton button;
	private JScrollPane scroller;
	private PrintWriter writer;
	public Client() {
		setSize(400, 400);
		setTitle("ChatRoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container chatFrame = getContentPane();
		chatFrame.setLayout(new BorderLayout());
		
		chatArea = new JTextArea();
		chatArea.setBackground(Color.LIGHT_GRAY);
		chatArea.setLineWrap(true);
		chatArea.setEditable(false);
		chatArea.add(new JScrollPane());
		
		chatFrame.add(chatArea, BorderLayout.CENTER);
		Container top = new Container();
		top.setLayout(new BorderLayout());
		chatFrame.add(top, BorderLayout.NORTH);
		mychat = new JTextField();
		top.add(mychat, BorderLayout.CENTER);
		mychat.addKeyListener(this);
		button = new JButton("SEND");
		top.add(button, BorderLayout.EAST);
		button.setBackground(Color.CYAN);
		
		scroller = new JScrollPane(chatArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatFrame.add(scroller, BorderLayout.CENTER);
		try {
			Socket socket = new Socket("localhost", 4433);
			OutputStream out = socket.getOutputStream();
			writer = new PrintWriter(out);
			ReaderThread t = new ReaderThread(socket, this);
			t.start();
			ActionListener buttonListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
							if (event.getSource().equals(button)) {
								writer.println(mychat.getText());
								writer.flush();
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
	
	@Override
	public void onLineRead(String line) {
			chatArea.append(line + "\n");
	}

	@Override
	public void onCloseSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER){
			writer.println(mychat.getText());
			writer.flush();
			mychat.setText("");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
	
	public static void main(String[] args) {
		Thread t = new Thread() {
			public void run() {
				Server server = new Server();
			}
		};
		t.start();
		
		for (int i = 0; i < 4; i++) {
			Thread thread = new Thread() {
				public void run() {

					Client client1 = new Client();
					client1.setVisible(true);
				}
			};

			thread.start();
		}
		

	}
		
}
