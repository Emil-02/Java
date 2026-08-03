package Stack;

import java.util.Scanner;

public class NilaiHurufMahasiswa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("   PROGRAM PENGURUTAN NILAI MAHASISWA");
        System.out.println("===========================================");

        System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
        int jumlahData = input.nextInt();
        input.nextLine();

        StackMahasiswa stackUtama = new StackMahasiswa(jumlahData);
        StackMahasiswa stackTambahan = new StackMahasiswa(jumlahData);
        StackMahasiswa stackBantuan = new StackMahasiswa(jumlahData);

        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\n--- Input Data Mahasiswa ke-" + (i + 1) + " ---");

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

        System.out.println("\n[INFO] Semua data berhasil dimasukkan ke Stack Utama.");
        System.out.print("Posisi Awal Stack Utama: ");
        stackUtama.tampilkanIsiSimple();

        System.out.println("\n=== Pilih Metode Pengurutan ===");
        System.out.println("1. Ascending  (A -> E)");
        System.out.println("2. Descending (E -> A)");
        System.out.print("Pilihan: ");
        int pilihanSort = input.nextInt();

        String operator = (pilihanSort == 1) ? ">" : "<";
        String mode = (pilihanSort == 1) ? "ASCENDING" : "DESCENDING";

        System.out.println("\n===========================================");
        System.out.println(" MULAI PROSES PENGURUTAN (" + mode + ")");
        System.out.println("===========================================");

        algoritmaMengurutkanNilaiLengkap(stackUtama, stackTambahan, stackBantuan, operator);

        System.out.println("\n===========================================");
        System.out.println("           HASIL AKHIR (" + mode + ")");
        System.out.println("===========================================");
        stackUtama.tampil();
    }

    public static void tampilStack(StackMahasiswa s1, StackMahasiswa s2, StackMahasiswa s3) {
        System.out.print("   | S.Utama: "); s1.tampilkanIsiSimple();
        System.out.print("   | S.Sorted: "); s2.tampilkanIsiSimple();
        System.out.print("   | S.Bantuan: "); s3.tampilkanIsiSimple();
        System.out.println("   ----------------------------------------");
    }

    public static void algoritmaMengurutkanNilaiLengkap(StackMahasiswa stack1, StackMahasiswa stack2, StackMahasiswa stack3, String operator) {
        int langkah = 1;
        while (!stack1.isKosong()) {
            Mahasiswa tempMhs = stack1.pop();
            char u = tempMhs.nilaiHuruf;
            System.out.println("\n>> LANGKAH " + langkah + ": Ambil '" + u + "' dari Stack Utama");

            if (stack2.isKosong()) {
                System.out.println("   (Stack Sorted kosong, langsung push '" + u + "')");
                stack2.push(tempMhs);
            } else {
                while (!stack2.isKosong()) {
                    char topSaatIni = stack2.peek().nilaiHuruf;
                    boolean kondisiPindah;
                    if (operator.equals(">")) {
                        kondisiPindah = (topSaatIni < u);
                    } else {
                        kondisiPindah = (topSaatIni > u);
                    }

                    if (kondisiPindah) {
                        System.out.println("   -> Bandingkan: Top Sorted ['" + topSaatIni + "'] vs Input ['" + u + "'] (PINDAH)");
                        stack3.push(stack2.pop());
                        tampilStack(stack1, stack2, stack3);
                    } else {
                        System.out.println("   -> Bandingkan: Top Sorted ['" + topSaatIni + "'] vs Input ['" + u + "'] (STOP)");
                        break;
                    }
                }

                stack2.push(tempMhs);
                System.out.println("   -> Push Input '" + u + "' ke Stack Sorted");

                while (!stack3.isKosong()) {
                    stack2.push(stack3.pop());
                }
            }
            System.out.println("   [Status Akhir Langkah " + langkah + "]");
            tampilStack(stack1, stack2, stack3);
            langkah++;
        }

        System.out.println("\n>> FINALISASI: Mengembalikan semua data ke Stack Utama...");
        while (!stack2.isKosong()) {
            stack1.push(stack2.pop());
        }
        tampilStack(stack1, stack2, stack3);
    }
}