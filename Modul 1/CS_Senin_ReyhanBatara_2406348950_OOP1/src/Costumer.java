public class Costumer {
    private String nama;
    private Kendaraan kendaraan;

    public Costumer(String nama, Kendaraan kendaraan) {
        this.nama = nama;
        this.kendaraan = kendaraan;
    }

    public double  getTotalPrice() {
        return Kendaraan != null?
                kendaraan harga : 0
    }

    public void showDetail() {
        System.out.println("Costumer Name: " + nama);
        kendaraan.showDetail();
    }
}
