package Interfaz;


import Modelo.M_Clientes;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class I_inicioController {
	private Stage stage = new Stage();
	private Main mn = new Main();
	

    @FXML
    private TableColumn<M_Clientes, String> colCorreo;

    @FXML
    private TableColumn<M_Clientes, String> colNombreCliente;

    @FXML
    private TableColumn<M_Clientes, String> colNroDoc;

    @FXML
    private TableColumn<M_Clientes, String> colTelefono;

    @FXML
    private TableColumn<M_Clientes, String> colTipoDoc;
	
	
    @FXML
    private MenuItem registroAuto;
    @FXML
    private MenuItem registroCliente;

    @FXML
    private TableView<M_Clientes> tableClientes;
    
    private ObservableList<M_Clientes> clientesList = FXCollections.observableArrayList();
    
    @FXML
    void btnRegistrarAuto(ActionEvent event) throws Exception {
    	System.out.println("Auto");    	
    	mn.load(stage, "registroAuto", "Registro de Auto");    
    }

    @FXML
    void btnRegistrarClientes(ActionEvent event) throws Exception {
    	mn.load(stage, "registroClientes", "Registro de Clientes");
    }
    
    @FXML
    public void initialize() {
    }
    
    public void llenarTabla() {
    	colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colTipoDoc.setCellValueFactory(new PropertyValueFactory<>("tipo_documento"));
    	colNroDoc.setCellValueFactory(new PropertyValueFactory<>("nro_documento"));
    	colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
    	colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    }
    
}
