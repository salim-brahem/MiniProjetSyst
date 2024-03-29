package Client;
import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Ajout d'un message d'invite
            System.out.println("Veuillez entrer votre message :");

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                out.println(userInputLine);
                String serverResponse = in.readLine();
                if (serverResponse != null) {
                    System.out.println(serverResponse);
                }

                // Ajoutez une condition pour terminer la conversation
                if (userInputLine.equalsIgnoreCase("quit") || userInputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                // Afficher à nouveau le message d'invite
                System.out.println("Veuillez entrer votre message :");
            }

            // Fermer les flux et le socket
            out.close();
            in.close();
            userInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
