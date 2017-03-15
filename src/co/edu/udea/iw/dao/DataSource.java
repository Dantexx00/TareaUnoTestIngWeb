package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.*;

/**
 * @author Santiago Zapata Palacio
 *Clase singleton que se encarga de entregarnos conexiones activas a la base de datos
 **/
public class DataSource{
	
	private static DataSource dataSource = null;
	private static Connection con = null;
			
	private DataSource() { }
	
	public static DataSource getInstance() throws MyException
	{
		if(dataSource == null)
		{
			dataSource = new DataSource();
		}
		return dataSource;
	}
	
	protected static Connection generateConnection() throws MyException{
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/IngWeb", "root", "root");
		}catch(ClassNotFoundException e){
			throw new MyException("Driver no encontrado", e);
		}catch(SQLException e){
			throw new MyException("No se puede realizar la conexión", e);
		}
		return con;
	}

	public static Connection getConnection() throws MyException, SQLException {
		if((con == null) || (con.isClosed()))
		{
			con = generateConnection();
		}
		return con;
	}
	
}
