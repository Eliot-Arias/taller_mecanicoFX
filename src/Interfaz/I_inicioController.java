package Interfaz;


import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class I_inicioController {
	private Stage stage = new Stage();
	private Main mn = new Main();
	
    @FXML
    private MenuItem registroAuto;
    @FXML
    private MenuItem registroCliente;

    @FXML
    void btnRegistrarAuto(ActionEvent event) throws Exception {
    	System.err.println("Auto");    	
    	mn.load(stage, "registroAuto", "Registro de Auto");    }

    @FXML
    void btnRegistrarClientes(ActionEvent event) throws Exception {
    	mn.load(stage, "registroClientes", "Registro de Clientes");
    }
        
}
