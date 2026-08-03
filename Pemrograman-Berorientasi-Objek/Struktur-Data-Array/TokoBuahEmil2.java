// // Kode ini dibuat secara eksklusif untuk Anda
// public class TokoBuahEmil2 {
//     public static void main(String[] args) {
//         // Data buah dan harga
//         String[] ErNamaBuah = {"mangga", "pir", "Jeruk", "jambu mente", "Durian", "salak"};
//         int[] ErHargaBuah = {25000, 30000, 18000, 45000, 55000, 15000};
//         System.out.println("=========================================");
//         System.out.println("=======      Fruit shop Emil      =======");
//         System.out.println("=========================================\n");
//         // Menampilkan daftar buah dengan nomor
//         System.out.println("Daftar Buah Beserta Harganya (per kg):");
//         System.out.println("-----------------------------------------");
//         for (int ErIndeks = 0; ErIndeks < ErNamaBuah.length; ErIndeks++) {
//             System.out.printf("%d. %-13s : Rp %,d\n",
//                     (ErIndeks + 1),
//                     ErNamaBuah[ErIndeks],
//                     ErHargaBuah[ErIndeks]);
//         }
//         System.out.println("-----------------------------------------\n");
//         // Bagian untuk mencari harga termahal dan termurah
//         // (Logika ini tetap sama, tidak ada yang diubah)
//         String ErBuahTermahal = ErNamaBuah[0];
//         int ErHargaTermahal = ErHargaBuah[0];
//         int ErIndeksTermahal = 0;

//         String ErBuahTermurah = ErNamaBuah[0];
//         int ErHargaTermurah = ErHargaBuah[0];
//         int ErIndeksTermurah = 0;

//         for (int ErIndeks = 1; ErIndeks < ErHargaBuah.length; ErIndeks++) {
//             if (ErHargaBuah[ErIndeks] > ErHargaTermahal) {
//                 ErHargaTermahal = ErHargaBuah[ErIndeks];
//                 ErBuahTermahal = ErNamaBuah[ErIndeks];
//                 ErIndeksTermahal = ErIndeks;
//             }
//             if (ErHargaBuah[ErIndeks] < ErHargaTermurah) {
//                 ErHargaTermurah = ErHargaBuah[ErIndeks];
//                 ErBuahTermurah = ErNamaBuah[ErIndeks];
//                 ErIndeksTermurah = ErIndeks;
//             }
//         }
//         // --- PERUBAHAN DI SINI ---
//         // Menampilkan hasil analisis harga TANPA NOMOR
//         System.out.println("Analisis Harga:");
//         System.out.printf("Buah Termahal : %s (Rp %,d)\n", // Nomor urut dihilangkan
//                 ErBuahTermahal,
//                 ErHargaTermahal);
//         System.out.printf("Buah Termurah : %s (Rp %,d)\n", // Nomor urut dihilangkan
//                 ErBuahTermurah,
//                 ErHargaTermurah);
//         System.out.println("\n=========================================");
//     }
// }