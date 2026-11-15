package strudalclassnobjek;
public class ClassUtama1 {
    public static void main(String[] args) {
        // Objek RemoteTV dari ClassTV
        ClassTV RemoteTV = new ClassTV();

        RemoteTV.menu(); // Menampilkan menu
                // Operasi TV
        RemoteTV.ganti_channel(3); // Ganti channel ke Indosiar
        RemoteTV.ganti_channel(5); // Ganti channel ke SCTV
        RemoteTV.ganti_channel(9); // Ganti channel tidak terdaftar

        // Operasi Suara
        RemoteTV.tambah_suara(50); // Tambah suara 50
        RemoteTV.tambah_suara(25); // Tambah suara 25
        RemoteTV.tambah_suara(25); // Tambah suara 25 (mencapai 100)
        RemoteTV.tambah_suara(30); // Tambah suara 30 (melebihi 100)
        RemoteTV.kurang_suara(50); // Kurang suara 50
        RemoteTV.kurang_suara(50); // Kurang suara 50 (mencapai 0)
        RemoteTV.kurang_suara(20); // Kurang suara 20 (di bawah 0)

        // Operasi Kecerahan
        RemoteTV.tambah_terang(50); // Tambah terang 50
        RemoteTV.tambah_terang(50); // Tambah terang 50 (mencapai 100)
        RemoteTV.tambah_terang(70); // Tambah terang 70 (melebihi 100)
        RemoteTV.kurang_terang(30); // Kurang terang 30

        // Bagian operasi bangun datar (dari program 2)
        ClassOperasiBangunDatar h_luas = new ClassOperasiBangunDatar();
        h_luas.luas_persegi(5);
        h_luas.tampil();
        h_luas.persegi_panjang(6, 3);
        h_luas.tampil();
        h_luas.luas_sgtiga(4, 7);
        h_luas.tampil();
    }
}