import java.util.Scanner;
public class PembelianBarangModifikasi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] kodeBarang = {"A", "B", "C"};
        String[] namaBarang = {"Barang A (Buku)", "Barang B (Pensil)", "Barang C (Tas)"};
        double[] hargaBarang = {50000.0, 5000.0, 150000.0};
        double[] diskonBarang = {0.15, 0.05, 0.20}; 
        int[] jumlahBeli = new int[kodeBarang.length];
        double totalHarga = 0.0;
        System.out.println("===== SELAMAT DATANG DI TOKO KAMI =====");
        while (true) {
            System.out.println("\n--- Daftar Barang ---");
            for (int i = 0; i < kodeBarang.length; i++) {
                System.out.println(kodeBarang[i] + ". " + namaBarang[i] + " (Rp " + hargaBarang[i] + ")");
            }
            System.out.print("\nMasukkan Kode Barang (A/B/C) atau 'S' untuk Selesai: ");
            String pilihan = input.next().toUpperCase(); 
            if (pilihan.equals("S")) {
                break; 
            }
            int indeksPilihan = -1;
            for (int i = 0; i < kodeBarang.length; i++) {
                if (kodeBarang[i].equals(pilihan)) {
                    indeksPilihan = i;
                    break;
                }
            }
            if (indeksPilihan != -1) {
                System.out.print("Masukkan jumlah beli " + namaBarang[indeksPilihan] + ": ");
                int jumlah = input.nextInt();
                if (jumlah > 0) {
                    jumlahBeli[indeksPilihan] += jumlah; 
                    System.out.println("-> " + jumlah + " " + namaBarang[indeksPilihan] + " ditambahkan.");
                } else {
                    System.out.println("Jumlah tidak valid.");
                }
            } else {
                System.out.println("Kode barang tidak valid.");
            }
        }
        System.out.println("\n--- Struk Pembayaran ---");
        System.out.println("Barang yang Dibeli:");
        for (int i = 0; i < kodeBarang.length; i++) {
            if (jumlahBeli[i] > 0) {
                System.out.println("- " + namaBarang[i] + " x" + jumlahBeli[i]);
                totalHarga += jumlahBeli[i] * hargaBarang[i];
            }
        }
        double totalSetelahDiskon = 0.0;
        double totalDiskon = 0.0;

        double diskonTerbesar = 0.0;
        for (int i = 0; i < kodeBarang.length; i++) {
            double diskon = diskonBarang[i];
            if (jumlahBeli[i] >= 3 && diskon > diskonTerbesar) {
                diskonTerbesar = diskon;
            }
        }
        totalDiskon = totalHarga * diskonTerbesar;
        totalSetelahDiskon = totalHarga - totalDiskon;
        System.out.println("--------------------------");
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("Diskon Global (" + (diskonTerbesar * 100) + "%): Rp " + totalDiskon);
        System.out.println("Total Harga Setelah Diskon: Rp " + totalSetelahDiskon);
        System.out.println("--------------------------");
        System.out.print("Jumlah Uang Bayar: Rp ");
        double jumlahBayar = input.nextDouble();
        double kembalian = jumlahBayar - totalSetelahDiskon;
        System.out.println("Kembalian: Rp " + kembalian);
        System.out.println("--------------------------");
        
        double minJumlahBayar = Double.MAX_VALUE;
        int indeksBarangTerkecil = -1;
        for (int i = 0; i < kodeBarang.length; i++) {
            if (jumlahBeli[i] > 0) { 
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar);
                if (jumlahBayarBarang < minJumlahBayar) {
                    minJumlahBayar = jumlahBayarBarang;
                    indeksBarangTerkecil = i;
                }
            }
        }
        if (indeksBarangTerkecil != -1) {
            System.out.println("Barang dengan Jumlah Bayar Terendah (Setelah Diskon): " +
                    namaBarang[indeksBarangTerkecil]);
            System.out.println("Jumlah Bayar: Rp " + minJumlahBayar);
        } else {
            System.out.println("Tidak ada barang yang dibeli.");
        }
        System.out.println("Terima kasih telah berbelanja!");
        input.close();
    }
}
