import java.util.Scanner;
public class program2modifikasi {
    public static long faktorial(int a) {
        long hasil = 1; 
        for (int i = 1; i <= a; i++) {
            hasil *= i;
        }
        return hasil;
    }
    public static void cetakKombinasi(char[] elemen, int n, int k) {
        if (k > n) return;
        int[] indeks = new int[k];
        for (int i = 0; i < k; i++) {
            indeks[i] = i;
        }
        System.out.println("--- Tabel Kombinasi (4Pilih2) ---");
        while (indeks[k - 1] < n) {
            System.out.print("|");
            for (int i = 0; i < k; i++) {
                System.out.print(elemen[indeks[i]] + (i < k - 1 ? " " : ""));
            }
            System.out.println("|");
            int t = k - 1;
            while (t != 0 && indeks[t] == n - k + t) {
                t--;
            }
            if (indeks[t] == n - k + t) {
                break;
            }
            indeks[t]++;
            for (int i = t + 1; i < k; i++) {
                indeks[i] = indeks[i - 1] + 1;
            }
        }
    }
    public static void cetakPermutasi(char[] elemen, int n, int k) {
        if (k > n) return;
        
        char[] data = new char[k];
        boolean[] digunakan = new boolean[n];
        
        System.out.println("\n--- Tabel Permutasi (4Pilih2) ---");
        permuteRekursif(elemen, n, k, data, 0, digunakan);
    }
    private static void permuteRekursif(char[] elemen, int n, int k, char[] data, int depth, boolean[] digunakan) {
        if (depth == k) {
            System.out.print("|");
            for (int i = 0; i < k; i++) {
                System.out.print(data[i] + (i < k - 1 ? " " : ""));
            }
            System.out.println("|");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!digunakan[i]) {
                digunakan[i] = true;
                data[depth] = elemen[i];
                permuteRekursif(elemen, n, k, data, depth + 1, digunakan);
                digunakan[i] = false; 
            }
        }
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen (n): ");
        int n = input.nextInt();
        input.nextLine(); 
        char[] elemenArray = new char[n];
        System.out.println("Masukkan huruf satu per satu (kapital):");
        for (int i = 0; i < n; i++) {
            System.out.print("Data ke-" + (i + 1) + ": ");
            String s = input.nextLine().toUpperCase();
            if (!s.isEmpty()) {
                elemenArray[i] = s.charAt(0);
            } else {
                elemenArray[i] = '?';
            }
        }
        System.out.print("Masukkan nilai k (jumlah yang diambil): ");
        int k = input.nextInt();
        input.close();
        if (k > n || k < 0 || n < 0) {
            System.out.println("\nInput tidak valid: k tidak boleh lebih dari n atau bernilai negatif.");
            return;
        }
        System.out.println("\n--- Program Tabel Kombinasi & Permutasi ---");
        System.out.println("Elemen: " + java.util.Arrays.toString(elemenArray) + ", k: " + k);
        cetakKombinasi(elemenArray, n, k);
        cetakPermutasi(elemenArray, n, k);
    }
}