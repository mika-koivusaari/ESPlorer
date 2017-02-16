/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESPlorer.Connector;

import java.io.IOException;
import java.net.URI;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Mika Koivusaari
 */
@ClientEndpoint
/*        (
    decoders = SampleDecoder.class,
    encoders = SampleEncoder.class,
    subprotocols = {"subprtotocol1", "subprotocol2"},
    configurator = ClientConfigurator.class)*/
public class MPWebReplEndPoint{

    private MicroPythonWebRepl callback;
    
    public MPWebReplEndPoint(MicroPythonWebRepl callback) {
        this.callback=callback;
    }
    
    @OnOpen
    public void onOpen(Session p) {
        System.out.println("Connected.");
/*        try {
            p.getBasicRemote().sendText("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(String.format("%s '%s'", "Received message: ", message));
        callback.messageReceived(message);
    }
    
}
