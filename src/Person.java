/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
// Parent class for Admin and Worker
public class Person {
    protected String name;
    protected int age;
    protected String contact;
    protected String address;
    protected String username;
    protected String password;

    // Constructor
    public Person(String name, int age, String contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    // Set login credentials
    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
