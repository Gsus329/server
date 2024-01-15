package example;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String [] args) {
		try {
			ServerSocket server=new ServerSocket(0);
			System.out.println("Server started: "+server);
			
			server.close();
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
