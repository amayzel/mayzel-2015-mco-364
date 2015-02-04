package firstClass;

import java.awt.BorderLayout;
import java.awt.Container;

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
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		t.start();
	}

}
