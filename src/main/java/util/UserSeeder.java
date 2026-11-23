/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import config.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class UserSeeder {
    private UserSeeder() {}

    public static void main(String[] args) {
        try {
            seed("admin", "Admin@123".toCharArray(), "ADMIN");
            seed("operator", "Operator@123".toCharArray(), "OPERATOR");
            System.out.println("User demo siap. Jalankan aplikasi lalu login.");
        } catch (SQLException ex) {
            System.err.println("Gagal membuat user demo: " + ex.getMessage());
        }
    }

    private static void seed(String username, char[] password, String role) throws SQLException {
        String sql = "INSERT IGNORE INTO users (username, password_hash, role, aktif) VALUES (?, ?, ?, 1)";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
            ps.setString(3, role);
            ps.executeUpdate();
        } finally {
            Arrays.fill(password, '\0');
        }
    }
}
