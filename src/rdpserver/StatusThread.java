/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class StatusThread implements Runnable {
    private static ArrayList<Socket> clients=new ArrayList<Socket>();
    private static boolean statusList[];
    PrintWriter out=null;
    BufferedReader in=null;
    
    public StatusThread(ArrayList<Socket> cli){
        clients=cli;
    //    System.out.println("In Status Thread");
        
    }
    
    @Override
    public void run() {
        
        while(true){
            clients=Server.getClients();
            statusList=new boolean[clients.size()];
            for(int i=0;i<statusList.length;i++){
                    statusList[i]=false;
            }
            for(int i=0;i<clients.size();i++){
                Socket client=clients.get(i);
            try {
      //          System.out.println("ping client");
                statusList[i]=pingClient(client);
            } catch (IOException ex) {
                Logger.getLogger(StatusThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        displayStatus();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(StatusThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public boolean pingClient(Socket client) throws IOException{
       out=new PrintWriter(client.getOutputStream(),true);
       in=new BufferedReader(new InputStreamReader(client.getInputStream()));
       int x=(int) Math.floor(Math.random()*1000);
       out.println(x);
       int y=Integer.parseInt(in.readLine());
       System.out.println(y);
       if(y==(x+1)){
           return true;
       }
       
       return false;
        
    }
    public static boolean[] getStatusList(){
        return statusList;
    }
    
    public static ArrayList<Socket> getClientList(){
        return clients;
    }
    
    
    private void displayStatus(){
        for(int i=0;i<statusList.length;i++){
            System.out.println("Status for Client "+i+" "+statusList[i]);
        }
    }
}