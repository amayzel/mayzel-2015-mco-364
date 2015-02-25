package snake;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class SnakeMain extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	private int direction;
	private World w;
	public SnakeMain() {
		setSize(620,640);
		setTitle("SNAKE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		w = new World();
		WorldComponent wc = new WorldComponent(w);
		contentPane.add(wc,BorderLayout.CENTER);
		wc.addKeyListener(this);
		wc.setFocusable(true);
		
		GameLoopThread gt = new GameLoopThread(wc);
		gt.start();
		
		
	}

	public static void main(String[] args) {
		final SnakeMain s = new SnakeMain();
		s.setVisible(true);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//4 or LEFT arrow then turn to the left
		//6 or Right Arrow then turn to the right
		//System.out.println("Key Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case (KeyEvent.VK_UP):{
			if(direction!=Direction.SOUTH){
				direction = Direction.NORTH;
			}
			break;
		}
		case (KeyEvent.VK_DOWN):{
			if(direction!=Direction.NORTH){
				direction = Direction.SOUTH;
			}
			break;
		}
		case (KeyEvent.VK_RIGHT):{
			if(direction!=Direction.WEST){
				direction = Direction.EAST;
			}
			break;
		}
		case (KeyEvent.VK_LEFT):{
			if(direction!=Direction.EAST){
				direction = Direction.WEST;
			}
			break;
		}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
