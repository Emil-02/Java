import java.util.Scanner;

public class HitungJarakWilayah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] wilayah = {"Wilayah A", "Wilayah B", "Wilayah C", "Wilayah D"};
        double[][] koordinat = {
            {1.0, 2.0}, // Koordinat Wilayah A
            {3.0, 4.0}, // Koordinat Wilayah B
            {5.0, 6.0}, // Koordinat Wilayah C
            {7.0, 8.0}  // Koordinat Wilayah D
        };

        int jumlahWilayah = wilayah.length;

        System.out.println("Daftar wilayah dan koordinatnya:");
        for (int i = 0; i < jumlahWilayah; i++) {
            System.out.println(wilayah[i] + " - (" + koordinat[i][0] + ", " + koordinat[i][1] + ")");
        }

        System.out.println("Masukkan nomor wilayah pertama: ");
        int wilayah1 = input.nextInt();
        System.out.println("Masukkan nomor wilayah kedua: ");
        int wilayah2 = input.nextInt();

        if (wilayah1 < 0 || wilayah1 >= jumlahWilayah || wilayah2 < 0 || wilayah2 >= jumlahWilayah) {
            System.out.println("Nomor wilayah tidak valid.");
        } else {
            double deltaX = koordinat[wilayah2][0] - koordinat[wilayah1][0];
            double deltaY = koordinat[wilayah2][1] - koordinat[wilayah1][1];
            double jarak = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
            System.out.println("Jarak antara " + wilayah[wilayah1] + " dan " + wilayah[wilayah2] + " adalah " + jarak + " satuan.");
        }
    }
}
