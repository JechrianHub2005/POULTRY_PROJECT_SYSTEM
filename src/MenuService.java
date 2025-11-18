import java.util.Scanner;

// Handles console menu flow
public class MenuService {
    private WorkerService ws;
    private EggStockService es;
    private TransactionService ts;
    private Scanner sc;

    private final String ADMIN_USER = "a";
    private final String ADMIN_PASS = "s";

    public MenuService(WorkerService ws, EggStockService es, TransactionService ts, Scanner sc) {
        this.ws = ws;
        this.es = es;
        this.ts = ts;
        this.sc = sc;
    }

    public void runMainMenu() {
        while(true) {
            System.out.println("==== EGG POULTRY SYSTEM ====");
            System.out.println("[1] Login as Admin");
            System.out.println("[2] Login as Worker");
            System.out.println("[3] Register Worker");
            System.out.println("[0] Exit");
            System.out.print("Choice: ");
            int c = sc.nextInt(); sc.nextLine();

            switch(c) {
                case 1: adminLogin(); break;
                case 2: workerLogin(); break;
                case 3: registerWorker(); break;
                case 0: return;
            }
        }
    }

    // Admin login
    private void adminLogin() {
        System.out.print("Username: "); String u = sc.nextLine();
        System.out.print("Password: "); String p = sc.nextLine();

        if(u.equals(ADMIN_USER) && p.equals(ADMIN_PASS)) {
            System.out.println("Admin logged in!");
            adminMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    // Admin menu
    private void adminMenu() {
        while(true) {
            System.out.println("----- Admin Menu -----");
            System.out.println("[1] View Pending Workers");
            System.out.println("[2] View Active Workers");
            System.out.println("[3] View Stock");
            System.out.println("[0] Logout");
            System.out.print("Choice: "); int c = sc.nextInt(); sc.nextLine();

            switch(c) {
                case 1:
                    ws.displayPendingWorkers();
                    if(!ws.isPendingEmpty()) {
                        System.out.print("Index to approve/delete (-1 skip): ");
                        int idx = sc.nextInt(); sc.nextLine();
                        if(idx != -1) {
                            System.out.print("Set password for worker: ");
                            String pw = sc.nextLine();
                            ws.approveWorker(idx, pw);
                        }
                    }
                    break;
                case 2: ws.displayActiveWorkers(); break;
                case 3: es.displayStock(); break;
                case 0: return;
            }
        }
    }

    // Worker login
    private void workerLogin() {
        System.out.print("Worker ID: "); String id = sc.nextLine();
        System.out.print("Password: "); String pw = sc.nextLine();
        Worker w = ws.loginWorker(id, pw);

        if(w == null) {
            System.out.println("Invalid login!");
            return;
        }

        System.out.println("Worker logged in: " + w.getName());
        workerMenu();
    }

    // Worker menu
    private void workerMenu() {
        while(true) {
            System.out.println("----- Worker Menu -----");
            System.out.println("[1] Collect Eggs");
            System.out.println("[2] Sell Eggs");
            System.out.println("[3] View Stock");
            System.out.println("[0] Logout");
            System.out.print("Choice: "); int c = sc.nextInt(); sc.nextLine();

            switch(c) {
                case 1:
                    System.out.print("Small - Tray: "); int sTray = sc.nextInt();
                    System.out.print("Small - Individual: "); int sInd = sc.nextInt();
                    System.out.print("Medium - Tray: "); int mTray = sc.nextInt();
                    System.out.print("Medium - Individual: "); int mInd = sc.nextInt();
                    System.out.print("Large - Tray: "); int lTray = sc.nextInt();
                    System.out.print("Large - Individual: "); int lInd = sc.nextInt();
                    System.out.print("XL - Tray: "); int xlTray = sc.nextInt();
                    System.out.print("XL - Individual: "); int xlInd = sc.nextInt();
                    es.collectEggs(sTray, sInd, mTray, mInd, lTray, lInd, xlTray, xlInd);
                    break;
                case 2:
                    System.out.print("Buyer Name: "); String buyer = sc.nextLine();
                    System.out.print("Small - Tray: "); sTray = sc.nextInt();
                    System.out.print("Small - Individual: "); sInd = sc.nextInt();
                    System.out.print("Medium - Tray: "); mTray = sc.nextInt();
                    System.out.print("Medium - Individual: "); mInd = sc.nextInt();
                    System.out.print("Large - Tray: "); lTray = sc.nextInt();
                    System.out.print("Large - Individual: "); lInd = sc.nextInt();
                    System.out.print("XL - Tray: "); xlTray = sc.nextInt();
                    System.out.print("XL - Individual: "); xlInd = sc.nextInt();
                    System.out.print("Cash: "); double cash = sc.nextDouble(); sc.nextLine();
                    es.sellEggs(sTray, sInd, mTray, mInd, lTray, lInd, xlTray, xlInd, cash, ts, buyer);
                    break;
                case 3: es.displayStock(); break;
                case 0: return;
            }
        }
    }

    // Register worker
    private void registerWorker() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
        System.out.print("Contact: "); String contact = sc.nextLine();
        System.out.print("Address: "); String addr = sc.nextLine();
        ws.registerWorker(name, age, contact, addr);
    }
}
