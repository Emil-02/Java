package Modifikasi;
import java.util.Random;
public class GredyPecahan
{
    public static void main(String[] args) {
        int[] pecahan = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 100};
        Random random = new Random();
        int Jumlah = random.nextInt(1000000) + 100;
        int jumlahAwal = Jumlah; 
        System.out.println(" Simulasi Pembayaran Uang Pecahan (Greedy) ");
        try {
            System.out.println("Jumlah uang yang harus dipecah (RANDOM): " + jumlahAwal + "\n");
            Thread.sleep(2000);
            System.out.println("Mencari pecahan optimal...");
            Thread.sleep(1500); 
            for (int i = 0; i < pecahan.length; i++) {
                if (Jumlah >= pecahan[i]) {
                    int n = Jumlah / pecahan[i];
                    Jumlah %= pecahan[i];
                    System.out.print("Pecahan " + pecahan[i] + " digunakan sebanyak " + n);
                    System.out.println(" | Sisa: " + Jumlah);
                    Thread.sleep(1000); 
                }
            }
            System.out.println("\n Simulasi Selesai ");
            if (Jumlah > 0) {
                 System.out.println("Tersisa uang yang tidak bisa dipecah: " + Jumlah);
            }
            
        } catch (InterruptedException e) {
            System.out.println("Simulasi terganggu.");
            Thread.currentThread().interrupt(); 
        }
    }
}