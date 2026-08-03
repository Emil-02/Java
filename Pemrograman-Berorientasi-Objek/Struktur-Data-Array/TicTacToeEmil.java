// import java.util.Random;
// import java.util.Scanner;
// public class TicTacToeEmil {
//     static char[][] arena = new char[3][3];
//     static final char Ernakke = 'X';
//     static final char lu = 'O';
//     static final char Nul = ' ';
//     public static void main(String[] args) {
//         Scanner ErInput = new Scanner(System.in);
//         inisialisasiArena();
//         char ErGiliran = Ernakke;
//         System.out.println("--- game x dan O ---");
//         while (true) {
//             cetakArena();
//             if (ErGiliran == Ernakke) {
//                 giliranErnakke(ErInput);
//             } else {
//                 giliranLu();
//             }
//             if (cekPemenang(ErGiliran)) {
//                 cetakArena();
//                 System.out.println("Selamat! Pemain '" + ErGiliran + "' booyah!");
//                 break;
//             } else if (isArenaPenuh()) {
//                 cetakArena();
//                 System.out.println("aduh seri!");
//                 break;
//             }
//             ErGiliran = (ErGiliran == Ernakke) ? lu : Ernakke;
//         }
//         ErInput.close();
//     }
//     static void inisialisasiArena() {
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 arena[ErI][ErJ] = Nul;
//             }
//         }
//     }
//     static void cetakArena() {
//         System.out.println("\n-------------");
//         for (int ErI = 0; ErI < 3; ErI++) {
//             System.out.print("| ");
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 System.out.print(arena[ErI][ErJ] + " | ");
//             }
//             System.out.println("\n-------------");
//         }
//     }
//     static void giliranErnakke(Scanner ErInput) {
//         int ErBaris, ErKolom;
//         while (true) {
//             System.out.print("Giliran nakke (baris[1-3] kolom[1-3]): ");
//             ErBaris = ErInput.nextInt() - 1;
//             ErKolom = ErInput.nextInt() - 1;
//             if (ErBaris >= 0 && ErBaris < 3 && ErKolom >= 0 && ErKolom < 3 && arena[ErBaris][ErKolom] == Nul) {
//                 arena[ErBaris][ErKolom] = Ernakke;
//                 break;
//             } else {
//                 System.out.println("Gerakan tidak valid. Coba lagi.");
//             }
//         }
//     }
//     static void giliranLu() {
//         System.out.println("Giliran lu (O)...");
//         Random ErAcak = new Random();
//         int ErBaris, ErKolom;
//         do {
//             ErBaris = ErAcak.nextInt(3);
//             ErKolom = ErAcak.nextInt(3);
//         } while (arena[ErBaris][ErKolom] != Nul);
//         arena[ErBaris][ErKolom] = lu;
//     }
//     static boolean isArenaPenuh() {
//         for (int ErI = 0; ErI < 3; ErI++) {
//             for (int ErJ = 0; ErJ < 3; ErJ++) {
//                 if (arena[ErI][ErJ] == Nul) return false;
//             }
//         }
//         return true;
//     }
//     static boolean cekPemenang(char ErSimbol) {
//         for (int ErI = 0; ErI < 3; ErI++) {
//             if ((arena[ErI][0] == ErSimbol && arena[ErI][1] == ErSimbol && arena[ErI][2] == ErSimbol) ||
//                 (arena[0][ErI] == ErSimbol && arena[1][ErI] == ErSimbol && arena[2][ErI] == ErSimbol)) {
//                 return true;
//             }
//         }
//         return (arena[0][0] == ErSimbol && arena[1][1] == ErSimbol && arena[2][2] == ErSimbol) ||
//             (arena[0][2] == ErSimbol && arena[1][1] == ErSimbol && arena[2][0] == ErSimbol);
//     }
// }
