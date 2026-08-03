import java.util.Scanner;
public class NilaiMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();
        System.out.print("Jumlah mata kuliah: ");
        int jumlahMataKuliah = input.nextInt();
        String[][] mahasiswa = new String[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiAbsensi = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiTugas = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiMid = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiFinal = new double[jumlahMahasiswa][jumlahMataKuliah];
        double[][] nilaiAkhir = new double[jumlahMahasiswa][jumlahMataKuliah];
        String[][] nilaiHuruf = new String[jumlahMahasiswa][jumlahMataKuliah];
        double[] maxNilaiAkhir = new double[jumlahMataKuliah];
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            for (int j = 0; j < jumlahMataKuliah; j++) {
                System.out.print("Kode Mata Kuliah: ");
                mahasiswa[i][j] = input.next();
                System.out.print("Nilai Absensi: ");
                nilaiAbsensi[i][j] = input.nextDouble();
                System.out.print("Nilai Tugas: ");
                nilaiTugas[i][j] = input.nextDouble();
                System.out.print("Nilai Mid: ");
                nilaiMid[i][j] = input.nextDouble();
                System.out.print("Nilai Final: ");
                nilaiFinal[i][j] = input.nextDouble();
                nilaiAkhir[i][j] = (0.1 * nilaiAbsensi[i][j]) + (0.2 * nilaiTugas[i][j]) +
                                  (0.3 * nilaiMid[i][j]) + (0.4 * nilaiFinal[i][j]);

                if (nilaiAkhir[i][j] >= 85) {
                    nilaiHuruf[i][j] = "A";
                } else if (nilaiAkhir[i][j] >= 70) {
                    nilaiHuruf[i][j] = "B";
                } else if (nilaiAkhir[i][j] >= 55) {
                    nilaiHuruf[i][j] = "C";
                } else if (nilaiAkhir[i][j] >= 40) {
                    nilaiHuruf[i][j] = "D";
                } else {
                    nilaiHuruf[i][j] = "E";
                }

                if (nilaiAkhir[i][j] > maxNilaiAkhir[j]) {
                    maxNilaiAkhir[j] = nilaiAkhir[i][j];
                }
            }
        }
        System.out.println("Daftar nilai mahasiswa:");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mahasiswa | Kode MK | Nilai Akhir | Nilai Huruf");
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            for (int j = 0; j < jumlahMataKuliah; j++) {
                System.out.println("Mahasiswa ke-" + (i + 1) + " | " + mahasiswa[i][j] + " | " +
                                   nilaiAkhir[i][j] + " | " + nilaiHuruf[i][j]);
            }
        }
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Nilai tertinggi untuk Mahasiswa ke-" + (i + 1) + ": " + maxNilaiAkhir[i]);
        }
    }
}
