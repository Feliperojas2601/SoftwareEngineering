
package Controlador;

import DAO.RegistroDatoDAO;
import entidad.RegistroDato;
import java.util.List;


public class MostrarDato {
    public MostrarDato (){
        
    }
    public List <RegistroDato> obtener5Datos (){
        RegistroDatoDAO dao = new RegistroDatoDAO(); 
        return dao.leer5();
    }
}
