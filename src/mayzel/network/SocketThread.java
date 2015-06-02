package mayzel.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketThread extends Thread {
	private Socket s;
	public SocketThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			InputStream in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}