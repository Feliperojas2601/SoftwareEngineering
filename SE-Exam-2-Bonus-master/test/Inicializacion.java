/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.TomarDato;
import DAO.RegistroDatoDAO;
import DAO.SensorDAO;
import entidad.Sensor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Inicializacion {
    
    public Inicializacion() {
    }
     
    @Test
    public void initData() {
        SensorDAO dao = new SensorDAO();
        Sensor s = new Sensor(); 
        s.setHoras(2);
        s.setLugar("Patio Bonito");
        s.setPromedio(false);
        s.setTipo("VIB");
        s.setValorMaximo(1);
        s.setValorMinimo(0); 
        s.setNombre("Vibración");
        dao.crear(s);
    }
}
