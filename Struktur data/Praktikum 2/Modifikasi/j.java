import java.util.Scanner;

public class j {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();
        System.out.print("Jumlah mata kuliah: ");
        int jumlahMataKuliah = input.nextInt();
        String[] namaMahasiswa = new String[jumlahMahasiswa]; 
        String[] kodeMataKuliah = new String[jumlahMataKuliah]; 
        double[][] nilaiAbsensi = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiTugas = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiMid = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiFinal = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiAkhirMataKuliah = new double[jumlahMahasiswa][jumlahMataKuliah]; 
        String[][] nilaiHuruf = new String[jumlahMahasiswa][jumlahMataKuliah];
        double[] akumulasiNilaiAkhir = new double[jumlahMahasiswa];
        double nilaiAkhirTertinggi = -1; 
        double nilaiAkhirTerendah = 101; 
        String mahasiswaTertinggi = "";
        String mahasiswaTerendah = "";
        System.out.println("\n--- Input Nama Mahasiswa ---");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.print("Masukkan ID/Nama Mahasiswa ke-" + (i + 1) + ": ");
            namaMahasiswa[i] = input.next();
        }
        System.out.println("\n--- Input Kode Mata Kuliah (Untuk Header) ---");
        for (int j = 0; j < jumlahMataKuliah; j++) {
            System.out.print("Masukkan Kode Mata Kuliah ke-" + (j + 1) + ": ");
            kodeMataKuliah[j] = input.next();
        }
        System.out.println("\n--- Input Nilai Mahasiswa ---");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\n*** Mahasiswa: " + namaMahasiswa[i] + " ***");
            double totalNilaiAkhirSementara = 0;
            for (int j = 0; j < jumlahMataKuliah; j++) {
                System.out.println("  Mata Kuliah: " + kodeMataKuliah[j]);
                System.out.print("  Nilai Absensi: ");
                nilaiAbsensi[i][j] = input.nextDouble();
                System.out.print("  Nilai Tugas: ");
                nilaiTugas[i][j] = input.nextDouble();
                System.out.print("  Nilai Mid: ");
                nilaiMid[i][j] = input.nextDouble();
                System.out.print("  Nilai Final: ");
                nilaiFinal[i][j] = input.nextDouble();
                nilaiAkhirMataKuliah[i][j] = (0.1 * nilaiAbsensi[i][j]) + 
                                             (0.2 * nilaiTugas[i][j]) +
                                             (0.3 * nilaiMid[i][j]) + 
                                             (0.4 * nilaiFinal[i][j]);
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
                
                totalNilaiAkhirSementara += nilaiAkhirMataKuliah[i][j];
            }
            akumulasiNilaiAkhir[i] = totalNilaiAkhirSementara / jumlahMataKuliah;
            if (akumulasiNilaiAkhir[i] > nilaiAkhirTertinggi) {
                nilaiAkhirTertinggi = akumulasiNilaiAkhir[i];
                mahasiswaTertinggi = namaMahasiswa[i];
            }
            
            if (akumulasiNilaiAkhir[i] < nilaiAkhirTerendah) {
                nilaiAkhirTerendah = akumulasiNilaiAkhir[i];
                mahasiswaTerendah = namaMahasiswa[i];
            }
        }
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
        System.out.println("\n--- Akumulasi Nilai Akhir Mahasiswa (Rata-rata) ---");
        System.out.printf("%-15s | %-25s\n", "Mahasiswa", "Rata-rata Nilai Akhir (Akumulasi)");
        System.out.println("------------------------------------------");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.printf("%-15s | %-25.2f\n", namaMahasiswa[i], akumulasiNilaiAkhir[i]);
        }
        System.out.println("------------------------------------------");
        System.out.println("\n--- Nilai Akumulasi Tertinggi dan Terendah ---");
        System.out.println("Nilai Akumulasi Tertinggi:");
        System.out.printf("Mahasiswa: %s dengan Rata-rata Nilai Akhir: %.2f\n", 
        mahasiswaTertinggi, nilaiAkhirTertinggi);
        System.out.println("\nNilai Akumulasi Terendah:");
        System.out.printf("Mahasiswa: %s dengan Rata-rata Nilai Akhir: %.2f\n", 
        mahasiswaTerendah, nilaiAkhirTerendah);
        input.close();
    }
}