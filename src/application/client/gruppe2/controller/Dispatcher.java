package application.client.gruppe2.controller;

import network.Message;
import network.client.ClientApplicationInterface;
import protocol.server2client.PlayerJoined;
import protocol.server2client.Update;

public class Dispatcher implements ClientApplicationInterface {

    @Override
    public void handleMessage(Message message) {
        // TODO Auto-generated method stub

        if (message instanceof PlayerJoined)
        {
             PlayerJoinedControl c = ControlFactory.instance().createPlayerJoinedControl();
             c.playerJoined((PlayerJoined)message);
        }
        else if (message instanceof Update)
        {

        }

    }

}
