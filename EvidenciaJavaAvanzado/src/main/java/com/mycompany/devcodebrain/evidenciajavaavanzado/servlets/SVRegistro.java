/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.devcodebrain.evidenciajavaavanzado.servlets;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.Controladora;
import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.Persona;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JuanAntonioFloresZah
 */
@WebServlet(name = "SVRegistro", urlPatterns = {"/SVRegistro"})
public class SVRegistro extends HttpServlet {
Controladora control = new Controladora();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apellido_paterno = request.getParameter("apellido_paterno");
        String apellido_materno = request.getParameter("apellido_materno");
        String estatura = request.getParameter("estatura");
        String email = request.getParameter("email");
        //Date fecha_registro = date  request.getParameter("fecha_registro");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Persona per = new Persona();
        java.util.Date today = new java.util.Date();
        per.setNombre(nombre);
        per.setApellido_paterno(apellido_paterno);
        per.setApellido_materno(apellido_materno);
        per.setEstatura(Float.valueOf(estatura) );
        per.setEmail(email);
        per.setUsername(username);
        per.setPassword(password);
        per.setFecha_registro(today);
        per.setEstatus(1);
        
        control.crearPersona(per);
        processRequest(request, response);
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
