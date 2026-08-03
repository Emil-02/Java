public class Array1D {
    public static void main(String[] args) {
        // Deklarasi dan Inisialisasi: Membuat array integer dengan 5 elemen
        int[] umurSiswa = new int[5];  
        // Mengisi nilai ke dalam array (menggunakan indeks 0 hingga 4)
        umurSiswa[0] = 15;
        umurSiswa[1] = 16;
        umurSiswa[2] = 15;
        umurSiswa[3] = 17;
        umurSiswa[4] = 16;
        // Mengakses dan menampilkan elemen pada indeks tertentu
        System.out.println("Umur siswa pada indeks 3 adalah: " + umurSiswa[3]); // Output: 17
        // Iterasi (Perulangan) untuk menampilkan semua elemen
        System.out.println("\nSemua umur siswa:");
        for (int i = 0; i < umurSiswa.length; i++) {
            System.out.println("Indeks " + i + ": " + umurSiswa[i]);
        }
    }
}