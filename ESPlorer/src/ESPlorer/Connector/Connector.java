/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

import java.util.ArrayList;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
    public void sendCommands(ArrayList<String> commands);
    /**
     * send Specified file to connection for saving to file system.
     */
    public void saveFile(String filename, String content);

    public JPanel getConfigPane();
    
    public JPanel getConnectionPane();
    
    public void setCallback(ConnectorCallback callback);
}
