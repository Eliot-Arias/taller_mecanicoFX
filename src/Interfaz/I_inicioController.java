package Interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
