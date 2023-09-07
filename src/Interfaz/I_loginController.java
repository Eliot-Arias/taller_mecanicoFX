package Interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


import Logica.L_usuario;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

public class I_loginController {
	@FXML
	private TextField txtNombreUsuario;
	@FXML
	private PasswordField pwdContraseña;

	// Event Listener on Button.onAction
	@FXML
	public void btnIngresar(ActionEvent event) throws Exception {
		if (L_usuario.ingresar(txtNombreUsuario, pwdContraseña)) {
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			L_usuario.cambiarPantalla(stage);
		}else {
			System.out.println("Contraseña Erronea");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Usuario o Contraseña Incorrectas");
			alert.showAndWait();
		}
	}
	
	
	// Event Listener on Button.onAction
	@FXML
	public void btnSalir(ActionEvent event) {
		salir(event);
	}
	
	public static void salir(ActionEvent e) {
		Node source = (Node) e.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}
	
	
}
