

// Worker class inherits Person
public class Worker extends Person {
    private int workerID; // Unique ID assigned after admin approval
    private boolean isActive; // true if worker approved

    public Worker(String name, int age, String contact, String address, int workerID) {
        super(name, age, contact, address);
        this.workerID = workerID;
        this.isActive = false; // defauklt Pending
    }
    // set active worker / change status if approved or pending
    public void setActive(boolean status) { this.isActive = status; }
    
    // Set worker as active or inactive
    public boolean isActive() { return isActive; }
    
    public int getWorkerID() { return workerID; }

    @Override
    public void showInfo() {
        System.out.println("[WORKER] ID: " + workerID +
                           " | Name: " + name +
                           " | Age: " + age +
                           " | Contact: " + contact +
                           " | Active: " + isActive);
    }
    
}
