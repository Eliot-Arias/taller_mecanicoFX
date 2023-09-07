package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class D_conexion {
	
	private static Connection conectar = null;
	
	private static String usuario = "root";
	private static String contrasenia = "";
	private static String bd = "taller_mecanico";
	private static String ip = "127.0.0.1";
	private static String puerto = "3306";
	
	private static String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;
	
	public static Connection conectar() {
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
