<%-- 
    Document   : registraIMC
    Created on : 8 jul. 2024, 13:56:19
    Author     : JuanAntonioFloresZah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de IMC</title>
        <!-- Add Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Add custom CSS for modern style -->
        <style>
            body {
                background-color: #f8f9fa;
                padding: 20px;
            }
            h1 {
                color: #343a40;
                font-size: 24px;
                margin-bottom: 20px;
            }
            form {
                max-width: 400px;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            label {
                font-weight: bold;
            }
            input[type="text"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ced4da;
                border-radius: 5px;
                margin-bottom: 10px;
            }
            button[type="submit"] {
                background-color: #007bff;
                color: #fff;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>Hola, favor de ingresar los siguientes datos</h1>
        <form action="SVRegistroIMC" method="POST">
            <div class="form-group">
                <label for="estatura">Estatura</label>
                <input type="text" name="estatura" class="form-control">
            </div>
            <div class="form-group">
                <label for="peso">Peso</label>
                <input type="text" name="peso" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
        
        <!-- Add Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>