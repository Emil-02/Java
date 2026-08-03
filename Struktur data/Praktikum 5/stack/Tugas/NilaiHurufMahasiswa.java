package Tugas;
import java.util.Scanner;
public class NilaiHurufMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("PROGRAM PENGURUTAN NILAI MAHASISWA");
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahData = input.nextInt();
        input.nextLine();
        StackMahasiswa stackUtama = new StackMahasiswa(jumlahData);
        StackMahasiswa stackTambahan = new StackMahasiswa(jumlahData);
        StackMahasiswa stackBantuan = new StackMahasiswa(jumlahData);
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("\nInput Data ke-" + (i + 1));
            System.out.print("NIM        : ");
            String nim = input.nextLine();
            System.out.print("Nama       : ");
            String nama = input.nextLine();
            System.out.print("Jurusan    : ");
            String jurusan = input.nextLine();
            System.out.print("Nilai (A-E): ");
            String strNilai = input.next();
            input.nextLine();
            char nilaiHuruf = strNilai.toUpperCase().charAt(0);
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jurusan, nilaiHuruf);
            stackUtama.push(mahasiswa);
        }
        System.out.println("\n[Info] Data tersimpan.");
        System.out.print("Posisi Awal: ");
        stackUtama.tampilkanIsiSimple();
        System.out.println("\nPilih Metode:");
        System.out.println("1. Ascending  (A-E)");
        System.out.println("2. Descending (E-A)");
        System.out.print("Pilihan: ");
        int pilihanSort = input.nextInt();
        String operator = (pilihanSort == 1) ? ">" : "<";
        String mode = (pilihanSort == 1) ? "ASCENDING" : "DESCENDING";
        System.out.println("\n--- MEMULAI " + mode + " ---");
        algoritmaMengurutkanNilaiLengkap(stackUtama, stackTambahan, stackBantuan, operator);
        System.out.println("\n--- HASIL AKHIR ---");
        stackUtama.tampil();
    }
    public static void tampilStack(StackMahasiswa s1, StackMahasiswa s2, StackMahasiswa s3) {
        System.out.print("  S.Utama : "); s1.tampilkanIsiSimple();
        System.out.print("  S.Sort  : "); s2.tampilkanIsiSimple();
        System.out.print("  S.Bantu : "); s3.tampilkanIsiSimple();
        System.out.println(); 
    }
    public static void algoritmaMengurutkanNilaiLengkap(StackMahasiswa stack1, StackMahasiswa stack2, StackMahasiswa stack3, String operator) {
        int langkah = 1;
        while (!stack1.isKosong()) {
            Mahasiswa tempMhs = stack1.pop();
            char u = tempMhs.nilaiHuruf;
            System.out.println("Langkah " + langkah + ": Proses Nilai '" + u + "'");
            if (stack2.isKosong()) {
                System.out.println("  Stack kosong, push '" + u + "'");
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
                        System.out.println("  Banding: '" + topSaatIni + "' vs '" + u + "' (Pindah)");
                        stack3.push(stack2.pop());
                        tampilStack(stack1, stack2, stack3);
                    } else {
                        System.out.println("  Banding: '" + topSaatIni + "' vs '" + u + "' (Stop)");
                        break;
                    }
                }
                stack2.push(tempMhs);
                System.out.println("  Push '" + u + "' ke Sorted");
                while (!stack3.isKosong()) {
                    stack2.push(stack3.pop());
                }
            }
            tampilStack(stack1, stack2, stack3);
            langkah++;
        }
        System.out.println("\nFinalisasi: Kembalikan ke Utama...");
        while (!stack2.isKosong()) {
            stack1.push(stack2.pop());
        }
        tampilStack(stack1, stack2, stack3);
    }
}