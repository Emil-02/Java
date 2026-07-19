import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements Inventory {
    
    // Tempat menyimpan data simpel
    private List<String> gudang;

    protected Server() throws RemoteException {
        gudang = new ArrayList<>();
    }

    @Override
    public void tambah(String namaBarang, int jumlah) throws RemoteException {
        String data = namaBarang + " (" + jumlah + " unit)";
        gudang.add(data);
        System.out.println("LOG SERVER: Klien baru saja menambahkan -> " + data);
    }

    @Override
    public List<String> lihatSemua() throws RemoteException {
        System.out.println("LOG SERVER: Klien meminta data gudang.");
        return gudang;
    }

    public static void main(String[] args) {
        try {
            // PENTING: Ganti dengan IP Address WiFi dari Laptop Server ini!
            System.setProperty("java.rmi.server.hostname", "192.168.1.100"); 

            Server server = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Gudang", server);
            
            System.out.println("Server Gudang siap menerima koneksi dari klien...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}