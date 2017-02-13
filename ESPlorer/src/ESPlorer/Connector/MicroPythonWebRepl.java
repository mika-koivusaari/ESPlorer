/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
    
    JPanel configPane=null;
    JPanel connectPane=null;
    JTextField wsaddress=null;
    
    ConnectorCallback callback=null;
    
    @Override
    public void open() {
        try {
            //        final ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
            
            client = ClientManager.createClient();
            session=client.connectToServer(new MPWebReplEndPoint(callback), new URI(wsaddress.getText()));
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
        try {
            session.getBasicRemote().sendText(command);
        } catch (IOException ex) {
            Logger.getLogger(MicroPythonWebRepl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void saveFile(String filename, String content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getConfigPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JPanel getConnectionPane() {
        if (connectPane==null){
            connectPane = new JPanel();
//            connectPane.setMaximumSize(new java.awt.Dimension(300, 25));
//            connectPane.setMinimumSize(new java.awt.Dimension(300, 25));
            connectPane.setOpaque(true);
//            LEDPanel.setLayer(PortOpenLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
            FlowLayout connectPaneLayout = new FlowLayout();
            connectPane.setLayout(connectPaneLayout);
            wsaddress = new JTextField("ws://192.168.0.112:8266",30);
            wsaddress.setMaximumSize(new java.awt.Dimension(300, 25));
            wsaddress.setMinimumSize(new java.awt.Dimension(100, 25));
            wsaddress.setPreferredSize(new java.awt.Dimension(150, 25));
            connectPane.add(wsaddress);
        }
        return connectPane;
    }

    @Override
    public void setCallback(ConnectorCallback callback) {
        this.callback=callback;
    }
    
}
