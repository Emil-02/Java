public class GredyPecahan {
    public static void main(String[] args) {
        int[] pecahan = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 100};
        int Jumlah = 2575800;
        System.out.println("Jumlah : " + Jumlah);
        for (int i = 0; i < pecahan.length; i++) {
            if (Jumlah >= pecahan[i]) {
                int n = Jumlah / pecahan[i];
                Jumlah %= pecahan[i];
                System.out.print("Pecahan " + pecahan[i] + " sebanyak " + n);
            }
        }
    }
}