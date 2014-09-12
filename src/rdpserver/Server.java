/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sridhar
 */
public class Server implements Runnable{
    private ServerSocket serv=null;
    private static ArrayList<Socket> clientList=new ArrayList<Socket>();
    private ArrayList<Thread> ThreadList=new ArrayList<Thread>();
   
    public Server(){
        try {
            serv=new ServerSocket(11111);
        } catch (IOException ex) {
            System.out.println("Error creating socket on port : 11111");
            System.out.println("Exception "+ex); 
            System.exit(1);
        }
    }
    
    @Override
    public void run(){
        Socket client=null;
        int i=0;
        while(true){
            try {
              client=serv.accept();
                 System.out.println("Connected to Server "+client.getLocalSocketAddress()+" "+client.getRemoteSocketAddress());
                 // System.out.println("Starting Thread");
             // ThreadList.add(new Thread(new HandleClient(client),"client"+i));
              //checkInterrupts();
              //i++;
             // addClient(client);
              // if(i%5==0){
                //  showClients();
              //}
              addClient(client);
              
            } catch (IOException ex) {
                System.out.println("Error Accepting Client");
                System.out.println("Exception "+ex); 
                System.exit(1);
            }
        }
    }
    
    public void addClient(Socket client){
        clientList.add(client);
    }
    public static ArrayList<Socket> getClients(){
        return clientList;
    }
    
    
    public void showClients(){
       System.out.println("Clients");
       for(int i=0;i<clientList.size();i++){
           System.out.println(clientList.get(i).getRemoteSocketAddress());
       } 
    }
    public void checkInterrupts(){
        for(int i=0;i<ThreadList.size();i++){
                System.out.println("Thread "+ThreadList.get(i).getName());
        }
    }
    
    
    
    
}
