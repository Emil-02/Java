public class ClassBukuEmil {
    // Attributes
    String ErJudul;
    String ErPengarang;
    double ErHarga;
    int ErHalaman;
    // Constructor
    public ClassBukuEmil(String ErJudul, String ErPengarang, double ErHarga, int ErHalaman) {
        this.ErJudul = ErJudul;
        this.ErPengarang = ErPengarang;
        this.ErHarga = ErHarga;
        this.ErHalaman = ErHalaman;
    }
    // Method tampilkan info
    public void tampilkanInfo() {
        System.out.println("Judul: " + ErJudul);
        System.out.println("Pengarang: " + ErPengarang);
        System.out.println("Harga: Rp" + ErHarga);
        System.out.println("Halaman: " + ErHalaman);
    }
    // Method hitung diskon
    public double hitungDiskon(int ErPersen) {
        return ErHarga - (ErHarga * ErPersen / 100.0);
    }
    // Method isTebal
    public boolean isTebal() {
        return ErHalaman > 300;
    }
    // Main untuk tes
    public static void main(String[] args) {
        ClassBukuEmil ErBuku1 = new ClassBukuEmil("Buku Dongen", "Emil Rahmat", 63000, 307);
        ErBuku1.tampilkanInfo();
        System.out.println("Harga setelah diskon 10%: Rp" + ErBuku1.hitungDiskon(10));
        System.out.println("apa buku tebal? " + ErBuku1.isTebal());
    }
}
