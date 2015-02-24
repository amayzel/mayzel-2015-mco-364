package snake;

public class GameLoopThread extends Thread {

	private WorldComponent wc;
	public GameLoopThread(WorldComponent wc) {
		this.wc = wc;
	}

	public void run(){
		while(true){
			update();
			wc.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void update() {
		//fill in soon
	}
}
