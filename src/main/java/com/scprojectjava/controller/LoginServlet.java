/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scprojectjava.controller;


import com.scprojectjava.Dao.UsuarioDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario = request.getParameter("nombre_usuario");
        String contrasena = request.getParameter("contrasena");

        UsuarioDao usuarioDao = new UsuarioDao();

        if (usuarioDao.validarUsuario(nombreUsuario, contrasena)) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", nombreUsuario);
            response.sendRedirect("home.jsp"); // Página de inicio después del login.
        } else {
            response.sendRedirect("login.jsp?error=1"); // Redirige al login con error.
        }
    }
}
