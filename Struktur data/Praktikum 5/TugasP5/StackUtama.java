package TugasP5;
import java.util.Scanner;

public class StackUtama {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi Stack
        Mahasiswa.Stack sInput = new Mahasiswa.Stack("Stack Input");
        Mahasiswa.Stack sHasil = new Mahasiswa.Stack("Stack Hasil");
        Mahasiswa.Stack sBantu = new Mahasiswa.Stack("Stack Bantuan");

        // Input Data
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jml = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jml; i++) {
            System.out.println("\nInput Mahasiswa ke-" + (i + 1));
            System.out.print("NIM    : "); String nim = input.nextLine();
            System.out.print("Nama   : "); String nama = input.nextLine();
            System.out.print("Jurusan: "); String jur = input.nextLine();
            System.out.print("Nilai (A-E): "); char nil = input.next().charAt(0);
            input.nextLine();
            sInput.push(new Mahasiswa(nim, nama, jur, nil));
        }

        // Pilihan Mode
        System.out.println("\n==================================");
        System.out.println("Pilih Mode Pengurutan:");
        System.out.println("1. Ascending (A ke E)");
        System.out.println("2. Descending (E ke A)");
        System.out.print("Pilihan (1/2): ");
        int mode = input.nextInt();
        boolean isAscending = (mode == 1);

        System.out.println("\n========== MULAI PROSES SORTING ==========");

        // Logika Pengurutan
        while (!sInput.isEmpty()) {
            Mahasiswa baru = sInput.pop();
            int bobotBaru = baru.getBobot();
            
            System.out.println("\n--- Memproses Data: " + baru.nama + " (" + baru.nilai + ") ---");

            while (!sHasil.isEmpty()) {
                Mahasiswa topHasil = sHasil.peek();
                int bobotLama = topHasil.getBobot();
                
                // --- TAMBAHAN LOG PERBANDINGAN DI SINI ---
                System.out.print("   [COMPARE] " + baru.nama + "(" + baru.nilai + ") vs Atas Stack: " + topHasil.nama + "(" + topHasil.nilai + ")");
                
                boolean perluDipindah;
                if (isAscending) {
                    // Ascending: Jika yang di stack (Lama) > Baru, maka Lama harus minggir (pindah ke Bantu)
                    // Contoh: Stack ada B(4), masuk A(5). 4 < 5 False. (Tetap)
                    // Contoh: Stack ada A(5), masuk B(4). 5 > 4 True. (A Pindah)
                    perluDipindah = (bobotLama > bobotBaru); 
                    
                    if(perluDipindah) System.out.println(" -> " + topHasil.nilai + " > " + baru.nilai + " (Pindah ke Bantu)");
                    else System.out.println(" -> " + topHasil.nilai + " <= " + baru.nilai + " (Posisi Pas, Berhenti)");
                    
                } else {
                    // Descending
                    perluDipindah = (bobotLama < bobotBaru);
                    
                    if(perluDipindah) System.out.println(" -> " + topHasil.nilai + " < " + baru.nilai + " (Pindah ke Bantu)");
                    else System.out.println(" -> " + topHasil.nilai + " >= " + baru.nilai + " (Posisi Pas, Berhenti)");
                }
                // -----------------------------------------

                if (perluDipindah) {
                    sBantu.push(sHasil.pop());
                } else {
                    break;
                }
            }
            sHasil.push(baru);

            // Kembalikan dari Bantu ke Hasil
            if (!sBantu.isEmpty()) {
                System.out.println("   [INFO] Mengembalikan isi Stack Bantuan ke Stack Hasil...");
            }
            while (!sBantu.isEmpty()) {
                sHasil.push(sBantu.pop());
            }
        }

        // Tampil Hasil Akhir
        String judul = isAscending ? "Ascending (A ke E)" : "Descending (E ke A)";
        System.out.println("\n========== Hasil Pengurutan " + judul + " ==========");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-15s %-20s %-15s %-5s\n", "NIM", "NAMA", "JURUSAN", "NILAI");
        System.out.println("-----------------------------------------------------------");

        while (!sHasil.isEmpty()) {
            sHasil.popTanpaLog().cetak();
        }
        System.out.println("-----------------------------------------------------------");
    }
}