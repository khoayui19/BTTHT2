/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btht2;

/**
 *
 * @author Admin
 */
import java.text.NumberFormat;
import java.util.Scanner;
 
public class Account {
    private long soTK;
    private String tenTK;
    private double soTienTrongTK;
 
    Scanner sc = new Scanner(System.in);
    public Account() {
    }
 
    public Account(long soTK, String tenTK, double soTienTrongTK) {
        this.soTK = soTK;
        this.tenTK = tenTK;
        this.soTienTrongTK = soTienTrongTK;
    }
    public long getSoTK() {
        return this.soTK;
    }
 
    public void setSoTK(long soTK) {
        this.soTK = soTK;
    }
 
    public String getTenTK() {
        return this.tenTK;
    }
 
    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }
 
    public double getSoTienTrongTK() {
        return this.soTienTrongTK;
    }
 
    public void setSoTienTrongTK(double soTienTrongTK) {
        this.soTienTrongTK = soTienTrongTK;
    }
 
    @Override
    public String toString() {
		NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        return soTK + "-" + tenTK + "-" + str1;
    }

    public double napTien() {
        double nap;
        System.out.print("Nhap so tien ban can nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) {
            soTienTrongTK = nap + soTienTrongTK;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("ban vua nap " + str1 + " vao tai khoan.");
        } else {
            System.out.println("So tien nap vao khong hop le!");
        }
        return nap;
    }
 
    public double rutTien() {
        double phi = 0;
        double rut;
        System.out.print("Nhap so tien ban can rut: ");
        rut = sc.nextDouble();
        if (rut <= (soTienTrongTK - phi)) {
            soTienTrongTK = soTienTrongTK - (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Ban vua rut " + str1 + "Den tu tai khoan. Phi la $0.");
        } else {
            System.out.println("So tien muon rut khong hop le!");
            return rutTien();
        }
        return rut;
    }
    public double daoHan() {
        double laiSuat = 0.035;
        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.println("Ban vua duoc " + str1 + " tu dao han 1 thang");
        return soTienTrongTK;
    }
    void inTK() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(soTienTrongTK);
        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
    }

}
