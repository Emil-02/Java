import java.util.Scanner;
public class KalkulatorTurunan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("      KALKULATOR TURUNAN & INTEGRAL");
        System.out.println("============================================");
        System.out.println(">> TAHAP 1: INISIALISASI");
        System.out.print("Masukkan Jumlah Suku (Koefisien/Pangkat): ");
        int n = input.nextInt();
        System.out.print("Masukkan Jumlah Konstanta                 : ");
        int nKonstanta = input.nextInt();
        int nOperator = n; 
        System.out.println("Jumlah operator otomatis dihitung         : " + nOperator);
        int[] koefisien = new int[n];
        int[] pangkat = new int[n];
        int[] konstanta = new int[nKonstanta];
        char[] operator = new char[nOperator];
        System.out.println("\n>> TAHAP 2: INPUT DATA");
        for (int i = 0; i < n; i++) {
            System.out.print("  - Masukkan Koefisien ke-" + (i + 1) + ": ");
            koefisien[i] = input.nextInt();
            System.out.print("  - Masukkan Pangkat ke-" + (i + 1) + "  : ");
            pangkat[i] = input.nextInt();
            System.out.println(); 
        }
        for (int i = 0; i < nKonstanta; i++) {
            System.out.print("  - Masukkan Konstanta ke-" + (i + 1) + ": ");
            konstanta[i] = input.nextInt();
        }
        System.out.println(); 
        for (int i = 0; i < nOperator; i++) {
            System.out.print("  - Masukkan Operator ke-" + (i + 1) + " (+ atau -): ");
            operator[i] = input.next().charAt(0);
        }
        System.out.println("\n============================================");
        System.out.println("              HASIL PERHITUNGAN");
        System.out.println("============================================");
        System.out.print("Persamaan Asli : ");
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            if (koefisien[i] != 1) System.out.print(koefisien[i]); 
            System.out.print("X");
            if (pangkat[i] != 1) System.out.print("^" + pangkat[i]);
        }
        for (int i = 0; i < nKonstanta; i++) {
            if (i < nOperator) {
                System.out.print(" " + operator[i] + " ");
            }
            System.out.print(konstanta[i]);
        }
        System.out.println(); 
        System.out.print("Turunan (f')   : ");
        for (int i = 0; i < n; i++) {
            int koefBaru = koefisien[i] * pangkat[i];
            int pangkatBaru = pangkat[i] - 1;
            if (koefBaru != 0) {
                if (i > 0) System.out.print(" ");
                System.out.print(koefBaru + "X");
                if (pangkatBaru != 1 && pangkatBaru != 0) {
                    System.out.print("^" + pangkatBaru);
                }
            }
        }
        System.out.println(); 
        System.out.print("Integral (F)   : ");
        for (int i = 0; i < n; i++) {
            int pembilang = koefisien[i];
            int penyebut = pangkat[i];
            int pangkatBaru = pangkat[i] + 1;
            
            if (i > 0) System.out.print(" ");
            if (pembilang % penyebut == 0) {
                 System.out.print((pembilang / penyebut));
            } else {
                 System.out.print(pembilang + "/" + penyebut);
            }
            System.out.print(" X^" + pangkatBaru);
        }
        for (int i = 0; i < nKonstanta; i++) {
            if (i < nOperator) {
                System.out.print(" " + operator[i] + " ");
            }
            System.out.print(konstanta[i] + "X");
        }
        System.out.print(" + C");
        System.out.println("\n============================================");
    }
}