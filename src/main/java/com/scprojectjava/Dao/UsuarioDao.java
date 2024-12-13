/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.Dao;


import com.scprojectjava.DbConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
    public boolean validarUsuario(String nombreUsuario, String contrasena) {
        boolean isValid = false;

        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ? AND activo = 1";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contrasena); // Si usas hashing, compara el hash.

            ResultSet rs = stmt.executeQuery();
            isValid = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
