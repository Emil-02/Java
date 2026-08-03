public class do_while {
     public static void main(String[] args) {
        int i = 1;
        // Perulangan luar
        do {
            System.out.println("Perulangan luar ke-" + i);
            int j = 1;
            // Perulangan dalam1
            do {
                System.out.println("  Perulangan dalam ke-" + j);
                j++;
            } while (j <= 0);
            i++;
        } while (i <= 0);
    }
}
