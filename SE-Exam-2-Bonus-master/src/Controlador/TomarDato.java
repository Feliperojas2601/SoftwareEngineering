/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.RegistroDatoDAO;
import entidad.RegistroDato;
import entidad.Sensor;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class TomarDato {
    
    public TomarDato(){
        
    }
    
    public void GenerarDato (Sensor sensor){
      RegistroDatoDAO dao = new RegistroDatoDAO();
      RegistroDato registroDato = new RegistroDato();
      registroDato.setSensor(sensor);
      Date fecha = new Date();
      registroDato.setFecha(fecha);
      Random randomno = new Random();
      boolean value = randomno.nextBoolean();
      if(value){
          registroDato.setDatoTomado(0);
          registroDato.setProcesamiento("Vibrando");
          dao.crear(registroDato);
      }else{
          registroDato.setDatoTomado(1);
          registroDato.setProcesamiento("Reposo");
          dao.crear(registroDato);
      }
    }
}
