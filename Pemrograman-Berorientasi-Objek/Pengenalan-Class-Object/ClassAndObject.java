// Definisi Class
class Hewan {
    // 1. Atribut (Sifat/Properti)
    String nama;
    String warnaBulu;
    int umur;

    // 2. Method (Perilaku/Fungsi)
    void bersuara() {
        System.out.println(nama + " berbunyi: Meong! Meong!");
    }

    void tidur() {
        System.out.println(nama + " sedang tidur nyenyak.");
    }
}
public class ClassAndObject {
    public static void main(String[] args) {
        // --- Membuat Object (Instance) Pertama ---
        // Menggunakan kata kunci 'new' untuk membuat object dari class Kucing
        Hewan Kucing = new Hewan();
        // Mengisi nilai ke Atribut Object siPus
        Kucing.nama = "Catti";
        Kucing.warnaBulu = "Oren";
        Kucing.umur = 3;

        // Memanggil Method (Perilaku) dari Object siPus
        System.out.println("Nama: " + Kucing.nama + ", Warna: " + Kucing.warnaBulu + ", Umur: " + Kucing.umur + " tahun.");
        Kucing.bersuara(); // Output: Si Pus berbunyi: Meong! Meong!
        Kucing.tidur();
    }
}