import java.util.Random;

public class MonteCarloMODEIFIKASI {
    public static void main(String[] args) throws InterruptedException {
        // Data historis [permintaan, frekuensi]
        int[][] dataHistoris = {
            {4, 5},
            {5, 10},
            {6, 15},
            {3, 30},
            {8, 25},
            {9, 15}
        };

        // Total frekuensi
        int totalFrekuensi = hitungTotalFrekuensi(dataHistoris);

        // Menampilkan data historis dengan delay
        System.out.println("Data historis permintaan:");
        for (int data[] : dataHistoris) {
            System.out.println("Permintaan " + data[0] + ", Unit = " + data[1] + " kali");
            Thread.sleep(1000);
        }

        // Menghitung distribusi densitas
        System.out.println("\nDistribusi densitas:");
        double[][] distribusiDensitas = hitungDistribusiDensitas(dataHistoris, totalFrekuensi);
        for (double[] densitas : distribusiDensitas) {
            System.out.println("Permintaan " + (int) densitas[0] + ", Densitas = " + String.format("%.2f", densitas[1]));
            Thread.sleep(1000);
        }

        // Hitung Komulatif distribusi densitas
        System.out.println("\nKomulatif distribusi densitas:");
        double[][] komulatifDistribusi = hitungKomulatifDistribusi(distribusiDensitas);
        for (double[] komulatif : komulatifDistribusi) {
            System.out.println("Permintaan " + (int) komulatif[0] + ", Komulatif = " + String.format("%.2f", komulatif[1]));
            Thread.sleep(1000);
        }

        // Simulasi prediksi penjualan 10 hari
        System.out.println("\nSimulasi prediksi penjualan 10 hari:");
        Random random = new Random();
        int totalPenjualan = 0;
        for (int hari = 1; hari <= 10; hari++) {
            double randomValue = random.nextDouble(); // Nilai acak antara 0 dan 1
            int permintaanHariIni = seleksiPermintaanBerbasisRandom(komulatifDistribusi, randomValue);
            totalPenjualan += permintaanHariIni;

            // Menampilkan Random Number dan Permintaan dengan 3 angka desimal
            System.out.println("Hari ke-" + hari + ": Random Number = " + String.format("%.2f", randomValue)
                + ", Permintaan = " + permintaanHariIni + " unit");
            Thread.sleep(1000);
        }

        // Rata-rata penjualan
        double rataRataPenjualan = (double) totalPenjualan / 10;
        System.out.println("\nRata-rata penjualan per hari: " + String.format("%.2f", rataRataPenjualan) + " unit");
    }

    public static int hitungTotalFrekuensi(int[][] dataHistoris) {
        int totalFrekuensi = 0;
        for (int data[] : dataHistoris) {
            totalFrekuensi += data[1];
        }
        return totalFrekuensi;
    }

    public static double[][] hitungDistribusiDensitas(int[][] dataHistoris, int totalFrekuensi) {
        double[][] distribusiDensitas = new double[dataHistoris.length][2];
        for (int i = 0; i < dataHistoris.length; i++) {
            distribusiDensitas[i][0] = dataHistoris[i][0];
            distribusiDensitas[i][1] = (double) dataHistoris[i][1] / totalFrekuensi;
        }
        return distribusiDensitas;
    }

    public static double[][] hitungKomulatifDistribusi(double[][] distribusiDensitas) {
        double[][] komulatifDistribusi = new double[distribusiDensitas.length][2];
        double kumulatif = 0;
        for (int i = 0; i < distribusiDensitas.length; i++) {
            kumulatif += distribusiDensitas[i][1];
            komulatifDistribusi[i][0] = distribusiDensitas[i][0];
            komulatifDistribusi[i][1] = kumulatif;
        }
        return komulatifDistribusi;
    }

    public static int seleksiPermintaanBerbasisRandom(double[][] komulatifDistribusi, double nilaiRandom) {
        for (double[] komulatif : komulatifDistribusi) {
            if (nilaiRandom <= komulatif[1]) {
                return (int) komulatif[0];
            }
        }
        return 0;
    }
}