/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
// Worker class inherits Person
public class Worker extends Person {
    private int workerID;
    private boolean isActive;

    public Worker(String name, int age, String contact, String address, int workerID) {
        super(name, age, contact, address);
        this.workerID = workerID;
        this.isActive = false;
    }

    public void setActive(boolean status) { this.isActive = status; }
    public boolean isActive() { return isActive; }
    public int getWorkerID() { return workerID; }
    
}
