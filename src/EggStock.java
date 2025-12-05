public class EggStock {
    // Tray count
    private int trayS, trayM, trayL, trayXL;
    // Individual count
    private int indS, indM, indL, indXL;

    // Total for each size (tray*30 + individual)// overall total by pieces
    private int stockS, stockM, stockL, stockXL;

    public EggStock() {
        trayS = trayM = trayL = trayXL = 0;
        indS = indM = indL = indXL = 0;
        stockS = stockM = stockL = stockXL = 0;
    }
    
    // Add eggstock , if re computes/add/collect ma addan ra
    public void addEggs(int sTray, int sInd, int mTray, int mInd,
                        int lTray, int lInd, int xlTray, int xlInd) 
    {
        trayS += sTray; indS += sInd;
        trayM += mTray; indM += mInd;
        trayL += lTray; indL += lInd;
        trayXL += xlTray; indXL += xlInd;

        stockS = trayS*30 + indS;
        stockM = trayM*30 + indM;
        stockL = trayL*30 + indL;
        stockXL = trayXL*30 + indXL;
    }
    // Check if enough stock for a sale
    public boolean hasEnoughStock(int sTray, int sInd, int mTray, int mInd,
                                  int lTray, int lInd, int xlTray, int xlInd) {
        return sTray <= trayS && sInd <= indS &&
               mTray <= trayM && mInd <= indM &&
               lTray <= trayL && lInd <= indL &&
               xlTray <= trayXL && xlInd <= indXL;
    }
    // Same logic as addEggs but subtract.// deduct'kan rag stock
    public void deductEggs(int sTray, int sInd, int mTray, int mInd,
                            int lTray, int lInd, int xlTray, int xlInd) {
        trayS -= sTray; indS -= sInd;
        trayM -= mTray; indM -= mInd;
        trayL -= lTray; indL -= lInd;
        trayXL -= xlTray; indXL -= xlInd;

        stockS = trayS*30 + indS;
        stockM = trayM*30 + indM;
        stockL = trayL*30 + indL;
        stockXL = trayXL*30 + indXL;
    }
    
    // paras quantity validation ddtus menu
    public boolean hasEnoughByPieces(int s,int m,int l,int xl) {
    return s <= stockS && m <= stockM && l <= stockL && xl <= stockXL;
}

    
    // Para sa View Stock and available Stocl
        public void displayStock() {
        System.out.println("=================================================");
        System.out.println("                    CURRENT STOCK               ");
        System.out.println("=================================================");
        System.out.printf("| %-6s | %-5s | %-10s | %-5s |%n", "Size", "Tray", "Individual", "Total");
        System.out.println("-------------------------------------------------");
        System.out.printf("| %-6s | %-5d | %-10d | %-5d |%n", "Small", trayS, indS, stockS);
        System.out.printf("| %-6s | %-5d | %-10d | %-5d |%n", "Medium", trayM, indM, stockM);
        System.out.printf("| %-6s | %-5d | %-10d | %-5d |%n", "Large", trayL, indL, stockL);
        System.out.printf("| %-6s | %-5d | %-10d | %-5d |%n", "XL", trayXL, indXL, stockXL);
       // System.out.println("=================================================");
    }
}
