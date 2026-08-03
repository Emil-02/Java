package Tugas;
import java.util.Scanner;
public class HitungIntegralTurunan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. INPUT DATA
        // Sesuai format modul: Input jumlah elemen dulu [cite: 199-201]
        System.out.print("Masukkan Jumlah Suku (Koefisien & Pangkat): ");
        int n = input.nextInt();
        
        // Inisialisasi Array [cite: 2, 197]
        int[] koefisien = new int[n];
        int[] pangkat = new int[n];
        String[] operator = new String[n]; // Untuk menyimpan tanda + atau -
        
        // Input nilai variabel per suku [cite: 203-206]
        for (int i = 0; i < n; i++) {
            System.out.println("Data Suku ke-" + (i + 1));
            System.out.print("Masukkan Koefisien: ");
            koefisien[i] = input.nextInt();
            
            System.out.print("Masukkan Pangkat: ");
            pangkat[i] = input.nextInt();
            
            // Input operator untuk menyambung ke suku berikutnya atau konstanta
            System.out.print("Masukkan Operator (+/-): ");
            operator[i] = input.next();
        }

        // Input Konstanta
        System.out.print("Masukkan Konstanta: ");
        int konstanta = input.nextInt();

        // 2. TAMPILKAN PERSAMAAN AWAL [cite: 207]
        System.out.print("Persamaannya adalah: ");
        for (int i = 0; i < n; i++) {
            System.out.print(koefisien[i] + "X^" + pangkat[i] + " " + operator[i] + " ");
        }
        System.out.println(konstanta);

        // 3. HITUNG TURUNAN [cite: 208]
        // Rumus Turunan: (koef * pangkat)X^(pangkat-1)
        System.out.print("Maka turunannya adalah: ");
        for (int i = 0; i < n; i++) {
            int turunanKoef = koefisien[i] * pangkat[i];
            int turunanPangkat = pangkat[i] - 1;
            
            // Menangani tampilan jika pangkat menjadi 0 atau 1
            if (turunanPangkat == 0) {
                System.out.print(turunanKoef); 
            } else if (turunanPangkat == 1) {
                System.out.print(turunanKoef + "X");
            } else {
                System.out.print(turunanKoef + "X^" + turunanPangkat);
            }

            // Tampilkan operator jika bukan suku terakhir
            if (i < n - 1) {
                System.out.print(" " + operator[i] + " ");
            }
        }
        // Konstanta jika diturunkan menjadi 0, jadi tidak perlu ditampilkan
        System.out.println();

        // 4. HITUNG INTEGRAL 
        // Rumus Integral: (koef / (pangkat+1))X^(pangkat+1)
        System.out.print("Maka Integralnya adalah: ");
        for (int i = 0; i < n; i++) {
            int integralPangkat = pangkat[i] + 1;
            // Gunakan double untuk pecahan agar presisi (misal 1/2 atau 1/3)
            // String.format digunakan untuk menyederhanakan desimal jika perlu, tapi di sini kita pakai pecahan sederhana
            System.out.print("(" + koefisien[i] + "/" + integralPangkat + ")X^" + integralPangkat);
            
            System.out.print(" " + operator[i] + " ");
        }
        // Konstanta jika diintegralkan mendapat variabel X
        System.out.println(konstanta + "X + C");
    }
}