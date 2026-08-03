import LinkList.Operasi;

import Operasi;

package LinkList;
public class Main {
    public static void main(String[] args) {
        // Membuat objek dari kelas Operasi
        Operasi listSaya = new Operasi();

        System.out.println("=== DEMONSTRASI LINKED LIST ===");

        // 1. Demonstrasi Sisip Depan
        System.out.println("\n[1] Melakukan Sisip Depan (Angka 10)");
        listSaya.sisip_depan(10);
        System.out.print("Isi List: ");
        listSaya.tampil();

        // 2. Demonstrasi Sisip Belakang (Method 'sisip' biasa)
        System.out.println("\n[2] Melakukan Sisip Belakang (Angka 20)");
        listSaya.sisip(20);
        System.out.print("Isi List: ");
        listSaya.tampil();

        // 3. Demonstrasi Sisip Depan lagi untuk memastikan urutan
        System.out.println("\n[3] Melakukan Sisip Depan (Angka 5)");
        listSaya.sisip_depan(5);
        System.out.print("Isi List: ");
        listSaya.tampil(); 
        // Harapan saat ini: 5 -> 10 -> 20

        // 4. Demonstrasi Sisip Tengah
        // Logika kode Anda: posisi loop berjalan hingga < posisi - 1
        // Jika kita ingin menyisipkan angka 15 di antara 10 dan 20 (posisi ke-3 secara urutan node)
        System.out.println("\n[4] Melakukan Sisip Tengah (Angka 15 di posisi 3)");
        listSaya.sisip_tengah(15, 3);
        System.out.print("Isi List: ");
        listSaya.tampil();
        // Harapan hasil akhir: 5 -> 10 -> 15 -> 20
        
        // 5. Demonstrasi Sisip Tengah lagi
        System.out.println("\n[5] Melakukan Sisip Tengah (Angka 7 di posisi 2)");
        listSaya.sisip_tengah(7, 2);
        System.out.print("Isi List: ");
        listSaya.tampil();
    }
}