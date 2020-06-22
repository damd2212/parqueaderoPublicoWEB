/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueaderopublico.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Permite conectarse a la base de datos agenda
 * @author Libardo
 */
public class ConexionMysql {

    private Connection conexion;

    private final String baseDatos;
    private final String usuario;
    private final String contraseña;
    private final String url;

    public ConexionMysql() {
        conexion = null;
        baseDatos = "parqueaderopopayan";
        usuario = "root";
        contraseña = "usuario";
        url = "jdbc:mysql://localhost/" + baseDatos;
    }

    /**
     * Permite hacer la conexion con la base de datos
     *
     * @return
     */
    public int conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //crea una instancia de la controlador de la base de datos
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            return 1;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error conectándose a la bd: " + e.getMessage());
        }
        return -1;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    /**
     * Retorna un objeto que almacena la referencia a la conexion con la base de
     * datos
     *
     * @return
     */
    public Connection getConnection() {
        return conexion;
    }

}