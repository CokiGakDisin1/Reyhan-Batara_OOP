public class Kendaraan {
    private String brand;
    private int year;
    private VehicleType type;
    private float harga;

    public Kendaraan(String brand, int year, VehicleType type, float harga) {
       this.brand = brand;
       this.year = year;
       this.type = type;
       this.harga = harga;
    }

    public static void showDetail() {
    System.out.println("Brand: " + brand);
    System.out.println("year: " + year);
    System.out.println("type " + type);
    System.out.println("Harga: " + harga);
    }
}
