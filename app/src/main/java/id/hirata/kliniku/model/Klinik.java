package id.hirata.kliniku.model;

public class Klinik {

    private String nama;
    private String alamat;
    private int harga;
    private double rating;
    private int antrian;
    private int gambar;

    public Klinik() {
    }

    public Klinik(String jenis, String nama, String alamat, int harga, double rating, int antrian, int gambar) {
        this.jenis = jenis;
        this.nama = nama;
        this.alamat = alamat;
        this.harga = harga;
        this.rating = rating;
        this.antrian = antrian;
        this.gambar = gambar;
    }

    private String jenis;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getAntrian() {
        return antrian;
    }

    public void setAntrian(int antrian) {
        this.antrian = antrian;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

}
