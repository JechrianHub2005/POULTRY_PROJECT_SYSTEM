
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        WorkerService ws = new WorkerService();
        EggStockService es = new EggStockService();
        TransactionService ts = new TransactionService();
        MenuService menu = new MenuService(ws,es,ts,sc);

        menu.runMainMenu();
    }
}
