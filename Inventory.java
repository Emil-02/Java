import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Inventory extends Remote {
    // Fungsi yang bisa dipanggil klien
    void tambah(String namaBarang, int jumlah) throws RemoteException;
    List<String> lihatSemua() throws RemoteException;
}