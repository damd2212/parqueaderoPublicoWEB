/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueaderopublico.negocio;

import java.util.List;

/**
 *
 * interfaz parqueadero que tiene el metodo getParqueadero
 */
public interface IParqueadero {
    public List<Parqueadero> getParqueadero();//metodo que da la lista de parqueaderos de la base de datos
}
