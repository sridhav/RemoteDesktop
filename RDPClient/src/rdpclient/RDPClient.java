/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpclient;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 *
 * @author Sridhar
 */
public class RDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        // TODO code application logic here
        Client s=new Client();
        s.startClient();
    }
}
