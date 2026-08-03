package Tugas;
import java.util.Scanner;

public class SortingStackUtama {

    // Helper function untuk konversi Nilai Huruf ke Nilai Angka (menggunakan if-else if)
    public static int getNilaiAngka(char nilaiHuruf) {
        char nilai = Character.toUpperCase(nilaiHuruf);
        
        if (nilai == 'A') {
            return 5;
        } else if (nilai == 'B') {
            return 4;
        } else if (nilai == 'C') {
            return 3;
        } else if (nilai == 'D') {
            return 2;
        } else if (nilai == 'E') {
            return 1;
        } else {
            return 0; // Nilai tidak valid
        }
    }

    public static void sortStack(StackMahasiswa sourceStack, String order) {
        // STACK 2: Digunakan untuk menyimpan elemen yang sudah terurut (Result)
        StackMahasiswa resultStack = new StackMahasiswa(); 
        
        // STACK 3: Digunakan sebagai buffer sementara (Temp)
        StackMahasiswa tempStack = new StackMahasiswa(); 

        // Proses pengurutan menggunakan konsep Insertion Sort
        while (!sourceStack.isEmpty()) {
            Mahasiswa current = sourceStack.pop();
            int currentNilai = getNilaiAngka(current.nilaiHuruf);

            // Membandingkan dan memindahkan elemen ke Temp Stack
            while (!resultStack.isEmpty()) {
                Mahasiswa topResult = resultStack.peek();
                int topResultNilai = getNilaiAngka(topResult.nilaiHuruf);
                
                boolean shouldMove = false;
                
                // Menggunakan IF-ELSE IF untuk logika pengurutan
                if (order.equalsIgnoreCase("Ascending")) {
                    // ASCENDING: Pindahkan jika elemen di result lebih besar
                    if (topResultNilai > currentNilai) {
                        shouldMove = true;
                    }
                } else if (order.equalsIgnoreCase("Descending")) {
                    // DESCENDING: Pindahkan jika elemen di result lebih kecil
                    if (topResultNilai < currentNilai) {
                        shouldMove = true;
                    }
                }
                
                if (shouldMove) {
                    tempStack.push(resultStack.pop());
                } else {
                    break; // current sudah berada di posisi yang benar
                }
            }

            // Masukkan elemen 'current' ke Result Stack
            resultStack.push(current);

            // Kembalikan semua elemen dari Temp Stack ke Result Stack
            while (!tempStack.isEmpty()) {
                resultStack.push(tempStack.pop());
            }
        }
        
        // Output hasil pengurutan
        System.out.println("\n--- Hasil Pengurutan (" + order.toUpperCase() + " Berdasarkan Nilai Huruf) ---");
        // 
        resultStack.tampil();
        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // STACK 1: Source Stack (Data Awal)
        StackMahasiswa dataMahasiswa = new StackMahasiswa(); 

        // Contoh Data Awal (Data dimasukkan)
        dataMahasiswa.push(new Mahasiswa("10584111..24", "Dedi", "TI", 'C'));
        dataMahasiswa.push(new Mahasiswa("10584111..24", "Andi", "SI", 'A'));
        dataMahasiswa.push(new Mahasiswa("10584111..24", "Budi", "TI", 'D'));
        dataMahasiswa.push(new Mahasiswa("10584111..24", "Fani", "MI", 'B'));
        dataMahasiswa.push(new Mahasiswa("10584111..24", "Gilang", "SI", 'E'));

        System.out.println("--- Data Mahasiswa Awal (Tidak Terurut) ---");
        dataMahasiswa.tampil();
        System.out.println("-------------------------------------------");

        System.out.print("Pilih Urutan (Ascending/Descending): ");
        String pilihan = scanner.nextLine();
        // Salin data awal ke Stack baru agar dataMahasiswa kembali ke urutan semula
        // Ini adalah cara dasar untuk mendapatkan kembali urutan input dari stack (menggunakan 2 Stack untuk reverse)
        StackMahasiswa tempSource = new StackMahasiswa();
        while(!dataMahasiswa.isEmpty()) {
            tempSource.push(dataMahasiswa.pop());
        }
        while(!tempSource.isEmpty()) {
            dataMahasiswa.push(tempSource.pop());
        }
        // Jalankan pengurutan
        sortStack(dataMahasiswa, pilihan);

        scanner.close();
    }
}