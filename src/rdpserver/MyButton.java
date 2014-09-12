/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rdpserver;

import javax.swing.JButton;

/**
 *
 * @author Sridhar
 */
public class MyButton extends JButton {
    private String info;
    public MyButton(String m){
       super(m); 
    }
    public void setInfo(String val){
        info=val;
    }
    public String getInfo(){
        return info;
    }
    
}
