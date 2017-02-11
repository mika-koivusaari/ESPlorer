/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

import javax.swing.JLayeredPane;

/**
 *
 * @author Mika Koivusaari
 */
public interface Connector {
    
    /**
     * Open connection.
     */
    public void open();
    /**
     * Close connection
     */
    public void close();
    /**
     * Send specified string to connection to be executed.
     * 
     * @param command 
     */
    public void sendCommand(String command);
    /**
     * send Specified file to connection for saving to file system.
     */
    public void saveFile(String filename, String content);
    public JLayeredPane getConfig();
}
