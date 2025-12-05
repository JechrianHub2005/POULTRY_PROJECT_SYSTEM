import java.util.ArrayList;

// Handle worker registration, approval, and login
public class WorkerService {
    private ArrayList<Worker> pendingWorkers = new ArrayList<>();
    private ArrayList<Worker> activeWorkers = new ArrayList<>();
    private int nextWorkerID = 20;
    private static final int MAX_PENDING = 5; // para sa maximum workers register to pending

    //  para mo work ag maxpending
    public void registerWorker(String name, int age, String contact, String address) {

    if(pendingWorkers.size() >= MAX_PENDING) {
        System.out.println("Pending workers list is FULL. Please wait for admin approval!");
        return;
    }

    Worker w = new Worker(name, age, contact, address, nextWorkerID++);
    pendingWorkers.add(w);
    System.out.println("Account submitted for approval!");
}


    // Approve a pending worker (return true if approved successfully)
    public boolean approveWorker(int index, String password) {
        if(index < 0 || index >= pendingWorkers.size()) {
            return false; // invalid index
        }
        Worker w = pendingWorkers.get(index);
        w.setActive(true);
        w.setCredentials(String.valueOf(w.getWorkerID()), password);
        activeWorkers.add(w);
        pendingWorkers.remove(index);
        return true; // approved successfully
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
    
   // Pagpa Display sa pending or no pending
   public void displayPendingWorkers() {
    if(pendingWorkers.isEmpty()) {
        System.out.println("No pending workers.");
        return;
    }
    // naka plus 1 nag pag display
    for(int i = 0; i < pendingWorkers.size(); i++) {
        System.out.print((i + 1) + ". ");
        pendingWorkers.get(i).showInfo();
    }
}

    // Display active workers
    public void displayActiveWorkers() {
        if(activeWorkers.isEmpty()) {
            System.out.println("No active workers.");
            return;
        }
        for(Worker w : activeWorkers) {
            w.showInfo(); // POLYMORPHISM!
        }
    }

    // Login for worker
    public Worker loginWorker(String id, String password) {
        for(Worker w : activeWorkers) {
            if(w.getUsername().equals(id) && w.getPassword().equals(password)) 
                return w;
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
