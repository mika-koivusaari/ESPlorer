/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

/**
 *
 * @author Mika Koivusaari
 */
public interface ConnectorCallback {
    
    public void messageReceived(String msg);
    
    public void connectionClosed();
}
