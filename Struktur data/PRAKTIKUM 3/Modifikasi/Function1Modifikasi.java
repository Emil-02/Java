import java.util.Scanner;
public class Function1Modifikasi {
    static String[] KODE_BARANG = { "A", "B", "C" };
    static String[] NAMA_BARANG = { "Barang A", "Barang B", "Barang C" };
    static double[] HARGA_BARANG = { 100.0, 200.0, 300.0 };
    static double[] DISKON_BARANG = { 0.1, 0.0, 0.0 };
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] jumlahBeli = new int[KODE_BARANG.length]; 
        tampilkanMenuPilihanBarang();
        inputJumlahBeli(input, jumlahBeli);
        double totalHarga = hitungTotalHarga(HARGA_BARANG, jumlahBeli);
        double diskonTerbesar = hitungDiskonTerbesar(jumlahBeli, DISKON_BARANG);
        double totalDiskon = hitungTotalDiskon(totalHarga, diskonTerbesar);
        double totalSetelahDiskon = totalHarga - totalDiskon;
        tampilkanTotal(totalHarga, totalDiskon, totalSetelahDiskon);
        double jumlahBayar = inputJumlahBayar(input);
        double kembalian = hitungKembalian(jumlahBayar, totalSetelahDiskon);
        tampilkanKembalian(kembalian);
        tampilkanBarangTerbesar(jumlahBeli, HARGA_BARANG, diskonTerbesar, NAMA_BARANG);
        tampilkanTotalBayarTertinggiDanTerendah(jumlahBeli, HARGA_BARANG, diskonTerbesar, NAMA_BARANG);
        input.close();
    }

    public static void tampilkanMenuPilihanBarang() {
        System.out.println(" Menu Pilihan Barang ");
        System.out.println("------------------------------------");
        System.out.printf("%-5s | %-10s | %-8s | %-5s%n", "Kode", "Nama Barang", "Harga", "Diskon");
        System.out.println("------------------------------------");
        for (int i = 0; i < KODE_BARANG.length; i++) {
            String diskonStr = String.format("", DISKON_BARANG[i] * 100);
            System.out.printf("%-5s | %-10s | %-8.2f | %-5s%n", 
                                 KODE_BARANG[i], NAMA_BARANG[i], HARGA_BARANG[i], diskonStr);
        }
        System.out.println("------------------------------------");
    }
    public static void inputJumlahBeli(Scanner input, int[] jumlahBeli) {
        System.out.println("Input Pembelian ");
        System.out.println("-------------------------");
        for (int i = 0; i < KODE_BARANG.length; i++) {
            System.out.print("Masukkan jumlah" + NAMA_BARANG[i] + 
            " (Kode " + KODE_BARANG[i] + ", 0 jika tidak beli): ");
            jumlahBeli[i] = input.nextInt();
        }
    }
    
    public static double hitungTotalHarga(double[] hargaBarang, int[] jumlahBeli) {
        double totalHarga = 0.0;
        for (int i = 0; i < hargaBarang.length; i++) {
            totalHarga += jumlahBeli[i] * hargaBarang[i];
        }
        return totalHarga;
    }

    public static double hitungDiskonTerbesar(int[] jumlahBeli, double[] diskonBarang) {
        double diskonTerbesar = 0.0;
        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] >= 3 && diskonBarang[i] > diskonTerbesar) {
                diskonTerbesar = diskonBarang[i];
            }
        }
        return diskonTerbesar;
    }

    public static double hitungTotalDiskon(double totalHarga, double diskonTerbesar) {
        return totalHarga * diskonTerbesar;
    }

    public static void tampilkanTotal(double totalHarga, double totalDiskon, double totalSetelahDiskon) {
        System.out.println("Total Pembelian");
        System.out.println("Total Harga Sebelum Diskon: " + totalHarga);
        System.out.println("Diskon yang Diterapkan: " + totalDiskon);
        System.out.println("Total Harga Setelah Diskon:" + totalSetelahDiskon);
    }

    public static double inputJumlahBayar(Scanner input) {
        System.out.print("\nJumlah Uang Bayar: ");
        return input.nextDouble();
    }

    public static double hitungKembalian(double jumlahBayar, double totalSetelahDiskon) {
        return jumlahBayar - totalSetelahDiskon;
    }

    public static void tampilkanKembalian(double kembalian) {
        System.out.println("Kembalian: " + kembalian);
    }

    public static void tampilkanBarangTerbesar(int[] jumlahBeli, double[] hargaBarang,
                                             double diskonTerbesar, String[] namaBarang) {
        double maxJumlahBayar = -1.0;
        int indeksBarangTerbesar = -1;

        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] > 0) {
                double jumlahBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar);
                if (jumlahBayarBarang > maxJumlahBayar) {
                    maxJumlahBayar = jumlahBayarBarang;
                    indeksBarangTerbesar = i;
                }
            }
        }

        System.out.println(" Analisis Pembelian ");
        if (indeksBarangTerbesar != -1) {
            System.out.println("Barang dengan Jumlah Bayar Tertinggi: " + 
                                 namaBarang[indeksBarangTerbesar] + "");
            System.out.println("Jumlah Bayar untuk barang ini: " + maxJumlahBayar);
        } else {
            System.out.println("Tidak ada barang yang dibeli.");
        }
    }

    public static void tampilkanTotalBayarTertinggiDanTerendah(int[] jumlahBeli, double[] hargaBarang,
        double diskonTerbesar, String[] namaBarang) {
        double minTotalBayar = 0.0; 
        double maxTotalBayar = 0.0; 
        String namaBarangMin = "";
        String namaBarangMax = "";
        boolean sudahDiinisialisasi = false; 
        for (int i = 0; i < jumlahBeli.length; i++) {
            if (jumlahBeli[i] > 0) {
                double totalBayarBarang = jumlahBeli[i] * hargaBarang[i] * (1.0 - diskonTerbesar);
                if (!sudahDiinisialisasi) {
                    minTotalBayar = totalBayarBarang;
                    maxTotalBayar = totalBayarBarang;
                    namaBarangMin = namaBarang[i];
                    namaBarangMax = namaBarang[i];
                    sudahDiinisialisasi = true;
                } else {
                    if (totalBayarBarang < minTotalBayar) {
                        minTotalBayar = totalBayarBarang;
                        namaBarangMin = namaBarang[i];
                    }
                    if (totalBayarBarang > maxTotalBayar) {
                        maxTotalBayar = totalBayarBarang;
                        namaBarangMax = namaBarang[i];
                    }
                }
            }
        }

        if (sudahDiinisialisasi) {
            System.out.println("\n--- Perbandingan Total Bayar per Barang ---");
            System.out.println("Total Bayar Tertinggi: " + namaBarangMax + 
                               " (Jumlah Bayar: " + maxTotalBayar + ")");
            
            if (minTotalBayar != maxTotalBayar) {
                System.out.println("Total Bayar Terendah: " + namaBarangMin + 
                                   " (Jumlah Bayar: " + minTotalBayar + ")");
            } else {
                System.out.println("Catatan: Total bayar semua barang sama.");
            }
        }
    }
}