package mayzel.smile;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Timer;

import javax.swing.JFrame;

public class Smile extends JFrame  {

	public Smile() {
		setSize(800,600);
		setTitle("SMILE :)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(new SmileComponent(),BorderLayout.CENTER);
		
	}
	
	public static void main(String []args){
		final Smile s = new Smile();
		s.setVisible(true);
		
		//animation thread
		Thread t = new Thread(){
			public void run(){
				while(true){
					s.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t.start();
	}

}
