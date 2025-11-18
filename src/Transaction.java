/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;

// Record transactions
public class Transaction {
    private static int counter = 1;
    private int transactionID;
    private String buyerName;
    private int small, medium, large, xl;
    private double total, cash, change;
    private LocalDateTime dateTime;

    public Transaction(String buyerName, int s, int m, int l, int xl, double total, double cash) {
        this.transactionID = counter++;
        this.buyerName = buyerName;
        this.small = s; this.medium = m; this.large = l; this.xl = xl;
        this.total = total; this.cash = cash; this.change = cash-total;
        this.dateTime = LocalDateTime.now();
    }

    public void printReceipt(){
        System.out.println("----- RECEIPT -----");
        System.out.println("Transaction ID: "+transactionID);
        System.out.println("Buyer: "+buyerName);
        System.out.println("Small: "+small+", Medium: "+medium+", Large: "+large+", XL: "+xl);
        System.out.println("Total: "+total+", Cash: "+cash+", Change: "+change);
        System.out.println("Date: "+dateTime);
        System.out.println("Thank you! Come Again!");
    }
}
