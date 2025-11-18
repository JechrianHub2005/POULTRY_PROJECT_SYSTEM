/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
// Egg stock tracker
public class EggStock {
    private int stockS, stockM, stockL, stockXL;

    public EggStock() { stockS = stockM = stockL = stockXL = 0; }

    public void addEggs(int s, int m, int l, int xl) {
        stockS += s; stockM += m; stockL += l; stockXL += xl;
    }

    public void deductEggs(int s, int m, int l, int xl) {
        stockS -= s; stockM -= m; stockL -= l; stockXL -= xl;
    }

    public boolean hasEnoughStock(int s, int m, int l, int xl){
        return s<=stockS && m<=stockM && l<=stockL && xl<=stockXL;
    }

    public void displayStock(){
        System.out.println("Current Egg Stock:");
        System.out.println("Small: "+stockS);
        System.out.println("Medium: "+stockM);
        System.out.println("Large: "+stockL);
        System.out.println("XL: "+stockXL);
    }
}
