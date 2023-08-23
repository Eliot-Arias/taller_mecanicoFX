package Interfaz;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Logica.L_usuario;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;

public class I_loginController {
	@FXML
	private TextField txtNombreUsuario;
	@FXML
	private PasswordField pwdContraseña;

	// Event Listener on Button.onAction
	@FXML
	public void btnIngresar(ActionEvent event) {
		// TODO Autogenerated
		L_usuario.ingresar(txtNombreUsuario, pwdContraseña);
	}
	// Event Listener on Button.onAction
	@FXML
	public void btnSalir(ActionEvent event) {
		// TODO Autogenerated
		salir(event);
	}
	
	public static void salir(ActionEvent e) {
		Node source = (Node) e.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}
}
