// MenuService.java
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
            System.out.println("""
               ==============================================
                EGG POULTRY SYSTEM              
               ==============================================
               [1] Login as Admin
               [2] Login as Worker
               [3] Register Worker
               [0] Exit
               ==============================================
                """);
            int c = -1;

            while(true){
                try{
                    System.out.print("Choice: ");
                    c = Integer.parseInt(sc.nextLine().trim());
                    if (c < 0 || c > 3){
                        System.out.println("Invalid choices , Enter 0-3 only ");
                        continue;
                    }
                    break;
                } catch(Exception e){
                     System.out.println("Invalid input , numbers only ");
                }
            }
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
        System.out.println("===================================================");
        System.out.println("                    ADMIN LOGIN                    ");
        System.out.println("===================================================");
        System.out.print("Username: "); String u = sc.nextLine();
        
        String p = PasswordMask.readMasked("Password");
        
      //  System.out.print("Password: "); String p = sc.nextLine();

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
            System.out.println("""
            ===============================================
                ADMIN MENU                    
            ===============================================
            [1] View Pending Workers
            [2] View Active Workers
            [3] View Stock
            [0] Logout
            """);
            int c = -1;

              // Safe menu choice input
            while(true) {
            try {
                System.out.print("Choice: ");
                c = Integer.parseInt(sc.nextLine().trim());
                if(c < 0 || c > 3) {
                    System.out.println("Invalid choice, enter 0-3 only.");
                    continue;
                }
                break;
            } catch(Exception e) {
                System.out.println("Invalid input, numbers only.");
            }
        }
        switch(c) {
            
            case 1:
                ws.displayPendingWorkers();
                 if(!ws.isPendingEmpty()) {

        while(true) {  // ✅ LOOP UNTIL VALID OR SKIP
            System.out.print("Enter number to approve (s = skip): ");
            String input = sc.nextLine().trim();

            // ✅ SKIP
            if(input.equalsIgnoreCase("s")) {
                System.out.println("Skipped approval.");
                break; // EXIT PENDING SECTION ONLY
            }

            // ✅ NUMBER CHECK
            try {
                int userChoice = Integer.parseInt(input);

                // ✅ RANGE VALIDATION (BASE-1)
                if(userChoice < 1 || userChoice > ws.getPendingWorkers().size()) {

                    System.out.println(
                        "Invalid! choose a number between 1 and " 
                        + ws.getPendingWorkers().size() + " only."
                    );
                    continue;
                }

                // ✅ CONVERT TO REAL INDEX (BASE-0)
                int realIndex = userChoice - 1;

                // ✅ SET PASSWORD
                System.out.print("Set password: ");
                String pw = sc.nextLine();

                ws.approveWorker(realIndex, pw);
                System.out.println("Worker approved successfully!");

                break; // ✅ EXIT AFTER SUCCESSFUL APPROVAL

            } catch(Exception e) {
                System.out.println("Invalid input! Numbers only or 's' to skip.");
                // ✅ WILL AUTO PROMPT AGAIN
            }
        }
    }
    break;


            case 2:
                ws.displayActiveWorkers();
                break;

            case 3:
                es.displayStock();
                break;

            case 0:
                System.out.println("Logging out...");
                return;
        }
    }
}

    // Worker login
    private void workerLogin() {
        System.out.print("Worker ID: "); String id = sc.nextLine();
        String pw = PasswordMask.readMasked("Password");
        //System.out.print("Password: "); String pw = sc.nextLine();
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
        System.out.println("""
        ===============================================
                   Worker Menu                 
        ===============================================
         [1] Collect Eggs
         [2] Sell Eggs
         [3] View Stock
         [0] Logout
        ===============================================
        """);

        int choice = -1;

        // Safe menu choice input
        while(true) {
            try {
                System.out.print("Choice: ");
                choice = Integer.parseInt(sc.nextLine().trim());
                if(choice < 0 || choice > 3) {
                    System.out.println("Invalid choice, enter 0-3 only.");
                    continue;
                }
                break;
            } catch(Exception e) {
                System.out.println("Invalid input, numbers only.");
            }
        }

        switch(choice) {
            case 1: // Collect Eggs
                int sTray = getValidatedInt("Small - Tray: ");
                int sInd   = getValidatedInt("Small - Individual: ");
                int mTray = getValidatedInt("Medium - Tray: ");
                int mInd   = getValidatedInt("Medium - Individual: ");
                int lTray = getValidatedInt("Large - Tray: ");
                int lInd   = getValidatedInt("Large - Individual: ");
                int xlTray = getValidatedInt("XL - Tray: ");
                int xlInd   = getValidatedInt("XL - Individual: ");
                es.collectEggs(sTray, sInd, mTray, mInd, lTray, lInd, xlTray, xlInd);
                break;

            case 2: {
                System.out.print("Buyer Name: ");
                String buyer = sc.nextLine().trim();
                if(buyer.isEmpty()) {
                System.out.println("Buyer name cannot be empty. Retry.");
                break;
                 }
                while(true) {
                System.out.println("AVAILABLE STOCK");
                es.displayStock();

               // ===== SMALL =====
                while(true) {
                sTray = getValidatedInt("Small - Tray: ");
                sInd  = getValidatedInt("Small - Individual: ");

                int totalS = sTray * 30 + sInd;
                if(!es.hasEnoughByPieces(totalS, 0, 0, 0)) {
                System.out.println("Not enough SMALL stock. Re-enter SMALL only.");
                continue;
            }
            break;
            }

            // ===== MEDIUM =====
            while(true) {
            mTray = getValidatedInt("Medium - Tray: ");
            mInd  = getValidatedInt("Medium - Individual: ");

            int totalM = mTray * 30 + mInd;
            if(!es.hasEnoughByPieces(0, totalM, 0, 0)) {
              System.out.println("Not enough MEDIUM stock. Re-enter MEDIUM only.");
              continue;
         }
            break;
            }

              // ===== LARGE =====
              while(true) {
            lTray = getValidatedInt("Large - Tray: ");
            lInd  = getValidatedInt("Large - Individual: ");

            int totalL = lTray * 30 + lInd;
            if(!es.hasEnoughByPieces(0, 0, totalL, 0)) {
        System.out.println("Not enough LARGE stock. Re-enter LARGE only.");
        continue;
    }
    break;
}

// ===== XL =====
while(true) {
    xlTray = getValidatedInt("XL - Tray: ");
    xlInd  = getValidatedInt("XL - Individual: ");

    int totalXL = xlTray * 30 + xlInd;
    if(!es.hasEnoughByPieces(0, 0, 0, totalXL)) {
        System.out.println("Not enough XL stock. Re-enter XL only.");
        continue;
    }
    break;
}

                if(!es.hasEnoughStock(sTray,sInd,mTray,mInd,lTray,lInd,xlTray,xlInd)) {
                System.out.println("Not enough stock! Retry quantities.\n");
                continue;
                 }   
            break;
                }

                int totalS = sTray*30 + sInd;
                int totalM = mTray*30 + mInd;
                int totalL = lTray*30 + lInd;
                int totalXL = xlTray*30 + xlInd;
                double totalAmount = ts.calculateTotal(totalS, totalM, totalL, totalXL);
                System.out.println("Total Amount: " + totalAmount);
    
                double cash;
                while(true) {
                cash = getValidatedDouble("Enter Cash: ");
                if(cash < totalAmount) {
                System.out.println("Insufficient cash! Retry.");
                continue;
                 }
                break;
                }

                es.sellEggs(sTray,sInd,mTray,mInd,lTray,lInd,xlTray,xlInd,cash,ts,buyer);
                System.out.println("Transaction successful!");
                break;
                 }
                case 3: // View Stock
                es.displayStock();
                break;

                case 0: // Logout
                System.out.println("Logging out...");
                return;
        }
    }
}
       
    // Helper method for safe integer input in sell egg
    private int getValidatedInt(String prompt) {
    int value = -1;
    while(true) {
        try {
            System.out.print(prompt);
            value = Integer.parseInt(sc.nextLine().trim());
            if(value < 0) {
                System.out.println("Value cannot be negative.");
                continue;
            }
            break;
        } catch(Exception e) {
            System.out.println("Invalid input, numbers only.");
        }
      }
        return value;
    }

        // Helper method for safe double input
        private double getValidatedDouble(String prompt) {
        double value = -1;
        while(true) {
        try {
            System.out.print(prompt);
            value = Double.parseDouble(sc.nextLine().trim());
            if(value < 0) {
                System.out.println("Value cannot be negative.");
                continue;
            }
            break;
        } catch(Exception e) {
            System.out.println("Invalid input, numbers only.");
        }
    }
    return value;
        }

            private void registerWorker() {
            String name, contact, addr;
            int age = -1;

            // Name input (letters only)
            do {
            System.out.print("Name: ");
            name = sc.nextLine().trim();
            if(name.isEmpty() || !name.matches("[a-zA-Z ]+")) {
            System.out.println("Name must contain letters only.");
            }
            } while(name.isEmpty() || !name.matches("[a-zA-Z ]+"));

            // Age input (numbers only, >0)
            do {
            System.out.print("Age: ");
            try {
            age = Integer.parseInt(sc.nextLine().trim());
            if(age <= 0) System.out.println("Age must be a positive number.");
            } catch(Exception e) {
            System.out.println("Invalid input, numbers only.");
            age = -1;
            }
            } while(age <= 0);

    // Contact input (numbers only)
    do {
        System.out.print("Contact: ");
        contact = sc.nextLine().trim();
        if(contact.isEmpty() || !contact.matches("\\d+")) {
            System.out.println("Contact must be numbers only.");
        }
    } while(contact.isEmpty() || !contact.matches("\\d+"));

    // Address input (letters and spaces only)
    do {
        System.out.print("Address: ");
        addr = sc.nextLine().trim();
        if(addr.isEmpty() || !addr.matches("[a-zA-Z0-9 ,.]+")) {
            System.out.println("Address must contain valid characters.");
        }
    } while(addr.isEmpty() || !addr.matches("[a-zA-Z0-9 ,.]+"));

    // Register worker
    ws.registerWorker(name, age, contact, addr);
   // System.out.println("Worker registered successfully, pending approval!");
   }
}
