import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            // PENTING: Ganti dengan IP Address WiFi dari Laptop Server!
            String ipServer = "192.168.1.100"; 
            
            // Menyambung ke laptop server lewat jaringan
            Registry registry = LocateRegistry.getRegistry(ipServer, 1099);
            Inventory gudang = (Inventory) registry.lookup("Gudang");
            
            System.out.println("CLIENT: Mengirim data barang ke server...");
            gudang.tambah("Laptop ASUS", 10);
            gudang.tambah("Mouse Wireless", 25);
            
            System.out.println("\nCLIENT: Meminta daftar barang dari server...");
            List<String> daftar = gudang.lihatSemua();
            for (String barang : daftar) {
                System.out.println("- " + barang);
            }
            
        } catch (Exception e) {
            System.out.println("Gagal terhubung! Pastikan IP benar dan Firewall di Server mati.");
            e.printStackTrace();
        }
    }
}