/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btht2;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
	private static int k;
    static void nhapTK(Account tk) {
        System.out.println("Nhap so tai khoan: ");
        tk.setSoTK(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        tk.setTenTK(sc.nextLine());
        tk.setSoTienTrongTK(50);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Ban chon lam gi: ");
            System.out.println("""
                               1.Nhap thong tin cua cac khach hang
                               2.Xuat danh sach thong tin cua cac khach hang
                               3.Nap tien
                               4.Rut tien
                               5.Dao han
                               6.Chuyen khoan
                               So khac de thoat""");
            b = sc.nextInt();
            switch (b) {
                case 1 -> {
                    System.out.println("Nhap so luong khach hang ban muon nhap: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khach hang so: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                }
                case 2 -> {
                    System.out.printf("%-10s %-20s %-20s\n", "So TK", "Ten TK", "So tien trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                }
                case 3 -> {
                    System.out.println("Nhap so tai khoan khach hang can nap tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Nhap so tai khoan khach hang can rut tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Nhap so tai khoan khach hang can dao han: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                }
                case 6 -> {
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhap so tai khoan khach hang chuyen tien: ");
                    s = sc.nextLong();
                    System.out.print("Nhap so tai khoan khach hang nhan tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSoTK();
                        if (s == d) {
                            chuyen = a[i].getSoTienTrongTK();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSoTK();
                                if (c == f) {
                                    nhan = a[j].getSoTienTrongTK();
                                    System.out.println("Nhap so tien can chuyen");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen -= tienChuyen;
                                        nhan += tienChuyen;
                                        a[i].setSoTienTrongTK(chuyen);
                                        a[j].setSoTienTrongTK(nhan);
                                        System.out.println("Tai khoan so " + d + " vua chuyen: $" + tienChuyen);
                                        System.out.println("Tai khoan so " + f + " vua nhan: $" + tienChuyen);
                                    } else {
                                        System.out.println("So tien nhap khong hop le!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                }
                default -> {
                    System.out.println("Bye!!");
                    flag = false;
                }
            }
        } while (flag);
    }
	public static int getK() {
		return k;
	}
	public static void setK(int k) {
		Main.k = k;
	}
}
