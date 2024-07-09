<%-- 
    Document   : consultapersona
    Created on : 8 jul. 2024, 11:55:16
    Author     : JuanAntonioFloresZah
--%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.devcodebrain.evidenciajavaavanzado.logica.IMC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido!!</title>
        <!-- Include Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            .center-text {
                text-align: center;
            }
            .table-container {
            margin-top: 20px;
        }
        .table-container table {
            width: 100%;
            border-collapse: collapse;
        }
        .table-container th, .table-container td {
            padding: 8px;
            border: 1px solid #ddd;
            text-align: left;
        }
        .table-container th {
            background-color: #f2f2f2;
        }
        </style>
    </head>
    <body>
        <div class="container">
            <%
                HttpSession sesion=request.getSession(false);
                Enumeration e=sesion.getAttributeNames();
                if(e.hasMoreElements())
                {
                    out.print("<h1 class='center-text'>Bienvenido a tu Control de IMC</h1>");
                    //out.print("<p>Nombre: " + session.getAttribute("nombre") + " " + session.getAttribute("apellido_paterno") + " " + session.getAttribute("apellido_materno") + "</p>");
                    //out.print("<p>Estatura: " + session.getAttribute("estatura") + " mts.</p>");
                    //out.print("<p>Correo Electrónico: " + session.getAttribute("email") + "</p>");
                    //out.print("<p>Fecha de Registro: " + session.getAttribute("fecha_registro") + "</p>");
                }
            %>
        </div>
         <div class="container center-text">
             <p><b>Hola :<%=session.getAttribute("nombre") + " " + session.getAttribute("apellido_paterno") + " " + session.getAttribute("apellido_materno")%></b></p>
             <p>Estatura :<%= session.getAttribute("estatura") + " mts."%></p>
             <p>Correo Electrónico :<%= session.getAttribute("email")%></p>
             
         </div>
             
             <div class="container center-text table-container">
             <h1><b>A continuación te mostramos el registro de tu IMC</b></h1>
             <table>
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Estatura</th>
                        <th>Peso</th>
                        <th>IMC</th>
                        <th>Clasificación</th>
                    </tr>
                </thead>
             <%
                 List<IMC> imcs = (List)session.getAttribute("imcs");
                 int cont = 1;
                 for(IMC imc :imcs){
             %>
            <tr>
                <td><%=imc.getTimeStmp() %></td>
                <td><%=imc.getEstatura()%></td>
                <td><%=imc.getPeso() %> Kgs.</td>
                <td><%=imc.getIMC()%></td>
                <td><%=imc.getClasificacion()%></td>
            </tr>
            <%cont = cont + 1;%>
            <%}%>
             
         </div>
            <form action="/EvidenciaJavaAvanzado/registraIMC.jsp" method="POST">
                <button type="submit" class="btn btn-primary">Registrar nuevo IMC</button>
               
            </form>
        
        <!-- Include Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>