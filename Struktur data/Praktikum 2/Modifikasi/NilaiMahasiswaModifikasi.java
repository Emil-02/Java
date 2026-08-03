import java.util.Scanner;

public class NilaiMahasiswaModifikasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Input Data Awal ---
        System.out.print("Jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();

        System.out.print("Jumlah mata kuliah: ");
        int jumlahMataKuliah = input.nextInt();

        // --- Deklarasi Array ---
        // MODIFIKASI: Array untuk menyimpan nama/ID Mahasiswa dan Kode Mata Kuliah
        String[] namaMahasiswa = new String[jumlahMahasiswa]; 
        String[] kodeMataKuliah = new String[jumlahMataKuliah]; 

        double[][] nilaiAbsensi = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiTugas = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiMid = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiFinal = new double[jumlahMahasiswa][jumlahMataKuliah];
        // MODIFIKASI: Ganti nama array agar lebih spesifik (nilaiAkhir -> nilaiAkhirMataKuliah)
        double[][] nilaiAkhirMataKuliah = new double[jumlahMahasiswa][jumlahMataKuliah]; 
        String[][] nilaiHuruf = new String[jumlahMahasiswa][jumlahMataKuliah];
        
        // MODIFIKASI: Array Baru untuk Akumulasi Nilai Akhir (Rata-rata)
        double[] akumulasiNilaiAkhir = new double[jumlahMahasiswa];
        
        // MODIFIKASI: Variabel untuk mencari nilai tertinggi dan terendah dari Akumulasi
        double nilaiAkhirTertinggi = -1; 
        double nilaiAkhirTerendah = 101; 
        String mahasiswaTertinggi = "";
        String mahasiswaTerendah = "";

        // MODIFIKASI: Input Nama Mahasiswa 
        System.out.println("\n--- Input Nama Mahasiswa ---");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.print("Masukkan ID/Nama Mahasiswa ke-" + (i + 1) + ": ");
            namaMahasiswa[i] = input.next();
        }

        // MODIFIKASI: Input Kode Mata Kuliah (Untuk Header)
        System.out.println("\n--- Input Kode Mata Kuliah (Untuk Header) ---");
        for (int j = 0; j < jumlahMataKuliah; j++) {
            System.out.print("Masukkan Kode Mata Kuliah ke-" + (j + 1) + ": ");
            kodeMataKuliah[j] = input.next();
        }

        // --- Proses Input Nilai dan Perhitungan Nilai Akhir per Mata Kuliah ---
        System.out.println("\n--- Input Nilai Mahasiswa ---");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            // MODIFIKASI: Menggunakan nama mahasiswa
            System.out.println("\nMahasiswa: " + namaMahasiswa[i] );
            // MODIFIKASI: Variabel sementara untuk menjumlahkan nilai akhir mata kuliah
            double totalNilaiAkhirSementara = 0;
            
            for (int j = 0; j < jumlahMataKuliah; j++) {
                // MODIFIKASI: Menggunakan kode mata kuliah
                System.out.println("  Mata Kuliah: " + kodeMataKuliah[j]);
                System.out.print("  Nilai Absensi: ");
                nilaiAbsensi[i][j] = input.nextDouble();
                System.out.print("  Nilai Tugas: ");
                nilaiTugas[i][j] = input.nextDouble();
                System.out.print("  Nilai Mid: ");
                nilaiMid[i][j] = input.nextDouble();
                System.out.print("  Nilai Final: ");
                nilaiFinal[i][j] = input.nextDouble();
                // Perhitungan Nilai Akhir per Mata Kuliah
                nilaiAkhirMataKuliah[i][j] = (0.1 * nilaiAbsensi[i][j]) + 
                                             (0.2 * nilaiTugas[i][j]) +
                                             (0.3 * nilaiMid[i][j]) + 
                                             (0.4 * nilaiFinal[i][j]);

                // Menentukan Nilai Huruf (Logika tetap sama)
                if (nilaiAkhirMataKuliah[i][j] >= 85) {
                    nilaiHuruf[i][j] = "A";
                } else if (nilaiAkhirMataKuliah[i][j] >= 70) {
                    nilaiHuruf[i][j] = "B";
                } else if (nilaiAkhirMataKuliah[i][j] >= 55) {
                    nilaiHuruf[i][j] = "C";
                } else if (nilaiAkhirMataKuliah[i][j] >= 40) {
                    nilaiHuruf[i][j] = "D";
                } else {
                    nilaiHuruf[i][j] = "E";
                }
                
                // MODIFIKASI: Akumulasi nilai akhir per mata kuliah
                totalNilaiAkhirSementara += nilaiAkhirMataKuliah[i][j];
            }
            
            // MODIFIKASI: Perhitungan Akumulasi Nilai Akhir (Rata-rata)
            akumulasiNilaiAkhir[i] = totalNilaiAkhirSementara / jumlahMataKuliah;

            // MODIFIKASI: Mencari Nilai Tertinggi dan Terendah dari Akumulasi
            if (akumulasiNilaiAkhir[i] > nilaiAkhirTertinggi) {
                nilaiAkhirTertinggi = akumulasiNilaiAkhir[i];
                mahasiswaTertinggi = namaMahasiswa[i];
            }
            
            if (akumulasiNilaiAkhir[i] < nilaiAkhirTerendah) {
                nilaiAkhirTerendah = akumulasiNilaiAkhir[i];
                mahasiswaTerendah = namaMahasiswa[i];
            }
        }

        // --- Menampilkan Hasil ---

        // MODIFIKASI: Pemformatan Output Rincian Nilai Akhir per Mata Kuliah
        System.out.println("\n==========================================================================");
        System.out.printf("%-15s | %-10s | %-15s | %-12s\n", "Mahasiswa", "Kode MK", "Nilai Akhir MK", "Nilai Huruf");
        System.out.println("--------------------------------------------------------------------------");

        for (int i = 0; i < jumlahMahasiswa; i++) {
            for (int j = 0; j < jumlahMataKuliah; j++) {
                System.out.printf("%-15s | %-10s | %-15.2f | %-12s\n", 
                                  namaMahasiswa[i], 
                                  kodeMataKuliah[j], 
                                  nilaiAkhirMataKuliah[i][j], 
                                  nilaiHuruf[i][j]);
            }
        }
        System.out.println("==========================================================================");

        // MODIFIKASI: Blok Output Baru untuk Akumulasi Nilai Akhir Mahasiswa
        System.out.println("\n--- Akumulasi Nilai Akhir Mahasiswa (Rata-rata) ---");
        
        System.out.printf("%-15s | %-25s\n", "Mahasiswa", "Rata-rata Nilai Akhir (Akumulasi)");
        System.out.println("------------------------------------------");
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("%-15s | %-25.2f\n", namaMahasiswa[i], akumulasiNilaiAkhir[i]);
        }
        System.out.println("------------------------------------------");

        // MODIFIKASI: Blok Output Baru untuk Nilai Akumulasi Tertinggi dan Terendah
        System.out.println("\n--- Nilai Akumulasi Tertinggi dan Terendah ---");
        
        System.out.println("Nilai Akumulasi Tertinggi:");
        System.out.printf("Mahasiswa: **%s** dengan Rata-rata Nilai Akhir: **%.2f**\n", 
                    mahasiswaTertinggi, nilaiAkhirTertinggi);
                    
        System.out.println("\nNilai Akumulasi Terendah:");
        System.out.printf("Mahasiswa: **%s** dengan Rata-rata Nilai Akhir: **%.2f**\n", 
                          mahasiswaTerendah, nilaiAkhirTerendah);

        // Tutup scanner
        input.close();
    }
}