import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
class Buah {
    private final String ErNama;
    private final int ErHarga;
    public Buah(String ErNama, int ErHarga) {
        this.ErNama  = ErNama;
        this.ErHarga = ErHarga;
    }
    public String getErNama()  { return ErNama; }
    public int    getErHarga() { return ErHarga; }
}
public class TokoBuahEmil {
    public static void main(String[] args) {
        List<Buah> ErDaftarBuah = new ArrayList<>();
        ErDaftarBuah.add(new Buah("Jambumente", 32000));
        ErDaftarBuah.add(new Buah("Mangga",      17000));
        ErDaftarBuah.add(new Buah("Durian",      53000));
        Locale ErLocaleID      = Locale.of("id", "ID");
        NumberFormat ErFormat  = NumberFormat.getCurrencyInstance(ErLocaleID);
        System.out.println("=======================================");
        System.out.println("===== Singgahki di Toko Buah Emil =====");
        System.out.println("=======================================");
        System.out.println("\nDaftar Buah yang Tersedia:");
        for (var ErBuah : ErDaftarBuah) {
            System.out.printf("- %-10s: %s%n",
                    ErBuah.getErNama(),
                    ErFormat.format(ErBuah.getErHarga()));
        }
        if (!ErDaftarBuah.isEmpty()) {
            Buah ErBuahTermahal = ErDaftarBuah.get(0);
            Buah ErBuahTermurah = ErDaftarBuah.get(0);
            for (Buah ErBuah : ErDaftarBuah) {
                if (ErBuah.getErHarga() > ErBuahTermahal.getErHarga()) {
                    ErBuahTermahal = ErBuah;
                }
                if (ErBuah.getErHarga() < ErBuahTermurah.getErHarga()) {
                    ErBuahTermurah = ErBuah;
                }
            }
            System.out.println("\n-----------------------------------");
            System.out.printf("Buah Termahal : %s (%s)%n",
                    ErBuahTermahal.getErNama(),
                    ErFormat.format(ErBuahTermahal.getErHarga()));
            System.out.printf("Buah Termurah : %s (%s)%n",
                    ErBuahTermurah.getErNama(),
                    ErFormat.format(ErBuahTermurah.getErHarga()));
            System.out.println("-----------------------------------");
        } else {
            System.out.println("\nMaaf, tidak ada buah yang tersedia saat ini.");
        }
    }
}
