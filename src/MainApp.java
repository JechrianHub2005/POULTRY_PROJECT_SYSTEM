import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        
        // Instance an object service then pass the object in menuService
        Scanner sc = new Scanner(System.in);
        WorkerService ws = new WorkerService();
        EggStockService es = new EggStockService();
        TransactionService ts = new TransactionService();
        MenuService menu = new MenuService(ws,es,ts,sc);

        menu.runMainMenu();
    }
}
