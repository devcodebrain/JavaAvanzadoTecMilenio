/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.devcodebrain.evidenciajavaavanzado.servlets;

import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMC;
import com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMCControladora;
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
@WebServlet(name = "SVRegistroIMC", urlPatterns = {"/SVRegistroIMC"})
public class SVRegistroIMC extends HttpServlet {
IMCControladora control = new IMCControladora();
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
        
        
        HttpSession session =request.getSession(false);
        
        IMC imc = new IMC();
        
        String tempestatura = request.getParameter("estatura");
        float estatura = Float.parseFloat(tempestatura);
        float peso = Float.parseFloat(request.getParameter("peso"));
        double estaturaalcuadrado = (Math.pow(estatura, 2));
        double calculoIMC = peso/estaturaalcuadrado;
        java.util.Date today = new java.util.Date();
        
        int IdPersona = (int)session.getAttribute("IdPersona");
        imc.setIdPersona(IdPersona);
        imc.setEstatura(estatura);
        imc.setPeso(peso);
        imc.setTimeStmp(today);
        imc.setIMC((float) calculoIMC);
        
        
        if (calculoIMC <= 18.5)
        {
            imc.setClasificacion("Bajo Peso");
        }else if (calculoIMC >18.5 && calculoIMC < 24.9)
        {
             imc.setClasificacion("Peso Normal");
        }else if (calculoIMC >25 && calculoIMC < 29.9)
        {
             imc.setClasificacion("Sobre Peso");
        }else if (calculoIMC >30 )
        {
             imc.setClasificacion("Obesidad");
        }
     
        control.crearIMC(imc);
         response.sendRedirect("consultapersona.jsp");
           List<IMC> imcs = new ArrayList<IMC>();
           imcs = controlIMC.traeIMC();
            HttpSession sesion = request.getSession(false);
            sesion.setAttribute("imcs",imcs);
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
