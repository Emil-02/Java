package EventDiskrit;
import java.util.Random;

public class SimulasiAntrianTanpaRata {
    static Random random = new Random();

    public static void main(String[] args) {
        // --- KONFIGURASI BATASAN ---
        int batasPasien = 5;       
        int batasWaktu = 50; // Batas pendaftaran ditutup menit ke-50

        // Variabel Sistem
        int waktuSelesaiDokter = 0; 
        int waktuGlobal = 0;
        
        // Variabel Statistik (Total)
        int jumlahPasien = 0;
        int countGigi = 0;
        int countTHT = 0;
        
        int totalWaktuDatang = 0;
        int totalWaktuTunggu = 0;
        int totalWaktuSelesai = 0;
        int totalWaktuLayanan = 0;

        System.out.println("=== SIMULASI KLINIK (OUTPUT FINAL) ===");
        System.out.println("-------------------------------------");

        // Loop sampai 5 pasien
        while (jumlahPasien < batasPasien) {
            
            // 1. Tentukan Waktu Kedatangan
            int jeda = random.nextInt(11); // 0-10 menit
            
            // Cek apakah waktu sudah lewat batas pendaftaran?
            if ((waktuGlobal + jeda) > batasWaktu) {
                System.out.println("\n[INFO] Waktu sudah menit ke-" + (waktuGlobal + jeda) + ". Pendaftaran Ditutup.");
                break;
            }

            waktuGlobal += jeda; // Update waktu sekarang
            jumlahPasien++;      // Pasien masuk

            // 2. Tentukan Poli & Durasi
            boolean isGigi = random.nextBoolean();
            String namaPoli = isGigi ? "GIGI" : "THT";
            if (isGigi) countGigi++; else countTHT++;
            
            int lamaLayanan = random.nextInt(16) + 5; // 5-20 menit

            // 3. Hitung Logika Antrian
            int waktuMulai = Math.max(waktuGlobal, waktuSelesaiDokter);
            int durasiTunggu = waktuMulai - waktuGlobal;
            int waktuSelesai = waktuMulai + lamaLayanan;
            
            waktuSelesaiDokter = waktuSelesai; // Update status dokter

            // 4. Simpan Data Statistik
            totalWaktuDatang += waktuGlobal;
            totalWaktuTunggu += durasiTunggu;
            totalWaktuSelesai += waktuSelesai;
            totalWaktuLayanan += lamaLayanan;

            // 5. CETAK OUTPUT PER PASIEN (GAYA LAPTOP)
            System.out.println("Pasien " + jumlahPasien + " datang pada menit ke-" + waktuGlobal);
            System.out.println("   -> Pasien " + jumlahPasien + " ke Poli " + namaPoli + " | Tunggu: " + durasiTunggu + " | Selesai menit ke-" + waktuSelesai);
            System.out.println(); // Jarak antar pasien

            try { Thread.sleep(500); } catch (Exception e) {}
        }

        // --- TAMPILKAN REKAP (TANPA RATA-RATA) ---
        System.out.println("=== HASIL AKHIR SIMULASI ===");
        System.out.println("Batas Pasien (Max)      : " + batasPasien);
        System.out.println("Batas Waktu Pendaftaran : " + batasWaktu + " Menit");
        System.out.println("----------------------------");
        System.out.println("Total Pasien Dilayani   : " + jumlahPasien);
        System.out.println("   - Pasien Poli GIGI   : " + countGigi);
        System.out.println("   - Pasien Poli THT    : " + countTHT);
        System.out.println("----------------------------");
        System.out.println("Total Waktu Kedatangan  : " + totalWaktuDatang);
        System.out.println("Total Waktu Pelayanan   : " + totalWaktuLayanan);
        System.out.println("Total Waktu Tunggu      : " + totalWaktuTunggu);
        System.out.println("Total Waktu Selesai     : " + totalWaktuSelesai);
        System.out.println("============================");
    }
}