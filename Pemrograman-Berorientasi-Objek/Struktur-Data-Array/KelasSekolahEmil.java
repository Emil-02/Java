public class KelasSekolahEmil {

    public static void main(String[] args) {
        // Inisialisasi data siswa menggunakan array dengan nama Yunani
        String[] ErNamaSiswa = {"Adonis", "Calisto", "Eros", "Daphne", "Leonidas"};
        int[] ErNilaiSiswa = {80, 95, 65, 75, 88};

        System.out.println("Program Data Nilai Siswa\n");

        // 1. Menampilkan semua nama dan nilai
        System.out.println(" Daftar Nama dan Nilai Siswa ");
        for (int ErIndeks = 0; ErIndeks < ErNamaSiswa.length; ErIndeks++) {
            System.out.println("Nama: " + ErNamaSiswa[ErIndeks] + ", Nilai: " + ErNilaiSiswa[ErIndeks]);
        }
        System.out.println("----------------------------------------\n");


        // 2. Menghitung rata-rata kelas
        System.out.println(" Rata-rata Nilai Kelas ");
        double ErTotalNilai = 0;
        for (int ErNilai : ErNilaiSiswa) {
            ErTotalNilai += ErNilai;
        }
        double ErRataRata = ErTotalNilai / ErNilaiSiswa.length;
        System.out.println("Rata-rata nilai kelas adalah: " + ErRataRata);
        System.out.println("----------------------------------------\n");


        // 3. Mencari siswa dengan nilai tertinggi
        System.out.println(" Siswa dengan Nilai Tertinggi ");
        int ErNilaiTertinggi = ErNilaiSiswa[0];
        String ErSiswaTertinggi = ErNamaSiswa[0];
        for (int ErIndeks = 1; ErIndeks < ErNilaiSiswa.length; ErIndeks++) {
            if (ErNilaiSiswa[ErIndeks] > ErNilaiTertinggi) {
                ErNilaiTertinggi = ErNilaiSiswa[ErIndeks];
                ErSiswaTertinggi = ErNamaSiswa[ErIndeks];
            }
        }
        System.out.println("Siswa dengan nilai tertinggi adalah " + ErSiswaTertinggi + " dengan nilai " + ErNilaiTertinggi);
        System.out.println("----------------------------------------\n");


        // 4. Menghitung berapa siswa yang lulus (nilai >= 75)
        System.out.println(" Jumlah Siswa yang Lulus ");
        int ErJumlahLulus = 0;
        for (int ErNilai : ErNilaiSiswa) {
            if (ErNilai >= 75) {
                ErJumlahLulus++;
            }
        }
        System.out.println("Jumlah siswa yang lulus (nilai >= 75) adalah: " + ErJumlahLulus + " orang");
        System.out.println("----------------------------------------\n");
    }
}