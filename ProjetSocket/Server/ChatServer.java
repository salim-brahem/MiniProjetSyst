package Server;
import java.io.*;
import java.net.*;

public class ChatServer {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running...");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Créer un thread pour gérer les communications avec le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, consoleReader);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                    System.out.println("Server socket closed.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;
        private BufferedReader consoleReader;

        public ClientHandler(Socket socket, BufferedReader consoleReader) {
            this.clientSocket = socket;
            this.consoleReader = consoleReader;
        }

        public void run() {
            try {
                // Initialiser les flux de communication avec le client
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Client: " + inputLine);
                    
                    // Exemple de logique pour générer une réponse personnalisée
                    String response;
                    if (inputLine.equalsIgnoreCase("Hello")) {
                        response = "Bonjour!";
                    } else if (inputLine.equalsIgnoreCase("How are you?")) {
                        response = "Je vais bien, merci!";
                    } else {
                        // Demander la réponse à envoyer au client
                        System.out.println("Entrez la réponse à envoyer au client:");
                        response = consoleReader.readLine();
                    }
                    
                    // Envoyer la réponse au client
                    out.println("Server: " + response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Fermer les flux et le socket client
                try {
                    out.close();
                    in.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
