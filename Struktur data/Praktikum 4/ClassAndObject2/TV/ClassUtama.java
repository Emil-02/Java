package ClassAndObject2.TV;
import java.util.Scanner;

public class ClassUtama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Objek ClassTV yang akan disimulasikan
        ClassTV tv = new ClassTV(); 

        int pilihan = -1;
        System.out.println("--- PROGRAM SIMULASI TV INTERAKTIF ---");
        do {
            tv.menu();
            System.out.print("Masukkan pilihan menu (0 untuk keluar): ");
            
            // Membaca pilihan menu, dengan validasi dasar
            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Konsumsi newline
            } else {
                System.out.println("\n[ERROR] Input tidak valid. Silakan masukkan angka.");
                scanner.nextLine(); // Hapus input yang salah
                pilihan = -1; 
                continue;
            }

            // Logika Menu Utama menggunakan IF-ELSE IF-ELSE
            if (pilihan == 1) { // 1. Ganti Channel
                System.out.print("Masukkan nomor Channel baru (1-6): ");
                if (scanner.hasNextInt()) {
                    int channelBaru = scanner.nextInt();
                    tv.ganti_channel(channelBaru); // Memanggil method ganti_channel dari ClassTV
                    scanner.nextLine();
                } else {
                    System.out.println("\n[ERROR] Input Channel tidak valid.");
                    scanner.nextLine(); 
                }
            } else if (pilihan == 2 || pilihan == 3) { // 2. Tambah Suara / 3. Kurang Suara
                System.out.print("Masukkan nilai suara (0-100): ");
                if (scanner.hasNextInt()) {
                    int nilaiSuara = scanner.nextInt();
                    if (pilihan == 2) {
                        tv.tambah_suara(nilaiSuara);
                    } else {
                        tv.kurang_suara(nilaiSuara);
                    }
                    scanner.nextLine();
                } else {
                    System.out.println("\n[ERROR] Input nilai suara tidak valid.");
                    scanner.nextLine(); 
                }
            } else if (pilihan == 4 || pilihan == 5) { // 4. Tambah Kecerahan / 5. Kurang Kecerahan
                System.out.print("Masukkan nilai kecerahan (0-100): ");
                if (scanner.hasNextInt()) {
                    int nilaiTerang = scanner.nextInt();
                    if (pilihan == 4) {
                        tv.tambah_terang(nilaiTerang);
                    } else {
                        tv.kurang_terang(nilaiTerang);
                    }
                    scanner.nextLine();
                } else {
                    System.out.println("\n[ERROR] Input nilai kecerahan tidak valid.");
                    scanner.nextLine(); 
                }
            } else if (pilihan == 6) { 
                System.out.println("\n--- Pilih Input Source ---");
                System.out.println("1. AV | 2. HDMI 1 | 3. HDMI 2 | 4. TV (Default)");
                System.out.print("Pilihan: ");
                if (scanner.hasNextInt()) {
                    int sourcePilihan = scanner.nextInt();
                    tv.set_input_source(sourcePilihan);
                    scanner.nextLine();
                } else {
                    System.out.println("\n[ERROR] Input Source tidak valid.");
                    scanner.nextLine(); 
                }
            } else if (pilihan == 7) {
                System.out.println("\n--- Atur Ratio Gambar ---");
                System.out.println("1. 4:3 | 2. 16:9 | 3. Zoom | 4. Auto");
                System.out.print("Pilihan: ");
                if (scanner.hasNextInt()) {
                    int ratioPilihan = scanner.nextInt();
                    tv.set_ratio_gambar(ratioPilihan);
                    scanner.nextLine();
                } else {
                    System.out.println("\n[ERROR] Input Ratio tidak valid.");
                    scanner.nextLine(); 
                }
            } else if (pilihan == 8) {
                tv.auto_random_channel();
            } else if (pilihan == 0) { // 0. Keluar
                System.out.println("\nTV dimatikan. Terima kasih!");
            } else { // Pilihan Tidak Valid
                System.out.println("\n[INFO] Pilihan " + pilihan + " tidak ada di menu. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        scanner.close();
    }
}