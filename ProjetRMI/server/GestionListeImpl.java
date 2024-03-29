package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GestionListeImpl extends UnicastRemoteObject implements GestionListe {
    private List<String> tasks;

    public GestionListeImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    @Override
    public void removeTask(int taskId) throws RemoteException {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.remove(taskId);
        } else {
            throw new RemoteException("Invalid task ID");
        }
    }

    @Override
    public List<String> getAllTasks() throws RemoteException {
        return new ArrayList<>(tasks);
    }
}
