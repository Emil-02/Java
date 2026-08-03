public class while_ {
   public static void main(String[] args) {
       int i = 1;
        // Perulangan luar
        while (i <= 3) {
            System.out.println("Perulangan luar ke-" + i);
            int j = 1;
            // Perulangan dalam
            while (j <= 2) {
                System.out.println("  Perulangan dalam ke-" + j);
                j++;
            }
            i++;
        }
    }
}   