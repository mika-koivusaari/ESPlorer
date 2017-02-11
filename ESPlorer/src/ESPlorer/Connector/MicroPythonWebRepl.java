/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

/**
 *
 * @author Mika Koivusaari
 */
public class MicroPythonWebRepl implements Connector {

    ClientManager client=null;
    Session session=null;
    
    @Override
    public void open() {
        try {
            //        final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
            
            client = ClientManager.createClient();
            session=client.connectToServer(new MPWebReplEndPoint(), new URI("ws://192.168.0.112:8266"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(MicroPythonWebRepl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DeploymentException ex) {
            Logger.getLogger(MicroPythonWebRepl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MicroPythonWebRepl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        try {
            session.close();
        } catch (IOException ex) {
            Logger.getLogger(MicroPythonWebRepl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendCommand(String command) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveFile(String filename, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JLayeredPane getConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
