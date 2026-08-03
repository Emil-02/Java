    public class For_ {
    public static void main(String[] args) {
        // Perulangan luar
        for (int i = 1; i <= 3; i++) {
            System.out.println("Perulangan luar ke-" + i);
            // Perulangan dalam
            for (int j = 1; j <= 2; j++) {
                System.out.println("  Perulangan dalam ke-" + j);
            }
        }
}}