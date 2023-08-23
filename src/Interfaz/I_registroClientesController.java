package Interfaz;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class I_registroClientesController {
	
	ObservableList<String> tipoDoc = FXCollections.observableArrayList("DNI - Documento Nacional de Identidad", "CE - Carnet de Extrangería", "Pasaporte", "Documento de Identidad Extrangero", "RUC - Registro Unico de Contribuyente");
		
	@FXML
	private Label lblNombreCliente;
	@FXML
	private Label lblTipoDoc;
	@FXML
	private Label lblNroDoc;
	@FXML
	private Label lblCorreo;
	@FXML
	private Label lblTelefono;
	@FXML
	private TextField txtNombreCliente;
	@FXML
	private TextField txtNroDoc;
	@FXML
	private TextField txtCorreo;
	@FXML
	private TextField txtTelefono;
	@FXML
	private ComboBox<String> cmbxTipoDoc;
	@FXML
	private Button btnRegistrarCliente;
	@FXML
	private Button btnLimpiarFormulario;
	@FXML
	private Button btnSalir;

	@FXML
	private void initialize() {
		cmbxTipoDoc.setValue("DNI - Documento Nacional de Identidad");
		cmbxTipoDoc.setItems(tipoDoc);
	}
	// Event Listener on Button[#btnRegistrarCliente].onAction
	@FXML
	public void btnRegistrarCliente(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnLimpiarFormulario].onAction
	@FXML
	public void btnLimpiarFormulario(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#btnSalir].onAction
	@FXML
	public void btnSalir(ActionEvent event) {
		// TODO Autogenerated
	}
	
	
	
	
}
