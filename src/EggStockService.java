/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// Handle collecting & selling eggs
public class EggStockService {
    private EggStock stock = new EggStock();

    public void collectEggs(int sTray,int sInd,int mTray,int mInd,
                            int lTray,int lInd,int xlTray,int xlInd){
        int s = sTray*30 + sInd;
        int m = mTray*30 + mInd;
        int l = lTray*30 + lInd;
        int xl = xlTray*30 + xlInd;

        stock.addEggs(s,m,l,xl);
        System.out.println("Eggs successfully collected!");
    }

    public boolean sellEggs(int sTray,int sInd,int mTray,int mInd,
                            int lTray,int lInd,int xlTray,int xlInd,
                            double cash, TransactionService ts, String buyer){
        int s = sTray*30 + sInd;
        int m = mTray*30 + mInd;
        int l = lTray*30 + lInd;
        int xl = xlTray*30 + xlInd;

        if(stock.hasEnoughStock(s,m,l,xl)){
            double total = ts.calculateTotal(s,m,l,xl);
            if(cash>=total){
                stock.deductEggs(s,m,l,xl);
                ts.recordTransaction(buyer,s,m,l,xl,total,cash);
                return true;
            } else System.out.println("Insufficient cash!");
        } else System.out.println("Not enough stock!");
        return false;
    }

    public void displayStock(){ stock.displayStock(); }
}
