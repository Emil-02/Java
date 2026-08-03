package LinkList;
public class Main {
    public static void main(String[] args) {
        Operasi listSaya = new Operasi();
        System.out.println("\n Melakukan Sisip Depan ");
        listSaya.sisip_depan(10);
        listSaya.tampil();
        System.out.println("\nMelakukan Sisip Belakang 20");
        listSaya.sisip(20);
        listSaya.tampil();
        System.out.println("\nMelakukan Sisip Depan 5");
        listSaya.sisip_depan(5);
        listSaya.tampil(); 
        System.out.println("\nMelakukan Sisip Tengah 15 di posisi 3");
        listSaya.sisip_tengah(15, 3);
        listSaya.tampil();
        System.out.println("\nMelakukan Sisip Tengah 7 di posisi 2");
        listSaya.sisip_tengah(7, 2);
        listSaya.tampil();
    }
}