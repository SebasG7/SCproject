/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.controller;

import com.scprojectjava.Dao.CategoriasDao;
import com.scprojectjava.model.Categoria;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CategoriasServlet")
public class CategoriasServlet extends HttpServlet {
    private final CategoriasDao categoriasDao = new CategoriasDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (null == action) {
            List<Categoria> categorias = categoriasDao.obtenerCategorias();
            request.setAttribute("categorias", categorias);
            request.getRequestDispatcher("categorias.jsp").forward(request, response);
        } else switch (action) {
            case "editar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Categoria categoria = categoriasDao.obtenerCategoriaPorId(id);
                    request.setAttribute("categoria", categoria);
                    request.getRequestDispatcher("editar_categoria.jsp").forward(request, response);
                    break;
                }
            case "eliminar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    categoriasDao.eliminarCategoria(id);
                    response.sendRedirect("CategoriasServlet");
                    break;
                }
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            Categoria nuevaCategoria = new Categoria(nombre, descripcion, 1);
            categoriasDao.agregarCategoria(nuevaCategoria);
        } else {
            Categoria categoriaActualizada = new Categoria(Integer.parseInt(id), nombre, descripcion, 1);
            categoriasDao.actualizarCategoria(categoriaActualizada);
        }
        response.sendRedirect("CategoriasServlet");
    }
}
