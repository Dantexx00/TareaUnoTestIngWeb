package co.edu.udea.iw.dao.impl;

/*
 * @Author: Santiago Zapata Palacio
 * Clase prueba para la clase CiudadDaoImp
 */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;

import co.edu.udea.iw.dto.Ciudad;

import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImpTest {

	//Prueba del metodo para obtener las ciudades
	@Test
	public void testObtenerCiudades() {
		CiudadDAO ciudadDao = null;
		List<Ciudad> lista = null;
		try{
			ciudadDao = new CiudadDAOImp();
			lista = ciudadDao.obtener();
			assertTrue(lista.size() > 0);
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}
	
	//Prueba que se encarga de probar el metodo de obtener una ciudad por el codigo
	@Test
	public void testObtenerCiudadPorId() {
		CiudadDAO ciudadDao = null;
		Ciudad ciudad = null;
		try{
			ciudadDao = new CiudadDAOImp();
			ciudad = ciudadDao.obtener(1L);
			assertTrue(ciudad != null);
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}

}
