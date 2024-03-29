package client;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import server.GestionListe;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Déplacer la déclaration du scanner ici
    
        try {
            GestionListe gestionListe = (GestionListe) Naming.lookup("GestionListe");
    
            while (true) {
                System.out.println("Que souhaitez-vous faire?");
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Supprimer une tâche");
                System.out.println("3. Afficher la liste des tâches");
                System.out.println("4. Quitter");
                System.out.print("Votre choix : ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Pour consommer le saut de ligne
    
                switch (choice) {
                    case 1:
                        System.out.print("Entrez la tâche à ajouter : ");
                        String newTask = scanner.nextLine();
                        gestionListe.addTask(newTask);
                        System.out.println("Tâche ajoutée avec succès.");
                        break;
                    case 2:
                        System.out.print("Entrez l'ID de la tâche à supprimer : ");
                        int taskId = scanner.nextInt();
                        gestionListe.removeTask(taskId);
                        System.out.println("Tâche supprimée avec succès.");
                        break;
                    case 3:
                        List<String> tasks = gestionListe.getAllTasks();
                        System.out.println("Liste des tâches :");
                        if (tasks.isEmpty()) {
                            System.out.println("Aucune tâche.");
                        } else {
                            for (int i = 0; i < tasks.size(); i++) {
                                System.out.println(i + ": " + tasks.get(i));
                            }}
                        break;
                    case 4:
                        System.out.println("Au revoir!");
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        } finally {
            scanner.close(); // Fermeture du scanner
        }
    }
    
}
