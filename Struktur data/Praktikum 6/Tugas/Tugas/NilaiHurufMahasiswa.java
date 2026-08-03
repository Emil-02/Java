package Tugas;
import java.util.Scanner;
public class NilaiHurufMahasiswa {
    static Scanner input = new Scanner(System.in);
    static ListMahasiswa list = new ListMahasiswa();
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===========================================");
            System.out.println("        PROGRAM DATA NILAI MAHASISWA       ");
            System.out.println("===========================================");
            System.out.println("| [1] Input Data Baru (Sisip Depan)       |");
            System.out.println("| [2] Input Data Baru (Sisip Belakang)    |");
            System.out.println("| [3] Input Data Baru (Sisip Tengah)      |");
            System.out.println("| [4] Hapus Data Mahasiswa                |");
            System.out.println("| [5] Urutkan Data (Sorting)              |");
            System.out.println("| [6] Keluar Program                      |");
            System.out.println("===========================================");
            System.out.print(">> Masukkan Pilihan Menu: ");
            int menu = input.nextInt();
            input.nextLine();
            if (menu == 6) {
                System.out.println("\n-------------------------------------------");
                System.out.println("      Terima Kasih, Program Selesai.       ");
                System.out.println("-------------------------------------------");
                break;
            } else if (menu == 4) {
                System.out.print(">> Masukkan nomor urut data yang dihapus: ");
                int pos = input.nextInt();
                list.hapusPosisi(pos);
                System.out.println("\n[SUKSES] Data berhasil dihapus dari database.");
            } else if (menu == 5) {
                System.out.println("\n--- OPSI PENGURUTAN ---");
                System.out.println("1. Ascending (A ke E)");
                System.out.println("2. Descending (E ke A)");
                System.out.print(">> Pilih metode sorting: ");
                int sortMode = input.nextInt();
                list.urutkanList(sortMode == 1);
                System.out.println("\n[SUKSES] Data berhasil diurutkan.");
            } else if (menu >= 1 && menu <= 3) {
                Mahasiswa mhs = inputData();
                if (menu == 1) {
                    list.sisipDepan(mhs);
                } else if (menu == 2) {
                    list.sisipBelakang(mhs);
                } else if (menu == 3) {
                    System.out.print(">> Masukkan posisi penyisipan data: ");
                    int pos = input.nextInt();
                    list.sisipTengah(mhs, pos);
                }
                System.out.println("\n[SUKSES] Data berhasil disimpan.");
            } else {
                System.out.println("\n[ERROR] Pilihan tidak valid, ulangi lagi.");
            }
            list.tampil();
        }
    }
    static Mahasiswa inputData() {
        System.out.println("\n--- FORM INPUT DATA ---");
        System.out.print("NIM             : "); String nim = input.nextLine();
        System.out.print("Nama Lengkap    : "); String nama = input.nextLine();
        System.out.print("Jurusan         : "); String jur = input.nextLine();
        System.out.print("Nilai (A-E)     : "); char nilai = input.next().toUpperCase().charAt(0);
        return new Mahasiswa(nim, nama, jur, nilai);
    }
}