import java.util.ArrayList;

// Handle worker registration, approval, and login
public class WorkerService {

    private ArrayList<Worker> pendingWorkers = new ArrayList<>();
    private ArrayList<Worker> activeWorkers = new ArrayList<>();
    private int nextWorkerID = 20;

    // Register a new worker (pending approval)
    public void registerWorker(String name, int age, String contact, String address) {
        Worker w = new Worker(name, age, contact, address, nextWorkerID++);
        pendingWorkers.add(w);
        System.out.println("Account submitted for approval!");
    }

    // Approve a pending worker
    public void approveWorker(int index, String password) {
        if(index < 0 || index >= pendingWorkers.size()) {
            System.out.println("Invalid index!");
            return;
        }

        Worker w = pendingWorkers.get(index);
        w.setActive(true);
        w.setCredentials(String.valueOf(w.getWorkerID()), password);
        activeWorkers.add(w);
        pendingWorkers.remove(index);
        System.out.println("Worker approved! ID: " + w.getWorkerID());
    }

    // Delete a pending worker
    public void deletePendingWorker(int index) {
        if(index < 0 || index >= pendingWorkers.size()) {
            System.out.println("Invalid index!");
            return;
        }
        pendingWorkers.remove(index);
        System.out.println("Pending worker deleted!");
    }

    // Display pending workers
    public void displayPendingWorkers() {
        if(pendingWorkers.isEmpty()) {
            System.out.println("No pending workers.");
            return;
        }
        for(int i = 0; i < pendingWorkers.size(); i++) {
            Worker w = pendingWorkers.get(i);
            System.out.println(i + ". " + w.getName() + " | Age: " + w.age + " | Contact: " + w.contact);
        }
    }

    // Display active workers
    public void displayActiveWorkers() {
        if(activeWorkers.isEmpty()) {
            System.out.println("No active workers.");
            return;
        }
        for(Worker w : activeWorkers) {
            System.out.println("WorkerID: " + w.getWorkerID() + " | Name: " + w.getName());
        }
    }

    // Login for worker
    public Worker loginWorker(String id, String password) {
        for(Worker w : activeWorkers) {
            if(w.getUsername().equals(id) && w.getPassword().equals(password)) return w;
        }
        return null;
    }

    // Getter for pendingWorkers (for MenuService access)
    public ArrayList<Worker> getPendingWorkers() {
        return pendingWorkers;
    }

    // Check if there are no pending workers
    public boolean isPendingEmpty() {
        return pendingWorkers.isEmpty();
    }
}
