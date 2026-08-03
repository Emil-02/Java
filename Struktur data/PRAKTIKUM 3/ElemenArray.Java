import java.util.Scanner;
public class ElemenArray {
    public static long faktorial(int a) {
        long hasil = 1;
        for (int i = 1; i <= a; i++) {
            hasil *= i;
        }
        return hasil;
    }
    // ============================
    //        CETAK KOMBINASI
    // ============================
    public static void cetakKombinasi(char[] elemen, int n, int k) {
        if (k > n) return;
        int[] indeks = new int[k];
        for (int i = 0; i < k; i++) indeks[i] = i;
        System.out.println("\n---- Tabel Kombinasi ----");
        while (true) {
            for (int i = 0; i < k; i++) {
                System.out.print(elemen[indeks[i]] + (i < k - 1 ? " " : ""));
            }
            System.out.println(" |");
            int t = k - 1;
            while (t >= 0 && indeks[t] == n - k + t) {
                t--;
            }
            if (t < 0) break;

            indeks[t]++;
            for (int i = t + 1; i < k; i++) {
                indeks[i] = indeks[i - 1] + 1;
            }
        }
    }

    // ============================
    //       CETAK PERMUTASI
    // ============================
    public static void cetakPermutasi(char[] elemen, int n, int k) {
        if (k > n) return;

        char[] data = new char[k];
        boolean[] digunakan = new boolean[n];

        System.out.println("\n---- Tabel Permutasi ----");
        permutasiRekursif(elemen, n, k, data, 0, digunakan);
    }

    private static void permutasiRekursif(char[] elemen, int n, int k, char[] data, int depth, boolean[] digunakan) {
        if (depth == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(data[i] + (i < k - 1 ? " " : ""));
            }
            System.out.println(" |");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!digunakan[i]) {
                digunakan[i] = true;
                data[depth] = elemen[i];
                permutasiRekursif(elemen, n, k, data, depth + 1, digunakan);
                digunakan[i] = false;
            }
        }
    }

    // ============================
    //         PROGRAM UTAMA
    // ============================
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen (n): ");
        int n = input.nextInt();
        input.nextLine();

        char[] elemenArray = new char[n];
        System.out.println("Masukkan huruf satu per satu (kapital):");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke-" + (i + 1) + " : ");
            String s = input.nextLine().toUpperCase();

            if (!s.isEmpty()) {
                elemenArray[i] = s.charAt(0);
            } else {
                elemenArray[i] = '-';
            }
        }

        System.out.print("Masukkan nilai k (jumlah yang diambil): ");
        int k = input.nextInt();

        if (k > n || k < 0) {
            System.out.println("\nInput tidak valid: k harus 0 ≤ k ≤ n.");
            return;
        }

        // ======== Perhitungan ========
        long faktN = faktorial(n);
        long faktK = faktorial(k);
        long faktNK = faktorial(n - k);

        long kombinasi = faktN / (faktK * faktNK);
        long permutasi = faktN / faktNK;

        System.out.println("\n---- Hasil Perhitungan ----");
        System.out.println("n! = " + faktN);
        System.out.println("k! = " + faktK);
        System.out.println("(n-k)! = " + faktNK);
        System.out.println("Kombinasi = " + kombinasi);
        System.out.println("Permutasi = " + permutasi);

        System.out.println("\n---- Program Tabel Kombinasi & Permutasi ----");
        System.out.println("Elemen : " + java.util.Arrays.toString(elemenArray) + ", n = " + n + ", k = " + k);

        cetakKombinasi(elemenArray, n, k);
        cetakPermutasi(elemenArray, n, k);
    }
}
