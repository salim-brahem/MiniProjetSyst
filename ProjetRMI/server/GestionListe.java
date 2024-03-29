package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GestionListe extends Remote {
    void addTask(String task) throws RemoteException;
    void removeTask(int taskId) throws RemoteException;
    List<String> getAllTasks() throws RemoteException;
}