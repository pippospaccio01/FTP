package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Server {
    public static void main(String[] args) {
        

        int port=2000;
        ServerSocket sSocket = null;  
        Socket connection;
        while(true){
            try{              
                sSocket = new ServerSocket(port);
                System.out.println("In attesa di connessioni con il client!");
                sSocket.setSoTimeout(5000);
                CountDown cd =new CountDown ();
                cd.start();
                connection = sSocket.accept();
                System.out.println("Connessione stabilita!");
                System.out.println("Socket server: " + connection.getLocalSocketAddress());
                System.out.println("Socket client: " + connection.getRemoteSocketAddress());
            }
               catch(SocketTimeoutException e){
                   System.err.println("Server Chiuso");
               }
               catch(IOException e){
                   System.err.println("Errore di I/O!");
            }
            try {
                if (sSocket!=null) sSocket.close();
            } catch (IOException ex) {
                System.err.println("Errore nella chiusura della connessione!");
            }
            System.out.println("Connessione chiusa!");
        }
      }
}