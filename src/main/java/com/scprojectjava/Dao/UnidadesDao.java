package com.scprojectjava.Dao;

import com.scprojectjava.DbConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.scprojectjava.model.Unidad;

public class UnidadesDao {
    public List<Unidad> obtenerUnidades() {
        List<Unidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM unidades WHERE activo = 1";

        try (Connection conn = DbConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Unidad unidad = new Unidad(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("abreviatura"),
                    rs.getInt("activo")
                );
                lista.add(unidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Unidad obtenerUnidadPorId(int id) {
        Unidad unidad = null;
        String sql = "SELECT * FROM unidades WHERE id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                unidad = new Unidad(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("abreviatura"),
                    rs.getInt("activo")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unidad;
    }

    public boolean agregarUnidad(Unidad unidad) {
        String sql = "INSERT INTO unidades (nombre, abreviatura, activo) VALUES (?, ?, ?)";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, unidad.getNombre());
            stmt.setString(2, unidad.getAbreviatura());
            stmt.setInt(3, unidad.getActivo());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizarUnidad(Unidad unidad) {
        String sql = "UPDATE unidades SET nombre = ?, abreviatura = ? WHERE id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, unidad.getNombre());
            stmt.setString(2, unidad.getAbreviatura());
            stmt.setInt(3, unidad.getId());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarUnidad(int id) {
        String sql = "UPDATE unidades SET activo = 0 WHERE id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
