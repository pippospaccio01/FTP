package server;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ConnectException;
public class Client {
    public static void main(String[] args){    
        Socket connection = null;    
        String serverAddress = "localhost";     
        int port = 2000;
        try{
            connection = new Socket(serverAddress, port);
            System.out.println("Connessione aperta");
        }
        catch(ConnectException e){
            System.err.println("Server non disponibile!");
        }
        catch(UnknownHostException e1){
            System.err.println("Errore DNS!");
        }

        catch(IOException e2){
            System.err.println(e2);
            e2.printStackTrace();
        }
        finally{
                try {
            if (connection!=null)
                {
                    connection.close();
                    System.out.println("Connessione chiusa!");
                }
            }
            catch(IOException e){
                System.err.println("Errore nella chiusura della connessione!");
            }
        }
    }
}