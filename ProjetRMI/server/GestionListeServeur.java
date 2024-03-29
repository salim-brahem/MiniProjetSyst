package server;

public class GestionListeServeur {
    public static void main(String[] args) {
        try {
            GestionListe gestionListe = new GestionListeImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("GestionListe", gestionListe);
            System.out.println("Task Manager server is running...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
