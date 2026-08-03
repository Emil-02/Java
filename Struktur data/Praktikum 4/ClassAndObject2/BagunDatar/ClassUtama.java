package ClassAndObject2.BagunDatar;
public class ClassUtama {

    public static void main(String[] args) {
        
        // ... Operasi ClassTV (bagian Program 1) ...
        // (Dihapus/dikomentari untuk fokus pada Program 2)
        // --- Operasi ClassOperasiBangunDatarRuang (Program 2) ---
        ClassOperasiBangunDatarRuang h_operasi = new ClassOperasiBangunDatarRuang();
        // Operasi Bangun Datar (kode dasar)
        System.out.println("\n----------- Operasi Bangun Datar -----------");
        h_operasi.luas_persegi(5);
        System.out.print("Luas Persegi (s=5): ");
        h_operasi.tampil_luas();
        
        h_operasi.persegi_panjang(6, 3);
        System.out.print("Luas Persegi Panjang (p=6, l=3): ");
        h_operasi.tampil_luas();
                h_operasi.luas_sgtiga(4, 7);
        System.out.print("Luas Segitiga (a=4, t=7): ");
        h_operasi.tampil_luas();
        
        h_operasi.lingkaran(8);
        System.out.print("Luas Lingkaran (r=8): ");
        h_operasi.tampil_luas();
        
        // Operasi Bangun Ruang (modifikasi baru)
        System.out.println("\n----------- Operasi Bangun Ruang -----------");
        h_operasi.volume_kubus(4);
        System.out.print("Volume Kubus (s=4): ");
        h_operasi.tampil_volume(); // 4*4*4 = 64.0
        
        h_operasi.volume_balok(5, 4, 3);
        System.out.print("Volume Balok (p=5, l=4, t=3): ");
        h_operasi.tampil_volume(); // 5*4*3 = 60.0
        
        h_operasi.volume_tabung(3, 10);
        System.out.print("Volume Tabung (r=3, t=10): ");
        h_operasi.tampil_volume(); // 3.14 * 9 * 10 = 282.6
        
        h_operasi.volume_limas_segiempat(4, 5, 6);
        System.out.print("Volume Limas (p_alas=4, l_alas=5, t=6): ");
        h_operasi.tampil_volume(); // 1/3 * (4*5) * 6 = 40.0
        
        h_operasi.volume_kerucut(3, 5);
        System.out.print("Volume Kerucut (r=3, t=5): ");
        h_operasi.tampil_volume(); // 1/3 * 3.14 * 9 * 5 = 47.1
    }
}