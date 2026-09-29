/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan;
//Import library Scanner
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class LatihanBidangDatar {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        double panjang, lebar, luas, keliling;
        
        System.out.println("=== Hitung Luas & Keliling Persegi Panjang ===");
        
        System.out.print("Masukkan Panjang: ");
        panjang = input.nextDouble();
        
        System.out.print("Masukkan Lebar  : ");
        lebar = input.nextDouble();
        
        luas = panjang * lebar;
        keliling = 2 * (panjang + lebar);
        
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Persegi Panjang     : %.2f%n", luas);
        System.out.printf("Keliling Persegi Panjang : %.2f%n", keliling);
        
        input.close();
    }
}
