package co.edu.udea.iw.dao;

import co.edu.udea.iw.exception.MyException;

import java.util.List;

import co.edu.udea.iw.dto.*;

/**
 * @author Santiago Zapata Palacio
 * Interfaz que define los metodos del CiudadDAO
 **/
public interface CiudadDAO {
	public List<Ciudad> obtener() throws MyException;
	public Ciudad obtener(Long codigo) throws MyException;
}
