package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class D_conexion {
Connection conectar = null;
	
	String usuario = "root";
	String contrasenia = "";
	String bd = "taller_mecanico";
	String ip = "127.0.0.1";
	String puerto = "3306";
	
	String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
			//JOptionPane.showMessageDialog(null, "Conexion exitosa");
			//System.out.println("Conexion exitosa");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la conexion" + e.getMessage());
			System.out.println(e.toString());
		}
		return conectar;
		
	}
}
