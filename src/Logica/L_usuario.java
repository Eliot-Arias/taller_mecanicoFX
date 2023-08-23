package Logica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.D_conexion;
import Modelo.M_Usuario;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class L_usuario {
	
	private static M_Usuario user = new M_Usuario();
	
	public static void ingresar(TextField usuario, PasswordField contraseña){
		
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
			//System.out.println(resultado.getString("nombre_usuario"));
			if (resultado.next()) {
				System.out.println("Resultado: " + resultado.getString("contraseña"));
				
				
				
			}else {
				System.out.println("Contraseña Erronea");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Usuario o Contraseña Incorrectas");
				alert.showAndWait();
			}
			
			stmt.close();
            			
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		
		
	}
	
}
