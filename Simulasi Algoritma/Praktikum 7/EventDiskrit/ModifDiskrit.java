package EventDiskrit;
import java.util.Random;
public class ModifDiskrit {
    static Random random = new Random();
    static final int MAX_PASIEN = 5;           
    static final int BATAS_WAKTU = 100;        
    static int waktuBebasDokter = 0;           
    static int waktuSekarang = 0;              
    static int totalGigi = 0;
    static int totalTHT = 0;
    static int totalTunggu = 0;
    static int totalLayanan = 0;
    public static void main(String[] args) {
        System.out.println("=== SIMULASI KLINIK ===");
        System.out.println("--------------------------------------");
        int pasienKe = 0;
        while (pasienKe < MAX_PASIEN) {
            int jeda = random.nextInt(10) + 1; 
            try {
                Thread.sleep(jeda * 300); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int prediksiDatang = waktuSekarang + jeda;
            if (prediksiDatang > BATAS_WAKTU) {
                break; 
            }
            waktuSekarang = prediksiDatang;
            pasienKe++;
            String poli = "";
            if (random.nextInt(2) == 0) {
                poli = "GIGI";
                totalGigi++;
            } else {
                poli = "THT";
                totalTHT++;
            }
            int durasi = random.nextInt(15) + 10;
            totalLayanan += durasi;
            int tunggu = 0;
            int selesai = 0;
            if (waktuSekarang < waktuBebasDokter) {
                tunggu = waktuBebasDokter - waktuSekarang;
                selesai = waktuBebasDokter + durasi;
            } else {
                tunggu = 0;
                selesai = waktuSekarang + durasi;
            }
            totalTunggu += tunggu;
            waktuBebasDokter = selesai;
            System.out.println("Pasien " + pasienKe + " datang pada menit ke-" + waktuSekarang);
            System.out.println("   Pasien " + pasienKe + " ke Poli " + poli + 
                               " | Tunggu: " + tunggu + 
                               " | Selesai menit ke-" + selesai);
            System.out.println();
        }
        System.out.println("============================================================");
        System.out.println("           REKAPITULASI STATISTIK AKHIR");
        System.out.println("============================================================");
        System.out.println("1. Total Pasien Keseluruhan   : " + pasienKe + " orang");
        System.out.println("   - Pasien Poli GIGI         : " + totalGigi + " orang");
        System.out.println("   - Pasien Poli THT          : " + totalTHT + " orang");
        System.out.println("------------------------------------------------------------");
        System.out.println("2. Total Waktu Kedatangan     : Menit ke-" + waktuSekarang + " (Pasien terakhir)");
        System.out.println("3. Total Waktu Pelayanan      : " + totalLayanan + " menit (Total kerja dokter)");
        System.out.println("4. Total Waktu Tunggu         : " + totalTunggu + " menit (Total tunggu pasien)");
        System.out.println("5. Waktu Sistem Berakhir      : Menit ke-" + waktuBebasDokter + " (Klinik Tutup)");
        System.out.println("============================================================");
    }
}