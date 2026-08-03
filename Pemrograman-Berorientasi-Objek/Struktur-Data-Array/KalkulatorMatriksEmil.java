
// import java.util.Scanner;

// public class KalkulatorMatriksEmil {

//     // Fungsi untuk menampilkan matriks dengan rapi
//     public static void ErTampilkanMatrix(int[][] ErMatrix) {
//         for (int ErI = 0; ErI < 3; ErI++) {
//             System.out.print("| ");
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 System.out.print(ErMatrix[ErI][ErJ] + "\t");
//             }
//             System.out.println("|");
//         }
//     }

//     public static void main(String[] ErArgs) {
//         // Inisialisasi variabel yang dibutuhkan
//         int[][] ErMatrixA = new int[3][3];
//         int[][] ErMatrixB = new int[3][3];
//         int[][] ErHasilJumlah = new int[3][3];
//         int[][] ErHasilTransposeA = new int[3][3];
//         int[][] ErHasilTransposeB = new int[3][3];

//         Scanner ErScanner = new Scanner(System.in);

//         System.out.println("========================================");
//         System.out.println("==== Program Kalkulator Matriks 3x3 ====");
//         System.out.println("========================================");

//         // 1. Input dua matriks 3x3
//         System.out.println("\nMasukkan elemen untuk Matriks A:");
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 System.out.printf("Masukkan elemen A[%d][%d]: ", ErI + 1, ErJ + 1);
//                 ErMatrixA[ErI][ErJ] = ErScanner.nextInt();
//             }
//         }

//         System.out.println("\nMasukkan elemen untuk Matriks B:");
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 System.out.printf("Masukkan elemen B[%d][%d]: ", ErI + 1, ErJ + 1);
//                 ErMatrixB[ErI][ErJ] = ErScanner.nextInt();
//             }
//         }
        
//         System.out.println("\n--- Matriks yang Anda Masukkan ---");
//         System.out.println("Matriks A:");
//         ErTampilkanMatrix(ErMatrixA);
        
//         System.out.println("\nMatriks B:");
//         ErTampilkanMatrix(ErMatrixB);


//         // 2. Penjumlahan Matriks
//         System.out.println("\n--- Hasil Penjumlahan Matriks (A + B) ---");
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 ErHasilJumlah[ErI][ErJ] = ErMatrixA[ErI][ErJ] + ErMatrixB[ErI][ErJ];
//             }
//         }
//         ErTampilkanMatrix(ErHasilJumlah);

//         // 3. Transpose Matriks
//         // Transpose Matriks A
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 ErHasilTransposeA[ErI][ErJ] = ErMatrixA[ErJ][ErI];
//             }
//         }
        
//         // Transpose Matriks B
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 ErHasilTransposeB[ErI][ErJ] = ErMatrixB[ErJ][ErI];
//             }
//         }

//         System.out.println("\n--- Hasil Transpose Matriks A ---");
//         ErTampilkanMatrix(ErHasilTransposeA);

//         System.out.println("\n--- Hasil Transpose Matriks B ---");
//         ErTampilkanMatrix(ErHasilTransposeB);
        
//         System.out.println("\n======================================");

//         ErScanner.close();
//     }
// }