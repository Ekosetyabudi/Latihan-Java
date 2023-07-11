/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lat;

/**
 *
 * @author user
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class Lat {
    

    /**
     * @param args the command line arguments
     */
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cucispatu";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    public static void main(String[] args) {
        // TODO code application logic here
         try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                showMenu();
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Tambah  Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Ubah Data");
        System.out.println("4. Hapus Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("SILAHKAN PILIH MENU DIATAS:");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    ubahData();
                    break;
                case 4:
                    hapusData();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void tambahData() {
        try {
            System.out.println("++ MASUKAN DATA PENCUCIAN ++");
            System.out.print("Id Sepatu Yang ingin di Cuci : ");
            String idcuci = input.readLine().trim();
            System.out.print("Merk Sepatu: ");
            String merk = input.readLine().trim();
            System.out.print("Pemilik Sepatu: ");
            String pemilik = input.readLine().trim();
 
            String sql = "INSERT INTO dt_cuci (idcuci, merk, pemilik) VALUE('%s', '%s', '%s')";
            sql = String.format(sql, idcuci, merk, pemilik);

            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void tampilData() {
        String sql = "SELECT * FROM dt_cuci";

        try {
            rs = stmt.executeQuery(sql);
            
            System.out.println("===    DATA PELANGAN CUCI SEPATU JAYA   ===");
            System.out.println("Kd cuci|Merk Sepatu|Pemilik Sepatu|");
            while (rs.next()) {
                String idcuci = rs.getString("idcuci");
                String merk = rs.getString("merk");
                String pemilik = rs.getString("pemilik");

                
                System.out.println(String.format("%s.\t %s\t (%s)", idcuci, merk, pemilik));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void ubahData() {
        try {
            
            System.out.print("Masukan ID Cuci Yang ingin di ubah: ");
            String idcuci = input.readLine().trim();
            System.out.print("Merk Sepatu: ");
            String merk = input.readLine().trim();
            System.out.print("Pemilik Sepatu: ");
            String pemilik = input.readLine().trim();

            String sql = "UPDATE dt_cuci SET merk='%s', pemilik='%s' WHERE idcuci=%s";
            sql = String.format(sql, merk, pemilik, idcuci);

            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void hapusData() {
        try {
            
            System.out.print("Masukan ID yang Ingin Di hapus: ");
            String idcuci = input.readLine().trim();
            // buat query hapus
            String sql = String.format("DELETE FROM dt_cuci WHERE idcuci=%s", idcuci);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
