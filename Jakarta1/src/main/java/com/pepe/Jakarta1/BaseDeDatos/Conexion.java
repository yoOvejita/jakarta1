package com.pepe.Jakarta1.BaseDeDatos;
import java.sql.*;
import java.util.Enumeration;

public class Conexion {
	//Paso 1: importar el paquete java.sql.*
	//Paso 2: Cargar los drivers. Agregar la dependencia al POM
	public Conexion() {
		//Paso 3: Registrar el driver
		try {
			//Alternativa 1:
			Class.forName("org.postgresql.Driver");
			
			//Alternativa 2:
			/*Enumeration en = DriverManager.getDrivers();
			while(en.hasMoreElements()) {
				Driver dr = (Driver) en.nextElement();
				DriverManager.registerDriver(dr);
			}*/
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		/* catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	public String getEmpleados() throws SQLException {
		String res = "";
		//Paso 4: Establecer la conexión
		//Método 1:
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
		
		//Método 2:
		Connection con2 = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay");
		
		//Paso 5: Craar el statement
		//Forma 1:
		Statement st = con.createStatement(); //PAra cualquier tipo de sentencia SQL
		//Forma 2:
		PreparedStatement pst = con.prepareStatement("SELECT * FROM empleado;");
		//Forma 3:
		CallableStatement cst = con.prepareCall("unProc");
		
		
		//Paso 6: Ejecutar las consultas
		st.execute("SELECT nombre, apellido FROM empleado WHERE apellido == 'Roca';");//multiples
		st.executeUpdate("INSERT INTO empleado VALUES (4, 'Saul','Mora')");//para modificar datos
		st.executeQuery("SELECT * FROM empleado;");//Un solo conjunto de datos
		
		pst.execute();
		pst.executeUpdate();
		pst.executeQuery();
		
		//Paso 7: Procesar el resultado/respuesta
		ResultSet conjunto = st.executeQuery("SELECT * FROM empleado;");
		while(conjunto.next()) {
			//Hacer lo que se quiera con cada registro
			res += conjunto.getString("nombre") + "\n";
		}
		
		//Paso 8: Cerrar conexión
		con.close();
		st.close(); pst.close(); cst.close();
		conjunto.close();
		
		return res;
	}
	
	public String insertarEmpleado(int id, String nombre, String apellido) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
		PreparedStatement pst = con.prepareStatement("INSERT INTO empleado VALUES (?,?,?)");//para modificar datos
		pst.setInt(1, id);
		pst.setString(3,apellido);
		pst.setString(2, nombre);
		int i = pst.executeUpdate();
		con.close();
		pst.close();
		return "ok";
	}
}
