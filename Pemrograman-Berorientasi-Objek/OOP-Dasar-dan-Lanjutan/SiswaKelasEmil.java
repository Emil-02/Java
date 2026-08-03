public class SiswaKelasEmil {
    // Private attributes
    private String ErNama;
    private int ErNilai;
    private String ErKelas;
    // Constructor
    public SiswaKelasEmil(String ErNama, int ErNilai, String ErKelas) {
        this.ErNama = ErNama;
        setErNilai(ErNilai);
        this.ErKelas = ErKelas;
    }
    // Getter dan setter
    public String getErNama() {
        return ErNama;
    }
    public void setErNama(String ErNama) {
        this.ErNama = ErNama;
    }
    public int getErNilai() {
        return ErNilai;
    }
    public void setErNilai(int ErNilai) {
        if (ErNilai >= 0 && ErNilai <= 100) {
            this.ErNilai = ErNilai;
        } else {
            System.out.println("Nilai harus antara 0-100");
        }
    }
    public String getErKelas() {
        return ErKelas;
    }
    public void setErKelas(String ErKelas) {
        this.ErKelas = ErKelas;
    }
    // Method getGrade
    public String getGrade() {
        if (ErNilai >= 85) return "A";
        else if (ErNilai >= 70) return "B";
        else if (ErNilai >= 55) return "C";
        else return "D";
    }
    // Main untuk tes
    public static void main(String[] args) {
        SiswaKelasEmil ErS1 = new SiswaKelasEmil("Emil Rahmat", 92, "2-F Informatika");
        System.out.println("Nama: " + ErS1.getErNama());
        System.out.println("Nilai: " + ErS1.getErNilai());
        System.out.println("Kelas: " + ErS1.getErKelas());
        System.out.println("Grade: " + ErS1.getGrade());
    }
}
