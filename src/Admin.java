

// Admin class inherits Person
public class Admin extends Person {

    // admin gets name, age, contact, address, username, password from Person.
    public Admin(String name, int age, String contact, String address) {
        super(name, age, contact, address); // call parent constructor
    }

    @Override
    
    public void showInfo() {
        System.out.println("[ADMIN] Name: " + name + 
                           " | Age: " + age + 
                           " | Contact: " + contact +
                           " | Address: " + address);
    }
    
}

