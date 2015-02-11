package snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Snake extends JFrame implements KeyListener {

	public Snake() {
		setSize(620,640);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		SnakeComponent sc = new SnakeComponent();
		contentPane.add(sc,BorderLayout.CENTER);
		sc.addKeyListener(this);
		sc.setFocusable(true);
		
	
	}

	public static void main(String[] args) {
		final Snake s = new Snake();
		s.setVisible(true);
		
		//game thread temporarily here really should be in a sep class
		Thread t = new Thread(){
			public void run(){
				while(true){
					s.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//4 or LEFT arrow then turn to the left
		//6 or Right Arrow then turn to the right
		//System.out.println("Key Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
			
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
