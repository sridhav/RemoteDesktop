package rdpserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sridhar
 */
public class HandleClient implements Runnable{
    private Socket cli=null;
    private PrintWriter out=null;
    private BufferedReader in=null;
    Thread run;
   public HandleClient(Socket temp) throws IOException{
       // run=new Thread(this);
      //  run.start();
        cli=temp;
        out=new PrintWriter(cli.getOutputStream(),true);
        in=new BufferedReader(new InputStreamReader(cli.getInputStream()));
    }
   @Override 
   public void run() {
        while(true){
            try {
             //   System.out.println("In Thread Handle Client");
                String getval=in.readLine();
                int val=Integer.parseInt(getval);
                System.out.println(val);
                val=val+1;
                out.println(val);
            } catch (IOException ex) {
                Logger.getLogger(HandleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
