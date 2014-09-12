/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Sridhar
 */
public class ClientManager extends JFrame{
        
        public JLabel[] address=null;
        public JLabel[] statusLabel=null;
        public MyButton[] connectButtons=null;
        public JPanel spring;
        public static int i;
        public ClientManager(String title){
            this.setTitle(title);
        }
        public void createManager(boolean[] status, ArrayList<Socket> sock){
            spring=new JPanel(new SpringLayout());
            address=new JLabel[status.length];
            statusLabel=new JLabel[status.length];
            connectButtons=new MyButton[status.length];
            
            for(i=0;i<status.length;i++){
              String temp=sock.get(i).getRemoteSocketAddress().toString();
                address[i]=new JLabel(temp);
                statusLabel[i]=new JLabel(status[i]+"");
                connectButtons[i]=new MyButton("Connect");
                connectButtons[i].setInfo(temp);
                connectButtons[i].addActionListener(new ActionListener(){

                  @Override
                  public void actionPerformed(ActionEvent e) {
                      try {
                          //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                          MyButton smk=(MyButton) e.getSource();
                          String ssk=smk.getInfo();
                          ssk=ssk.substring(1,ssk.indexOf(':'));
                          System.out.println(ssk);
                          Process p = Runtime.getRuntime().exec("mstsc /v:"+ssk);
                      } catch (IOException ex) {
                          Logger.getLogger(ClientManager.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  
                  }
                    
                });
                spring.add(address[i]);
                spring.add(statusLabel[i]);
                spring.add(connectButtons[i]);
            }
            SpringUtilities.makeCompactGrid(spring, status.length, 3, 6,6,6,6);
            this.getContentPane().add(spring);
        }
}
