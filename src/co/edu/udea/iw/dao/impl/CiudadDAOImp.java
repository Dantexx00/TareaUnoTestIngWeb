package co.edu.udea.iw.dao.impl;

/*
 *@Author: Santiago Zapata Palacio
 *Clase que realiza las consultas a la tabla Ciudades 
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImp implements CiudadDAO {

	//Metodo que devuelve todas las ciudades
	@Override
	public List<Ciudad> obtener() throws MyException {
		DataSource ds = null; 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> lista = new ArrayList<Ciudad>();
		try{
			ds = DataSource.getInstance();
			con = ds.getConnection();
			ps = con.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while(rs.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			}
		}catch(SQLException e){
			throw new MyException("Error consultando", e);
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				throw new MyException("Error cerrando", e);
			}
		}
		return lista;
	}

	//Metodo que devuelve una ciudad con su codigo
	@Override
	public Ciudad obtener(Long codigo) throws MyException {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Ciudad ciudad = null;
		try{
			ds = DataSource.getInstance();
			con = ds.getConnection();
			ps = con.prepareStatement("select * from ciudades where codigo = ?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			if(rs.next()){
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
			}
		}
		catch(SQLException e)
		{
			throw new MyException("Error consultando", e);
		}
		finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException e){
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudad;
	}

}
