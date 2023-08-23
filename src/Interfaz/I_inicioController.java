package Interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class I_inicioController {

    @FXML
    private MenuItem registroAuto;
    @FXML
    private MenuItem registroCliente;

    @FXML
    void btnRegistrarAuto(ActionEvent event) {
    	System.err.println("Auto");
    }

    @FXML
    void btnRegistrarClientes(ActionEvent event) {
    	System.err.println("Clietjnes");
    }
}
