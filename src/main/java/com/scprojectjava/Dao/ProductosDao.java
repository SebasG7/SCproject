/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.Dao;

import com.scprojectjava.DbConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.scprojectjava.model.Producto;

public class ProductosDao {

    public List<Producto> obtenerProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.descripcion, p.precio, p.stock, "
                   + "c.nombre AS categoria, u.nombre AS unidad "
                   + "FROM productos p "
                   + "INNER JOIN categorias c ON p.id_categoria = c.id "
                   + "INNER JOIN unidades u ON p.id_unidad = u.id "
                   + "WHERE p.activo = 1";

        try (Connection conn = DbConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("stock"),
                    rs.getString("categoria"),
                    rs.getString("unidad")
                );
                lista.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, stock, id_categoria, id_unidad, activo) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.setInt(5, producto.getIdCategoria());
            stmt.setInt(6, producto.getIdUnidad());
            stmt.setInt(7, 1);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, precio = ?, stock = ?, "
                   + "id_categoria = ?, id_unidad = ? WHERE id = ?";

        try (Connection conn = DbConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setInt(4, producto.getStock());
            stmt.setInt(5, producto.getIdCategoria());
            stmt.setInt(6, producto.getIdUnidad());
            stmt.setInt(7, producto.getId());
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        String sql = "UPDATE productos SET activo = 0 WHERE id = ?";

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
