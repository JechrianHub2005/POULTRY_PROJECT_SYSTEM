/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Handle selling & total calculation
import java.util.ArrayList;

public class TransactionService {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private final double PRICE_SMALL=5, PRICE_MEDIUM=7, PRICE_LARGE=9, PRICE_XL=12;

    public double calculateTotal(int s,int m,int l,int xl){
        return s*PRICE_SMALL + m*PRICE_MEDIUM + l*PRICE_LARGE + xl*PRICE_XL;
    }

    public void recordTransaction(String buyer,int s,int m,int l,int xl,double total,double cash){
        Transaction t = new Transaction(buyer,s,m,l,xl,total,cash);
        transactions.add(t);
        t.printReceipt();
    }
}
