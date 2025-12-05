import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Record transactions
public class Transaction {
    private static int counter = 1;
    private int transactionID;
    private String buyerName;
    private int small, medium, large, xl;
    private double total, cash, change;
    private LocalDate date;

    public Transaction(String buyerName, int s, int m, int l, int xl, double total, double cash) {
        this.transactionID = counter++;
        this.buyerName = buyerName;
        this.small = s; this.medium = m; this.large = l; this.xl = xl;
        this.total = total; this.cash = cash; this.change = cash-total;
        this.date = LocalDate.now();
    }

    public void printReceipt() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
    
    System.out.println("\n================== RECEIPT ==================");
    System.out.printf("Transaction ID : %d%n", transactionID);
    System.out.printf("Buyer Name     : %s%n", buyerName);
    System.out.println("--------------------------------------------");
    System.out.printf("| %-6s | %-6s | %-6s | %-6s |%n", "Size", "Tray", "Indiv", "Total");
    System.out.println("--------------------------------------------");
    System.out.printf("| %-6s | %-6d | %-6d | %-6d |%n", "Small", small / 30, small % 30, small);
    System.out.printf("| %-6s | %-6d | %-6d | %-6d |%n", "Medium", medium / 30, medium % 30, medium);
    System.out.printf("| %-6s | %-6d | %-6d | %-6d |%n", "Large", large / 30, large % 30, large);
    System.out.printf("| %-6s | %-6d | %-6d | %-6d |%n", "XL", xl / 30, xl % 30, xl);
    System.out.println("--------------------------------------------");
    System.out.printf("Total Amount   : %.2f%n", total);
    System.out.printf("Cash           : %.2f%n", cash);
    System.out.printf("Change         : %.2f%n", change);
    System.out.printf("Date           : %s%n", date.format(formatter));
    System.out.println("Thank you! Come Again!");
    System.out.println("============================================\n");
    }
}
