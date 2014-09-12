/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Sridhar
 */
public class Client {
    private Socket cli=null;
    private PrintWriter out=null;
    private BufferedReader in=null;
    public Client() throws UnknownHostException, IOException{
        String host="localhost";
        int port=11111;
        cli=new Socket(host,port);
    }
    
    public void startClient() throws InterruptedException, IOException{
        out=new PrintWriter(cli.getOutputStream(),true);
        in=new BufferedReader(new InputStreamReader(cli.getInputStream()));
        
        while(true){
          //  int temp=(int) Math.floor(Math.random()*1000);
            String outp=in.readLine();
            int val=Integer.parseInt(outp);
            System.out.println(outp);
            val=val+1;
            out.println(""+val);
        }
    }
    
    
}
