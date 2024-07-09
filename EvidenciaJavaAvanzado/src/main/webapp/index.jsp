<%-- 
    Document   : login
    Created on : 7 jul. 2024, 11:26:39
    Author     : JuanAntonioFloresZah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de IMC</title>
        <!-- Include Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        
        <div class="container">
            <h1>Bienvenido a tu Control de IMC</h1>
            <h2>¿Ya estás Registrado?</h2>
            <h3>Identifícate</h3>
            <form action="SVLogin" method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-primary">Ingresar</button>
                
            </form>
            <p style=color:red;>${mensaje} </p>
            <c:remove var="mensaje" scope="session" />
            <h2>O, Regístrate</h2>
            <form action="/EvidenciaJavaAvanzado/registrapersona.jsp" method="POST">
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
        
        <!-- Include Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
