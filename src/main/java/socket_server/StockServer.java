package socket_server;

import model.ClientModelThread;
import pool.ThreadPools;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class StockServer {

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            System.out.println("Waiting for connection!");
            Socket client = server.accept();
            System.out.println("Connected!");

            ExecutorService es = ThreadPools.getThreadPool();

            ClientModelThread clientThread = new ClientModelThread(client, server);

            es.execute(clientThread);
        }
    }

    public static void main(String[] args) throws IOException {
        StockServer server = new StockServer();
        server.startServer();
    }

}
