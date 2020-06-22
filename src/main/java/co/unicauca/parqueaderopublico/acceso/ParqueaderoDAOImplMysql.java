/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueaderopublico.acceso;

import co.unicauca.parqueaderopublico.negocio.IParqueadero;
import co.unicauca.parqueaderopublico.negocio.Parqueadero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ParqueaderoDAOImplMysql implements IParqueadero{
    private final ConexionMysql conexion;

    public ParqueaderoDAOImplMysql() {
        conexion = new ConexionMysql();
    }

    @Override
    public List<Parqueadero> getParqueadero() {
      Parqueadero parqueadero = null;
        List<Parqueadero> lista= new ArrayList<>();

        conexion.conectar();
        try {
            PreparedStatement sentencia = null;
            String sql = "SELECT * from parqueadero";
            sentencia = conexion.getConnection().prepareStatement(sql);
            ResultSet res = sentencia.executeQuery();
            while (res.next()) {
                parqueadero = new Parqueadero();
                parqueadero.setNitParqueadero(res.getString("nitParqueadero"));
                parqueadero.setNomParqueadero(res.getString("nomParqueadero"));
                parqueadero.setDirecParqueadero(res.getString("direcParqueadero"));
                parqueadero.setTelParqueadero(res.getString("telParqueadero"));
                parqueadero.setUsuarioPar(res.getString("usuarioPar"));
                parqueadero.setPuestosLibres(res.getString("puestosLibres"));
                parqueadero.setPuestosOcupados(res.getString("puestosOcupados"));
                lista.add(parqueadero);

            }
            sentencia.close();
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error consultado productos\n" + e.getMessage());
        }
        return lista;
}
}