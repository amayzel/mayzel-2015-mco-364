package mayzel.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mayzel.network.SocketThread;

public class Server implements ReaderListener{

	private LinkedBlockingQueue<String> messages;
	private ArrayList<Socket> socketList;
	public Server() {
		try {
			socketList = new ArrayList<Socket>();
			messages = new LinkedBlockingQueue<String>();
			ServerSocket serverSocket = new ServerSocket(4433);
			WriterThread writerThread = new WriterThread(messages, socketList);
			writerThread.start();
			while (true){
				Socket socket = serverSocket.accept();
				socketList.add(socket);
				ReaderThread rt = new ReaderThread(socket, this);
				rt.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Server server = new Server();
	}

	@Override
	public void onLineRead(String line) {
		messages.add(line);
		
	}

	@Override
	public void onCloseSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
