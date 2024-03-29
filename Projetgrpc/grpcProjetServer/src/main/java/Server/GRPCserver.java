package Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import Chat.grpc.ChatService;

import java.io.IOException;

public class GRPCserver {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new ChatService())
                .build();

        server.start();
        System.out.println("Server started at port: " + server.getPort());

        // Attendre que le serveur soit terminé
        server.awaitTermination();
    }
}
