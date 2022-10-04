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
	
	public String getEmpleado(String apellido) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
		PreparedStatement pst = con.prepareStatement("SELECT * FROM empleado WHERE apellido = ?");//para consultar datos con parametro
		pst.setString(1, apellido);
		ResultSet rs = pst.executeQuery();
		String retorno = "";
		while(rs.next())
			retorno += rs.getInt(1) + " - " + rs.getString(2) + " " + rs.getString(3)+ "\n";
		con.close();
		pst.close();
		rs.close();
		return retorno;
	}
	
	public void actualizarEmpleado(int id, String nombre, String apellido) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
        String sql = "UPDATE empleado SET nombre = ? , "
                + "apellido = ?"
                + "WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, id);
            ps.executeUpdate();
       
    }
	
	public void borrarEmpleado(int id)  throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
        String sql = "DELETE FROM empleado WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
       
    }
	
	public void agregarVenta(int idP, String nomP, double precio)  throws SQLException {
        String sqlProducto = "INSERT INTO producto VALUES(?, ?, ?)";
        String sqlVenta = "INSERT INTO venta(id, idEmp, idProd, cantidad) VALUES(?,?,?,?)";
        ResultSet rs = null;
        PreparedStatement ps1 = null, ps2 = null;
        Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.1.253/empresay","postgres","123456");
        
            con.setAutoCommit(false);
            ps1 = con.prepareStatement(sqlProducto, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(1, idP);
            ps1.setString(2, nomP);
            ps1.setDouble(3, precio);
            int filasAfectadas = ps1.executeUpdate();
            rs = ps1.getGeneratedKeys();
            int productoId = 0;
            if (rs.next()) productoId = rs.getInt(1);
            if (filasAfectadas != 1) con.rollback();
            ps2 = con.prepareStatement(sqlVenta);
            ps2.setInt(1, 111);
            ps2.setInt(2,5);
            ps2.setInt(3, productoId);
            ps2.setInt(4, 3);
            ps2.executeUpdate();
            con.commit();
        
                if (rs != null) rs.close();
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
            
        
    }
	
}
