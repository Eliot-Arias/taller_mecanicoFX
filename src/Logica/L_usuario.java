package Logica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.D_conexion;
import Modelo.M_Usuario;
import application.Main;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class L_usuario {
	
	private static M_Usuario user = new M_Usuario();
	
	public static void cambiarPantalla(Stage stage) {
		try {
			Main ma = new Main();
			ma.load(stage, "inicio", "Inicio");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static boolean ingresar(TextField usuario, PasswordField contraseña) throws Exception{
		boolean autenticacion = false; 
		D_conexion cn = new D_conexion();
		user.setNombre_usuario(usuario.getText());
		user.setContraseña(contraseña.getText());	
		
		//String consulta = "CALL validar_usuario(?, ?);";
		String consulta = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?;";
		System.out.println(user.getContraseña());
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			stmt.setString(1, user.getNombre_usuario());
			stmt.setString(2, user.getContraseña());
			ResultSet resultado = stmt.executeQuery();			
			if (resultado.next()) {
				autenticacion = true;
			}else {				
				autenticacion = false;
			}
			
			stmt.close();
            			
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		return autenticacion;
		
	}
	
}
