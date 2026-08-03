package Stack;

import java.util.Scanner;

public class NilaiHurufMahasiswa {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackMahasiswa stackUtama = new StackMahasiswa(20);
        StackMahasiswa stackTambahan = new StackMahasiswa(20);
        StackMahasiswa stackBantuan = new StackMahasiswa(20);

        boolean lanjut = true;

        do {
            System.out.println("\n=== Menu Nilai Huruf Mahasiswa ===");
            System.out.println("1. Input Mahasiswa");
            System.out.println("2. Tampilkan Nilai Mahasiswa");
            System.out.println("3. Mengurutkan Ascending");
            System.out.println("4. Mengurutkan Descending");
            System.out.println("5. Keluar");
            System.out.print("Input : ");

            int nilaiInputan = input.nextInt();

            if (nilaiInputan == 1) {
                input.nextLine();
                System.out.print("Masukkan Nim : ");
                String nim = input.nextLine();
                System.out.print("Masukkan Nama : ");
                String nama = input.nextLine();
                System.out.print("Masukkan Jurusan : ");
                String jurusan = input.nextLine();
                System.out.print("Masukkan Nilai Huruf : ");
                String strNilai = input.next();
                char nilaiHuruf = strNilai.charAt(0);

                Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, nilaiHuruf);
                stackUtama.push(mahasiswa);
                System.out.println("Nilai Berhasil Ditambahkan");

            } else if (nilaiInputan == 2) {
                stackUtama.tampil();

            } else if (nilaiInputan == 3) {
                algoritmaMengurutkanNilai(stackUtama, stackTambahan, stackBantuan, ">");

            } else if (nilaiInputan == 4) {
                algoritmaMengurutkanNilai(stackUtama, stackTambahan, stackBantuan, "<");

            } else if (nilaiInputan == 5) {
                lanjut = false;
                System.out.println("Program Selesai.");

            } else {
                System.out.println("Menu Tidak Valid");
            }

        } while (lanjut);
    }

    public static void tampilStack(StackMahasiswa stack1, StackMahasiswa stack2, StackMahasiswa stack3) {
        System.out.print("Stack utama    : ");
        stack1.tampilkanIsiSimple();
        System.out.print("Stack tambahan : ");
        stack2.tampilkanIsiSimple();
        System.out.print("Stack bantuan  : ");
        stack3.tampilkanIsiSimple();
        System.out.println("------------------------------------------------");
    }

    public static void algoritmaMengurutkanNilai(StackMahasiswa stack1, StackMahasiswa stack2, StackMahasiswa stack3, String operator) {
        System.out.println("Mulai Mengurutkan...");

        while (!stack1.isKosong()) {
            Mahasiswa tempMhs = stack1.pop();
            char u = tempMhs.nilaiHuruf;

            System.out.println("Ambil Top dari Stack Utama: " + u);

            if (stack2.isKosong()) {
                System.out.println("Stack Tambahan Kosong, maka -> push " + u);
                stack2.push(tempMhs);
            } else {
                char t = stack2.peek().nilaiHuruf;
                boolean perluPindah;

                if (operator.equals(">")) {
                    perluPindah = (t < u);
                } else {
                    perluPindah = (t > u);
                }

                while (!stack2.isKosong()) {
                    char topSaatIni = stack2.peek().nilaiHuruf;
                    boolean kondisi;

                    if (operator.equals(">")) {
                        kondisi = (topSaatIni < u);
                    } else {
                        kondisi = (topSaatIni > u);
                    }

                    if (kondisi) {
                        System.out.println("Pop stackTambahan -> push stackBantuan : " + topSaatIni);
                        stack3.push(stack2.pop());
                    } else {
                        break;
                    }
                }

                System.out.println("Push ke stackTambahan : " + u);
                stack2.push(tempMhs);

                while (!stack3.isKosong()) {
                    System.out.println("Pop stackBantuan -> push stackTambahan");
                    stack2.push(stack3.pop());
                }
            }
            tampilStack(stack1, stack2, stack3);
        }

        System.out.println("Kembalikan ke Stack Utama...");
        while (!stack2.isKosong()) {
            stack1.push(stack2.pop());
        }
        System.out.println("Nilai berhasil diurutkan.");
    }
}