package mayzel.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread extends Thread {

	private LinkedBlockingQueue<String> threadList;
	private ArrayList<Socket> sockets;
	public WriterThread(LinkedBlockingQueue threadList, ArrayList sockets) {
		this.threadList = threadList;
		this.sockets = sockets;
	}
	
	public void run(){
		while(true){
			try {
				String message = threadList.take();
				writeToSocket(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void writeToSocket(String message){
		synchronized( sockets ) {
			Iterator<Socket> iter = sockets.iterator();
			while(iter.hasNext()){
				Socket s = iter.next();
				try{
					PrintWriter out = new PrintWriter(s.getOutputStream());
					out.println(message);
					out.flush();
				}
				catch(IOException e){
					iter.remove();
					e.printStackTrace();
				}
			}
		}
	}
}
