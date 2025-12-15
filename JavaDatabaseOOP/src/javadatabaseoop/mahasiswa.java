package javadatabaseoop;

public class mahasiswa {

    int id;
    int nim;
    String nama;
    String jenis;
    int sks;
    double biaya;

    public mahasiswa(int nim, String nama, String jenis, int sks) {
        this.nim = nim;
        this.nama = nama;
        this.jenis = jenis;
        this.sks = sks;
        this.biaya = hitungBiayaKuliah();
    }

    public mahasiswa(int id, int nim, String nama, String jenis, int sks, double biaya) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jenis = jenis;
        this.sks = sks;
        this.biaya = biaya;
    }
    public double hitungBiayaKuliah() {
        return 0;
    }
}
