package Interfaz;

import Logica.L_auto;
import Logica.L_clientes;
import Modelo.M_Clientes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class I_registroAutoController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblAño;

    @FXML
    private Label lblCorreoCliente;

    @FXML
    private Label lblGarantia;

    @FXML
    private Label lblHistorial;

    @FXML
    private Label lblMarca;

    @FXML
    private Label lblModelo;

    @FXML
    private Label lblNombreCliente;

    @FXML
    private Label lblNroPlaca;

    @FXML
    private Label lblTelefonoCliente;

    @FXML
    private Label lblcolor;

    @FXML
    private TextField txtAño;

    @FXML
    private TextField txtColor;

    @FXML
    private TextField txtGarantia;

    @FXML
    private TextField txtHistorial;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;    

    @FXML
    private TextField txtNroPlaca;
    
    @FXML
    private Button btnBuscarCliente;

    @FXML
    private TextField txtNroDocCliente;
    
    private M_Clientes clienteEncontrado;
    
    @FXML
    void btnCancelar(ActionEvent event) {
    	salir(event);
    }
    
    @FXML
    void initialize() {
    	StringConverter<Integer> converter = new IntegerStringConverter();

        // filtro para permitir solo dígitos
        TextFormatter<Integer> textFormatter = new TextFormatter<>(converter, null, change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            } else {
                return null;
            }
        });

        txtNroDocCliente.setTextFormatter(textFormatter);
    }
    

    @FXML
    void btnGuardar(ActionEvent event) {
    	L_auto.registrarAuto(clienteEncontrado, txtNroPlaca, txtMarca, txtModelo, txtAño, txtColor, txtGarantia, txtHistorial, txtNroDocCliente);
    	
    }

    @FXML
    void btnLimpiar(ActionEvent event) {
    	txtNroPlaca.setText("");
    	txtModelo.setText("");
    	txtMarca.setText("");
    	txtHistorial.setText("");
    	txtGarantia.setText("");
    	txtColor.setText("");
    	txtAño.setText("");
    }
    
    @FXML
    void btnBuscarCliente(ActionEvent event){
    	String nroDocumento = txtNroDocCliente.getText();
    	clienteEncontrado = L_clientes.buscarCliente(nroDocumento);
    	
    	if (clienteEncontrado != null) {
    		lblNombreCliente.setText(clienteEncontrado.getNombre());
    		lblCorreoCliente.setText(clienteEncontrado.getCorreo());
    		lblTelefonoCliente.setText(clienteEncontrado.getTelefono());
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Respuesta");
    		alert.setHeaderText(null);
    		alert.setContentText("Cliente encontrado");

    		alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setHeaderText("Error al encontrar Usuario");
			alert.showAndWait();
		}
    	
    }
    
    public void salir(ActionEvent e) {
		Node source = (Node) e.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}
	

}
