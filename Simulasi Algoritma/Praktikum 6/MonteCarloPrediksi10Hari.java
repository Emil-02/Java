import java.util.Random;
public class MonteCarloPrediksi10Hari {

    public static void main(String[] args) throws InterruptedException {

        int[][] dataHistoris = {
                {4, 5},
                {5, 10},
                {6, 15},
                {7, 30},
                {8, 25},
                {9, 15}
        };

        int totalFrekuensi = hitungTotalFrekuensi(dataHistoris);

        // --- BAGIAN 1: MENAMPILKAN DATA HISTORIS & DISTRIBUSI ---
        System.out.println("===========================================");
        System.out.println("    ANALISA DATA HISTORIS PERMINTAAN");
        System.out.println("===========================================");
        
        System.out.println("Data Historis Permintaan:");
        Thread.sleep(1000); 
        for (int[] data : dataHistoris) {
            System.out.println("Permintaan " + data[0] + " unit = " + data[1] + " kali");
            Thread.sleep(1000); 
        }

        System.out.println("\nDistribusi Densitas:");
        double[][] distribusiDensitas = hitungDistribusiDensitas(dataHistoris, totalFrekuensi);
        for (double[] densitas : distribusiDensitas) {
            System.out.println("Permintaan " + (int) densitas[0] + " unit = " + densitas[1]);
            Thread.sleep(1000);
        }

        System.out.println("\nKumulatif Distribusi Densitas:");
        double[][] kumulatifDistribusi = hitungKumulatifDistribusi(distribusiDensitas);
        for (double[] kumulatif : kumulatifDistribusi) {
            System.out.println("Permintaan " + (int) kumulatif[0] + " unit = " + kumulatif[1]);
            Thread.sleep(1000);
        }

        // --- BAGIAN 2: SIMULASI 10 HARI (MODIFIKASI DISINI) ---
        System.out.println("\n===========================================");
        System.out.println("   MULAI SIMULASI PREDIKSI 10 HARI");
        System.out.println("===========================================");
        Random random = new Random();
        int totalPermintaan = 0; 
        for (int hari = 1; hari <= 10; hari++) {
            double nilaiRandom = random.nextDouble();
            int permintaanYangDipilih = seleksiPermintaanBerbasisRandom(kumulatifDistribusi, nilaiRandom);
            totalPermintaan += permintaanYangDipilih;
            System.out.println("HARI KE-" + hari + ":");
            System.out.println("  -> Nilai Random : " + nilaiRandom);
            System.out.println("  -> Prediksi     : " + permintaanYangDipilih + " unit");
            System.out.println("-------------------------------------------");
            Thread.sleep(1000);
        }
        double rataRata = (double) totalPermintaan / 10;
        System.out.println("\n=== KESIMPULAN SIMULASI ===");
        System.out.println("Total Prediksi (10 Hari) : " + totalPermintaan + " unit");
        System.out.println("Rata-rata Permintaan     : " + rataRata + " unit/hari");
    }
    public static int hitungTotalFrekuensi(int[][] dataHistoris) {
        int total = 0;
        for (int[] data : dataHistoris) {
            total += data[1];
        }
        return total;
    }
    public static double[][] hitungDistribusiDensitas(int[][] dataHistoris, int totalFrekuensi) {
        double[][] distribusiDensitas = new double[dataHistoris.length][2];
        for (int i = 0; i < dataHistoris.length; i++) {
            distribusiDensitas[i][0] = dataHistoris[i][0];
            distribusiDensitas[i][1] = (double) dataHistoris[i][1] / totalFrekuensi;
        }
        return distribusiDensitas;
    }
    public static double[][] hitungKumulatifDistribusi(double[][] distribusiDensitas) {
        double[][] kumulatifDistribusi = new double[distribusiDensitas.length][2];
        double kumulatif = 0;
        for (int i = 0; i < distribusiDensitas.length; i++) {
            kumulatif += distribusiDensitas[i][1];
            kumulatifDistribusi[i][0] = distribusiDensitas[i][0];
            kumulatifDistribusi[i][1] = kumulatif;
        }
        return kumulatifDistribusi;
    }
    public static int seleksiPermintaanBerbasisRandom(double[][] kumulatifDistribusi, double nilaiRandom) {
        for (double[] data : kumulatifDistribusi) {
            if (nilaiRandom <= data[1]) {
                return (int) data[0];
            }
        }
        return (int) kumulatifDistribusi[kumulatifDistribusi.length - 1][0];
    }
}