package network.client;

import application.client.gruppe2.model.Player;
import network.Message;
import protocol.server2client.PlayerJoined;

public class KenansServerProxStub extends ServerProxy {
    /**
     * Konstruktor. Initialisiert das neue ServerProxy-Objekt mit der Referenz auf das Empfängerobjekt.
     *
     * @param clientApplication Das Empfängerobjekt des Bomberman-Clients für Nachrichten.
     */
    public KenansServerProxStub(ClientApplicationInterface clientApplication) {
        super(clientApplication);
    }

    @Override
    public void send(Message message) {
        System.out.println(message);
        PlayerJoined playerJoinedMessage = new PlayerJoined("Adolf Hilter", 0 , 0);
        deliverResponseMessageToClient(playerJoinedMessage);

    }

    private void deliverResponseMessageToClient(Message m)
    {
        Thread r = new Thread() {
            @Override
            public void run() {
                clientApplication.handleMessage(m);
            }
        };
    }
}
