package multicliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import multiServer.Server;

public class Cliente {
    public static void main(String [] args) throws IOException{
        Socket socket=null;
       try{
            //creamos dirección de nuestro cliente
            InetAddress addr=InetAddress.getByName(null);//con null localhost
            System.out.println("addr: "+addr);//mostramos
            socket= new Socket(addr, Server.PORT);//creamos socket cliente
            System.out.println("Socket: "+socket);//mostramos
           //flujo de entrada al socket
            BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //flujo de salida del socket
            PrintWriter output=new PrintWriter(new BufferedWriter((new OutputStreamWriter(socket.getOutputStream()))),true);
            for(int i=0;i<10;i++){
                output.println(i);
                String st=input.readLine();
                System.out.println(st);
            }
            output.println("END");
        }finally {
            System.out.println("Clossing...");
            socket.close();
        }
    }
}
