// Parent class for Admin and Worker
public abstract class Person {
    protected String name;
    protected int age;
    protected String contact;
    protected String address;
    protected String username;
    protected String password;

    // Constructor template of base info
    public Person(String name, int age, String contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    // Set login credentials // Encapsulated method to store credentials.
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // ABSTRACT METHOD FOR POLYMORPHISM
    public abstract void showInfo(); // override so admin and worker diply info diffntly
}
