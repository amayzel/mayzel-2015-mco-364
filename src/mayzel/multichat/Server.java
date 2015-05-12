package mayzel.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import network.SocketThread;

public class Server{

	public Server() {
		try {
			ArrayList<Socket> socketList = new ArrayList<Socket>();
			LinkedBlockingQueue<String> threadList = new LinkedBlockingQueue<String>();
			ServerSocket serverSocket = new ServerSocket(4433);
			String t;
			WriterThread writerThread = new WriterThread(threadList, socketList);
			while (true){
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				ReaderThread rt = new ReaderThread(socket, null);
				//String message = null;
				//t = message;
				//threadList.add(t);
				//t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server server = new Server();
	}

}
