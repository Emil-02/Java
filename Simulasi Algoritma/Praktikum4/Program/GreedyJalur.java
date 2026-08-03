public class GreedyJalur{
    static void cariJalurTerkecil (int[][] matriks) {
        int baris = matriks.length;
        int kolom = matriks[0].length;
        int i=0, j=0;
        while (i != baris - 1 || j != kolom - 1) {
            System.out.println("(" + i + "," + j + ")");
            if (i == baris-1) {
                System.out.println("(" + i + "," + (j+1) + ")");
                j++;
            } else if (j == kolom - 1) {
                System.out.println("(" + (i+1) + "," + j + ")");
                i++;
            } else {
                if (matriks[i+1][j] < matriks[i][j+1]) {
                    System.out.println("(" + (i+1) + "," + j + ")");
                    i++;
                } else { 
                    System.out.println("(" + i + "," + (j+1) + ")");
                    j++;
                }
            }
        }
        System.out.println("(" + (baris-1) + "," + (kolom-1) + ")");
    }
    public static void main(String[] args) {
    int[][] matriks = {
        {1, 3, 5},
        {2, 4, 6},
        {7, 8, 9}
    };
    System.out.println("Jalur terkecil:");
    cariJalurTerkecil(matriks);
    }
}