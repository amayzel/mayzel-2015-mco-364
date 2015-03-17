package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(3761);

			SocketThread t;
			while (true){
				Socket s = serverSocket.accept();
				t = new SocketThread(s);
				t.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
