package server;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
//ejemplo de servidor no-multihilo
public class Server {
    public static final int PORT=8080;//puerto para el servidor
    public static void main(String [] args) throws IOException{
        ServerSocket server=null;
        Socket socket=null;
        try {
            server=new ServerSocket(PORT);//creamos serverSocket
            System.out.println("Server started: "+server);//mostramos info
            socket =server.accept();//aceptamos conexión de cliente
            System.out.println("Connection accepted: "+socket);//mostramos al cliente
            //iniciamos flujo de entrada para coger info del cliente
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //iniciamos buffer salida para enviar información, en este caso por pantalla
            PrintWriter output;
            output=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            String st="";
            while(!st.equals("END")){//mientras no envíe END el cliente, sigue mostrando info
                st= input.readLine();
                System.out.println("Printing input: "+st);
                output.println(st);
            }
        //cerramos conexiones
        } finally {
            System.out.println("Closing...");
            if (server != null) {
                server.close();
            }
            if (socket != null) {
                socket.close();
            }
        }


    }
}