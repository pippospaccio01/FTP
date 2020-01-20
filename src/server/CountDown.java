package server;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CountDown extends Thread{
    @Override
    public void run(){
        for(int c=5000;c!=0;c-=1000){
            try {
                System.out.println(c);
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
