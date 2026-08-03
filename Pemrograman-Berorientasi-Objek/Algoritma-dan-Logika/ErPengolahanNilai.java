import java.util.Arrays;
import java.util.Scanner;

/**
 * Kelas ini mengimplementasikan algoritma pencarian dan pengurutan sederhana
 * untuk data nilai siswa sesuai dengan Latihan 4.
 *
 * NAMA FILE INI HARUS: ErPengolahanNilai.java
 */
public class PencarianDanSortingEmil {

    /**
     * Mengurutkan array integer menggunakan algoritma Bubble Sort.
     * Proses pengurutan ditampilkan langkah demi langkah.
     *
     * @param ErDataArray Array yang akan diurutkan.
     */
    public void ErBubbleSort(int[] ErDataArray) {
        int ErPanjangArray = ErDataArray.length;
        System.out.println("--- Proses Bubble Sort Step-by-Step ---");
        System.out.println("Array Awal: " + Arrays.toString(ErDataArray));
        System.out.println("----------------------------------------");

        for (int ErLangkah = 0; ErLangkah < ErPanjangArray - 1; ErLangkah++) {
            boolean ErAdaPertukaran = false;
            for (int ErIndeks = 0; ErIndeks < ErPanjangArray - ErLangkah - 1; ErIndeks++) {
                if (ErDataArray[ErIndeks] > ErDataArray[ErIndeks + 1]) {
                    int ErTemp = ErDataArray[ErIndeks];
                    ErDataArray[ErIndeks] = ErDataArray[ErIndeks + 1];
                    ErDataArray[ErIndeks + 1] = ErTemp;
                    ErAdaPertukaran = true;
                }
            }
            System.out.println("Setelah Langkah ke-" + (ErLangkah + 1) + ": " + Arrays.toString(ErDataArray));
            if (!ErAdaPertukaran) {
                System.out.println("Tidak ada lagi pertukaran, array sudah terurut sempurna.");
                break;
            }
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Mencari nilai dalam array menggunakan algoritma Linear Search.
     *
     * @param ErDataArray Array tempat pencarian.
     * @param ErNilaiDicari Nilai yang ingin dicari.
     * @return Indeks dari nilai yang ditemukan, atau -1 jika tidak ditemukan.
     */
    public int ErLinearSearch(int[] ErDataArray, int ErNilaiDicari) {
        for (int ErIndeks = 0; ErIndeks < ErDataArray.length; ErIndeks++) {
            if (ErDataArray[ErIndeks] == ErNilaiDicari) {
                return ErIndeks;
            }
        }
        return -1;
    }

    /**
     * Menghitung dan menampilkan statistik data (minimum, maksimum, rata-rata).
     *
     * @param ErDataArray Array yang akan dianalisis.
     */
    public void ErTampilkanStatistik(int[] ErDataArray) {
        if (ErDataArray == null || ErDataArray.length == 0) {
            System.out.println("Array kosong, statistik tidak dapat dihitung.");
            return;
        }
        int ErMin = ErDataArray[0];
        int ErMaks = ErDataArray[0];
        double ErTotal = 0;
        for (int ErNilai : ErDataArray) {
            if (ErNilai < ErMin) ErMin = ErNilai;
            if (ErNilai > ErMaks) ErMaks = ErNilai;
            ErTotal += ErNilai;
        }
        double ErRataRata = ErTotal / ErDataArray.length;
        System.out.println("--- Statistik Data ---");
        System.out.println("Nilai Minimum  : " + ErMin);
        System.out.println("Nilai Maksimum : " + ErMaks);
        System.out.printf("Rata-rata      : %.2f\n", ErRataRata);
    }

    /**
     * Metode utama untuk menjalankan seluruh program.
     * Metode ini harus berada DI DALAM kelas ErPengolahanNilai.
     */
    public static void main(String[] args) {
        // Inisialisasi data nilai siswa
        int[] ErNilaiSiswa = {75, 87, 68, 92, 81, 79, 95, 71};

        // Membuat objek dari kelas ini agar metode non-statis bisa dipanggil
        PencarianDanSortingEmil ErProses = new PencarianDanSortingEmil();
        Scanner ErScanner = new Scanner(System.in);

        System.out.println("Data Nilai Awal: " + Arrays.toString(ErNilaiSiswa));
        System.out.println("========================================\n");

        // 1. Menampilkan Statistik Data
        ErProses.ErTampilkanStatistik(ErNilaiSiswa);
        System.out.println("\n========================================\n");

        // 2. Mengurutkan array dengan Bubble Sort
        int[] ErDataUrut = Arrays.copyOf(ErNilaiSiswa, ErNilaiSiswa.length);
        ErProses.ErBubbleSort(ErDataUrut);
        System.out.println("Hasil Akhir Array Terurut: " + Arrays.toString(ErDataUrut));
        System.out.println("\n========================================\n");

        // 3. Mencari nilai dengan Linear Search
        System.out.println("--- Pencarian Linear ---");
        System.out.print("Masukkan nilai siswa yang ingin Anda cari: ");
        int ErNilaiCari = ErScanner.nextInt();

        // Pencarian dilakukan pada data asli (sebelum diurutkan)
        int ErIndeksHasil = ErProses.ErLinearSearch(ErNilaiSiswa, ErNilaiCari);
        if (ErIndeksHasil != -1) {
            System.out.println("-> Nilai " + ErNilaiCari + " ditemukan pada indeks ke-" + ErIndeksHasil + " (dalam data awal).");
        } else {
            System.out.println("-> Maaf, nilai " + ErNilaiCari + " tidak ditemukan dalam data siswa.");
        }
        ErScanner.close();
    }
}