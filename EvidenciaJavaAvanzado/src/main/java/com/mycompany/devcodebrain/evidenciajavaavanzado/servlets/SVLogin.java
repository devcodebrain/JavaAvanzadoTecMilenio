/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.devcodebrain.evidenciajavaavanzado.servlets;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.Controladora;
import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMC;
import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMCControladora;
import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuanAntonioFloresZah
 */
@WebServlet(name = "SVLogin", urlPatterns = {"/SVLogin"})
public class SVLogin extends HttpServlet {
Controladora control = new Controladora();
IMCControladora controlIMC = new IMCControladora();
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

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
       
        
        Persona per= new Persona();
        per = control.findByUsernameAndPassword(username,password);
        if (per.getId() != -1)
        {
            List<IMC> imcs = new ArrayList<IMC>();
            imcs = controlIMC.traeIMC();
            HttpSession sesion = request.getSession(false);
            sesion.setAttribute("IdPersona",per.getId());
            sesion.setAttribute("nombre",per.getNombre());
            sesion.setAttribute("apellido_paterno",per.getApellido_paterno());
            sesion.setAttribute("apellido_materno",per.getApellido_materno());
            sesion.setAttribute("estatura",per.getEstatura());
            sesion.setAttribute("email",per.getEmail());
            sesion.setAttribute("fecha_registro",per.getFecha_registro());
            sesion.setAttribute("imcs",imcs);
            response.sendRedirect("consultapersona.jsp");
        
        }else
        {
             String mensaje = "El usuario o la contraeña son incorrectos";
             HttpSession sesion = request.getSession(false);
             sesion.setAttribute("mensaje",mensaje);
             response.sendRedirect("index.jsp");
             
        }
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
