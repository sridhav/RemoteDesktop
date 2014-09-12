/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpserver;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Sridhar
 */
public class RDPServer {

    /**
     * @param args the command line arguments
     */
    private static boolean[] status=null;
    private static ArrayList<Socket> sock=null;
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
            ClientManager sri=new ClientManager("RDP");
            Thread server=new Thread(new Server(),"Server");
            server.start();
                
            
             
            ArrayList<Socket> cli=null;
            while(true){
                cli=Server.getClients();
                if(cli.isEmpty()){
                    Thread.sleep(2000);
                }
                else{
                    break;
                }
            }
             Thread thr=new Thread(new StatusThread(cli),"Status");
             thr.start();
             int j=0;
             while(true){
                 Thread.sleep(2000);
                  status=StatusThread.getStatusList();
                 sock=StatusThread.getClientList();
                 for(int i=0;i<status.length;i++){
                     System.out.println("In main Thread "+status[i]);
                     System.out.println(sock.get(i).getRemoteSocketAddress());
                 }
                 sri.createManager(status, sock);
                 sri.setVisible(true);
                 sri.pack();
                 
                 
             }
    }
}