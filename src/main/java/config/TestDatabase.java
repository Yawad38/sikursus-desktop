/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
    import java.sql.Connection;
    import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args){
        try (Connection conn = Database.getConnection()){
            if(conn != null && conn.isValid(2)){
                System.out.println("KONEKSI BERHASIL ke db_sikursus");
            }else{
                System.out.println("Koneksi terbentuk tapi tidak valid...");
            }
        }catch (SQLException e){
            System.out.println("Koneksi GAGAL");
            System.out.println(e.getMessage());
        }
    }
}
