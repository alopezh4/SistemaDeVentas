<%-- 
    Document   : Principal
    Created on : 7/02/2022, 01:00:38 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    
        <nav class="navbar navbar-expand-lg navbar-light bg-info">


            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <b><a style="color:black" class="nav-link">Home PROD</a></b>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Clientes&accion=Listar" target="myFrame">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=RegistrarVenta&accion=default" target="myFrame">Nueva venta</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown text-center">
                <a class="btn btn-outline-light dropdown-toggle" style="border: none" type="button" id="dropdownMenuButton1" data-toggle="dropdown" aria-expanded="false">
                    ${usuario.getNom()}
                </a>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                    <a class="dropdown-item" href="#">
                        <img src="img/usuario.png" alt="60" width="60"/>
                    </a>
                    <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                    <a class="dropdown-item" href="#">ususario@gmail.com</a>
                    <div class="dropdown-divider text-center"></div>
                    <form action="Validar" method="POST">
                        <input type="submit" class="dropdown-item" name="accion" value="salir"/>
                    </form>
                </div>
            </div>
        </nav>
        <h1>Bienvenido al Sistema de Ventas</h1>
        <div class="m-4" style="height: 550px">
            <iframe name="myFrame" style="height: 100% ; width: 100%" >

            </iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js" integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2" crossorigin="anonymous"></script>
    

