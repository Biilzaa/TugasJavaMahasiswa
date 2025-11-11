package javadatabaseoop;

public class mahasiswa {

    int id;
    int nim;
    String nama;
    int tahunmasuk;

    // Constructor tanpa id (untuk insert)
    public mahasiswa(int nim, String nama, int tahunmasuk) {
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
    }

    // Constructor dengan id (untuk read/update/delete)
    public mahasiswa(int id, int nim, String nama, int tahunmasuk) {
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
    }
}
