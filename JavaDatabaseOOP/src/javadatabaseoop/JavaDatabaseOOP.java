/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseoop;

import java.sql.*;
import java.util.*;

public class JavaDatabaseOOP {

    private static final String URL = "jdbc:postgresql://localhost:5432/KoneksiOOP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "oreobi131";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // CREATE 
    public static void insert(mahasiswa m) {
        String sql = "INSERT INTO mahasiswa (nim, nama, jenis_mahasiswa, jumlah_sks, biaya_kuliah) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, m.nim);
            stmt.setString(2, m.nama);
            stmt.setString(3, m.jenis);
            stmt.setInt(4, m.sks);
            stmt.setDouble(5, m.biaya);

            stmt.executeUpdate();

            System.out.println("Data berhasil ditambahkan ke database.");

        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());

        }
    }

    // READ 
    public static List<mahasiswa> getAllmahasiswa() {
        List<mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa ORDER BY id ASC";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                mahasiswa m = new mahasiswa(
                        rs.getInt("id"),
                        rs.getInt("nim"),
                        rs.getString("nama"),
                rs.getString("jenis_mahasiswa")
                ,
                       rs.getInt("jumlah_sks")
                ,
                       rs.getDouble("biaya_kuliah")
                );
                list.add(m);
            }

        } catch (SQLException e) {
            System.out.println("Error read: " + e.getMessage());
        }
        return list;
    }

    //  UPDATE 
    public static void update(mahasiswa m) {
        String sql = "UPDATE mahasiswa SET nim = ?, nama = ? , jenis_mahasiswa = ?, jumlah_sks = ?, biaya_kuliah = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, m.nim);
            stmt.setString(2, m.nama);
            stmt.setString(3, m.jenis);
            stmt.setInt(4, m.sks);
            stmt.setDouble(5, m.biaya);
           
            stmt.setInt(6, m.id);

            stmt.executeUpdate();
            System.out.println("Data berhasil diperbarui di database.");

        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

    //  DELETE 
    public static void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus dari database.");

        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }

}
