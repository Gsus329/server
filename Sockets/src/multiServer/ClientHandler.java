package multiServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread{
	private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    public ClientHandler(Socket s) throws IOException {
        socket = s;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }
    @Override
    public void run(){
        String st="";
        try{
            while(!st.equals("END")){
                st=input.readLine();
                System.out.println("Doing echo: "+st);
                output.println(st);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }finally {
            try{
                socket.close();
            }catch (IOException ex){
                System.err.println("Socket not closed");
            }
        }
    }
 }
