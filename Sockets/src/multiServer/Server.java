package multiServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	 public static final int PORT = 8082;//puerto para el servidor
	    public static void main(String[] args) throws IOException {
	        ServerSocket server = new ServerSocket(PORT,10);//creamos serverSocket
	        System.out.println("Server started: " + server);//mostramos info
	        while (true) {
	            Socket socket = server.accept();//aceptamos conexión de cliente
	            //mostramos al cliente
	            System.out.println("Connection accepted: " + socket);
	            try {
	                new ClientHandler(socket);
	                //cerramos conexiones
	            } catch(Exception e) {
	                if (socket != null) {
	                    socket.close();
	                }
	            }
	        }
	    }
	}
