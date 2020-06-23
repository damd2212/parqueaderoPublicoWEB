<%@page import="java.util.List"%>
<%@page import="co.unicauca.parqueaderopublico.negocio.Parqueadero"%>
<%@page import="java.util.*"%>



<%
    List<Parqueadero> parqueaderos = (List<Parqueadero>) request.getAttribute("parqueaderos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>Parqueaderos Publicos</title>
    </head>
    <body>

        <div class="media">
            <img src="images/LogoParqueadero.png"class="mr-3" alt="...">
            <div class="media-body">
                <h5 class="mt-0"></h5>

            </div>
        </div>
        <div class="container">
            <table class="table table-bordered ">
                <tr class="bg-info">
                    <th>NOMBRE</th>
                    <th>DIRECCION PARQUEADERO</th>
                    <th>TELEFONO</th>
                    <th>PUESTOS LIBRES</th>
                    <th>PUESTOS OCUPADOS</th>
                    

                </tr>   
                <h1>Parqueaderos publicos</h1>


                <% for (Parqueadero parqueadero : parqueaderos) {%>
                <tr class="bg-warning">

                    <td> <%= parqueadero.getNomParqueadero()%> </td>
                    <td>  <%= parqueadero.getDirecParqueadero()%> </td>
                    <td>  <%= parqueadero.getTelParqueadero()%> </td>
                    <td> <%= parqueadero.getPuestosLibres()%> </td>
                    <td>  <%= parqueadero.getPuestosOcupados()%> </td>
                    
                </tr>  
                <%}%>
            </table> 

        </div>

    </body>
</html>
