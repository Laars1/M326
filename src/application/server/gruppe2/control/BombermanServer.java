package application.server.gruppe2.control;

import application.server.gruppe2.model.Game;
import application.server.gruppe2.network.MessageEntry;
import application.server.gruppe2.network.MessageQueue;
import network.server.Server;
import network.server.ServerStub;

public class BombermanServer {

	public static void main(String[] args) {
		new BombermanServer();
  
	}

	private BombermanServer() {
		MessageQueue queue = new MessageQueue();
		MessageEntry entry = new MessageEntry(queue);
		//mustestub classe in src.network übertragen damit es functioniert wieso?import nur auf src ebven möglich
		Server server = new ServerStub(entry);
		Game game = new Game();
		ControllerFactory controllerFactory = new ControllerFactory(server ,game );
		Dispatcher dispatcher = new Dispatcher(queue,controllerFactory);
		dispatcher.start();
	}
}
