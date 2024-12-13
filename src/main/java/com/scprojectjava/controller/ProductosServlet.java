/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.controller;


import com.scprojectjava.Dao.CategoriasDao;
import com.scprojectjava.Dao.ProductosDao;
import com.scprojectjava.Dao.UnidadesDao;
import com.scprojectjava.model.Producto;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductosServlet")
public class ProductosServlet extends HttpServlet {
    private final ProductosDao productosDao = new ProductosDao();
    private final CategoriasDao categoriasDao = new CategoriasDao();
    private final UnidadesDao unidadesDao = new UnidadesDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            List<Producto> productos = productosDao.obtenerProductos();
            request.setAttribute("productos", productos);
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        } else if (action.equals("nuevo") || action.equals("editar")) {
            List<?> categorias = categoriasDao.obtenerCategorias();
            List<?> unidades = unidadesDao.obtenerUnidades();
            request.setAttribute("categorias", categorias);
            request.setAttribute("unidades", unidades);
            request.getRequestDispatcher("editar_producto.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Capturar y guardar datos del producto
        // ...
        response.sendRedirect("ProductosServlet");
    }
}
