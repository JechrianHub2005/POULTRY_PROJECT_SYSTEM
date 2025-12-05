
// here ag Service(Operation) = mo tawag ra sa EggStock methods
public class EggStockService {
    
    // EggStock object — mao ni actual storage sa eggs(tray-indi)
    private EggStock stock = new EggStock();

// tanan g input sa worker e padala ddtus stockEgg call rag method // trabahu niya nagpasa rag stock sa g input
    public void collectEggs(int sTray,int sInd,int mTray,int mInd,
                            int lTray,int lInd,int xlTray,int xlInd) {
        stock.addEggs(sTray, sInd, mTray, mInd, lTray, lInd, xlTray, xlInd);
        System.out.println("Eggs successfully collected!");
    }

 // Method for the sell Egg Logic (if true tanan Deduct eggs Save transaction Return TRUE (success))
    public boolean sellEggs(int sTray,int sInd,int mTray,int mInd,
                            int lTray,int lInd,int xlTray,int xlInd,
                            double cash, TransactionService ts, String buyer) {
        // Check stock only, message will be handled in MenuService
        if(stock.hasEnoughStock(sTray,sInd,mTray,mInd,lTray,lInd,xlTray,xlInd)) {
             // mao nig totalTanan nga egg per size
            int s = sTray*30 + sInd;
            int m = mTray*30 + mInd;
            int l = lTray*30 + lInd;
            int xl = xlTray*30 + xlInd;
               
          //  Kuha total amount from TransactionService sa by prices
            double total = ts.calculateTotal(s,m,l,xl);
            if(cash >= total) {
                stock.deductEggs(sTray,sInd,mTray,mInd,lTray,lInd,xlTray,xlInd);
                ts.recordTransaction(buyer,s,m,l,xl,total,cash);
                return true;
            }
            // Cash check handled in MenuService
        }
        return false; // insufficient stock or other failure
    }
    
   // wrapper method pasa rag checking sa stock dle direct mo accesag ui menu sa eggstock
    public boolean hasEnoughStock(int sTray,int sInd,int mTray,int mInd,
                                  int lTray,int lInd,int xlTray,int xlInd) {
        return stock.hasEnoughStock(sTray,sInd,mTray,mInd,lTray,lInd,xlTray,xlInd);
    }
    //bag ong gipa gama
    public boolean hasEnoughByPieces(int s,int m,int l,int xl) {
    return stock.hasEnoughByPieces(s,m,l,xl);
}


    public void displayStock() {
        stock.displayStock();
    }
}
