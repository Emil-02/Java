package Tugas;

import java.util.Scanner;

public class NilaiHurufMahasiswa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Tampilan judul yang lebih sederhana
        System.out.println("Program Pengurutan Nilai Mahasiswa");
        System.out.println("----------------------------------");

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahData = input.nextInt();
        input.nextLine();

        StackMahasiswa stackUtama = new StackMahasiswa(jumlahData);
        StackMahasiswa stackTambahan = new StackMahasiswa(jumlahData);
        StackMahasiswa stackBantuan = new StackMahasiswa(jumlahData);

        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\nInput Data ke-" + (i + 1));

            System.out.print("NIM          : ");
            String nim = input.nextLine();

            System.out.print("Nama         : ");
            String nama = input.nextLine();

            System.out.print("Jurusan      : ");
            String jurusan = input.nextLine();

            System.out.print("Nilai (A-E)  : ");
            String strNilai = input.next();
            input.nextLine();

            char nilaiHuruf = strNilai.toUpperCase().charAt(0);
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, nilaiHuruf);
            stackUtama.push(mahasiswa);
        }

        System.out.println("\nInfo: Data berhasil diinput.");
        System.out.print("Posisi Awal: ");
        stackUtama.tampilkanIsiSimple();

        System.out.println("\nPilih Metode Pengurutan:");
        System.out.println("1. Ascending  (A -> E)");
        System.out.println("2. Descending (E -> A)");
        System.out.print("Pilihan: ");
        int pilihanSort = input.nextInt();

        String operator = (pilihanSort == 1) ? ">" : "<";
        String mode = (pilihanSort == 1) ? "Ascending" : "Descending";

        System.out.println("\n--- Mulai Proses Pengurutan (" + mode + ") ---");

        algoritmaMengurutkanNilaiLengkap(stackUtama, stackTambahan, stackBantuan, operator);

        System.out.println("\n----------------------------------");
        System.out.println("Hasil Akhir (" + mode + ")");
        System.out.println("----------------------------------");
        stackUtama.tampil();
    }

    // Fungsi menampilkan isi stack dengan format sederhana
    public static void tampilStack(StackMahasiswa s1, StackMahasiswa s2, StackMahasiswa s3) {
        // Format baris biasa tanpa garis-garis tabel rumit
        System.out.print("   [Utama]: "); s1.tampilkanIsiSimple();
        System.out.print("   [Sorted]: "); s2.tampilkanIsiSimple();
        System.out.print("   [Bantuan]: "); s3.tampilkanIsiSimple();
        System.out.println(); // Enter
    }

    public static void algoritmaMengurutkanNilaiLengkap(StackMahasiswa stack1, StackMahasiswa stack2, StackMahasiswa stack3, String operator) {
        int langkah = 1;
        while (!stack1.isKosong()) {
            Mahasiswa tempMhs = stack1.pop();
            char u = tempMhs.nilaiHuruf;
            
            // Tampilan langkah yang lebih clean
            System.out.println("\nLangkah " + langkah + ": Memproses nilai '" + u + "'");

            if (stack2.isKosong()) {
                System.out.println("   -> Stack Sorted kosong. Langsung masukkan '" + u + "'");
                stack2.push(tempMhs);
            } else {
                while (!stack2.isKosong()) {
                    char topSaatIni = stack2.peek().nilaiHuruf;
                    boolean kondisiPindah;
                    
                    // Cek kondisi
                    if (operator.equals(">")) {
                        kondisiPindah = (topSaatIni < u);
                    } else {
                        kondisiPindah = (topSaatIni > u);
                    }

                    // Tampilkan perbandingan
                    if (kondisiPindah) {
                        System.out.println("   -> Bandingkan: Top '" + topSaatIni + "' vs Input '" + u + "' (Pindahkan ke Bantuan)");
                        stack3.push(stack2.pop());
                        // Tampilkan status stack saat terjadi pemindahan
                        tampilStack(stack1, stack2, stack3);
                    } else {
                        System.out.println("   -> Bandingkan: Top '" + topSaatIni + "' vs Input '" + u + "' (Posisi sudah pas)");
                        break;
                    }
                }

                stack2.push(tempMhs);
                System.out.println("   -> Masukkan Input '" + u + "' ke Stack Sorted");

                // Proses mengembalikan data dari bantuan
                if (!stack3.isKosong()) {
                    System.out.println("   -> Mengembalikan data dari Stack Bantuan...");
                    while (!stack3.isKosong()) {
                        stack2.push(stack3.pop());
                    }
                }
            }
            
            System.out.println("   Status Akhir Langkah " + langkah + ":");
            tampilStack(stack1, stack2, stack3);
            langkah++;
        }

        System.out.println("\nSelesai: Mengembalikan semua data ke Stack Utama...");
        while (!stack2.isKosong()) {
            stack1.push(stack2.pop());
        }
    }
}