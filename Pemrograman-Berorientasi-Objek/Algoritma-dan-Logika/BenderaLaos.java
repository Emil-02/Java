public class BenderaLaos {
    public static void main(String[] args) {
        final String MERAH = "\u001B[41m";   // Background merah
        final String BIRU = "\u001B[44m";    // Background biru
        final String PUTIH = "\u001B[47m";   // Background putih
        final String RESET = "\u001B[0m";    // Reset warna
        int lebar = 40;
        int tinggi = 15;
        System.out.println("=== Bendera Laos ===\n");
        for (int i = 0; i < tinggi; i++) {
            for (int j = 0; j < lebar; j++) {
                // Baris 0-2: Merah atas
                if (i < 3) {
                    System.out.print(MERAH + "*" + RESET);
                }
                // Baris 3-11: Biru tengah + lingkaran putih
                else if (i >= 3 && i <= 11) {
                    int centerY = 7;
                    int centerX = lebar / 2;
                    int radius = 6;
                    int dy = i - centerY;
                    int dx = j - centerX;
                    double distance = Math.sqrt(dx * dx + dy * dy);
                    if (distance < radius) {
                        System.out.print(PUTIH + "*" + RESET);
                    } else {
                        System.out.print(BIRU + "*" + RESET);
                    }
                }
                // Baris 12-14: Merah bawah
                else {
                    System.out.print(MERAH + "*" + RESET);
                }
            }
            System.out.println();
        }
    }
}
