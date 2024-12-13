/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.controller;


import com.scprojectjava.Dao.UnidadesDao;
import com.scprojectjava.model.Unidad;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UnidadesServlet")
public class UnidadesServlet extends HttpServlet {
    private final UnidadesDao unidadesDao = new UnidadesDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (null == action) {
            List<Unidad> unidades = unidadesDao.obtenerUnidades();
            request.setAttribute("unidades", unidades);
            request.getRequestDispatcher("unidades.jsp").forward(request, response);
        } else switch (action) {
            case "editar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Unidad unidad = unidadesDao.obtenerUnidadPorId(id);
                    request.setAttribute("unidad", unidad);
                    request.getRequestDispatcher("editar_unidad.jsp").forward(request, response);
                    break;
                }
            case "eliminar":
                {
                    int id = Integer.parseInt(request.getParameter("id"));
                    unidadesDao.eliminarUnidad(id);
                    response.sendRedirect("UnidadesServlet");
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
        String abreviatura = request.getParameter("abreviatura");
        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            Unidad nuevaUnidad = new Unidad(nombre, abreviatura, 1);
            unidadesDao.agregarUnidad(nuevaUnidad);
        } else {
            Unidad unidadActualizada = new Unidad(Integer.parseInt(id), nombre, abreviatura, 1);
            unidadesDao.actualizarUnidad(unidadActualizada);
        }
        response.sendRedirect("UnidadesServlet");
    }
}
