package Logica;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import Datos.D_conexion;
import Modelo.M_Clientes;
import Modelo.M_automovil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

public class L_auto {
	private static M_automovil auto = new M_automovil();
	static D_conexion cn = new D_conexion();
	
	public static void registrarAuto(M_Clientes cliente ,TextField txtNroPlaca, TextField txtMarca, TextField txtModelo, TextField txtAño, TextField txtColor, TextField txtGarantia,TextField txtHistorial){
		if (cliente == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Falta los datos del cliente");
			alert.showAndWait();
		}else {
			auto.setId_cliente(cliente.getId_cliente());
			auto.setNro_placa(txtNroPlaca.getText());
			auto.setMarca(txtMarca.getText());
			auto.setModelo(txtModelo.getText());
			auto.setAño(txtAño.getText());
			auto.setColor(txtColor.getText());
			
			
			
			String consulta = "CALL guardarAuto(?, ?, ?, ?, ?, ?, NULL, NULL);";
			try {
				CallableStatement stmt = cn.conectar().prepareCall(consulta);
				stmt.setInt(1, auto.getId_cliente());
				stmt.setString(2, auto.getNro_placa());
				stmt.setString(3, auto.getMarca());
				stmt.setString(4, auto.getModelo());
				stmt.setString(5, auto.getAño());
				stmt.setString(6, auto.getColor());
				stmt.execute();
				//System.out.println(resultado.getString("nombre_usuario"));
				
				
				stmt.close();
	            			
			} catch (SQLException e) {
				if (e.getSQLState().equals("45000")) {
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("AVISO");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
					
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Error al registrar Cliente");
					alert.showAndWait();
				}
			}
		}
		
	}
	
	
	public static void actualizarAuto(TextField idAuto, TextField txtNroPlaca, TextField txtMarca, TextField txtModelo, TextField txtAño, TextField txtColor, TextField txtGarantia,TextField txtHistorial) {
		String idAutomovil = idAuto.getText();
		String placa = txtNroPlaca.getText();
		String marca = txtMarca.getText();
		String modelo = txtModelo.getText();
		String año = txtAño.getText();
		String color = txtColor.getText();
		
		if (placa.isEmpty() || año.isEmpty() || marca.isEmpty() || color.isEmpty() || modelo.isEmpty()) {			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No puede haber ningun espacio en blanco");
			alert.showAndWait();
			
		}else{
			auto.setId_automovil(Integer.parseInt(idAutomovil));
			auto.setNro_placa(placa);
			auto.setMarca(marca);
			auto.setModelo(modelo);
			auto.setAño(año);
			auto.setColor(color);
			
			String consulta = "CALL actualiza_auto(?, ?, ?, ?, ?, ?, null, null)";
			try {
				CallableStatement stmt = cn.conectar().prepareCall(consulta);
				stmt.setInt(1, auto.getId_automovil());
				stmt.setString(2, auto.getNro_placa());
				stmt.setString(3, auto.getMarca());
				stmt.setString(4, auto.getModelo());
				stmt.setString(5, auto.getAño());
				stmt.setString(6, auto.getColor());
				stmt.execute();
			} catch (SQLException e) {
				if (e.getSQLState().equals("10000")) { 
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("AVISO");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}else if(e.getSQLState().equals("45000")) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("ERROR");
					alert.setContentText(e.getMessage());
					alert.showAndWait();
				}
				
			}
			
			
		}
		
	}
	
	public static void eliminarAuto(TextField idAutomovil) {		
		
		String id = idAutomovil.getText();
		
		if (id.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se envio el ID de Auto");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Eliminando Clientes");
			alert.setHeaderText("¿Esta seguro que desea eliminar el registro?");
			alert.setContentText("Elija una opcion: ");

			ButtonType buttonTypeOne = new ButtonType("Eliminar");
			ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
			Optional<ButtonType> result = alert.showAndWait();
			System.out.println("Anny con id del Auto: " + id);
			
			if (result.get() == buttonTypeOne){
			    System.out.println("Aparecera Anny si acepta");
			    
				String consulta = "CALL eliminar_auto(?)";
			    auto.setId_automovil(Integer.parseInt(id));
				System.out.println(auto.getId_automovil());
				try {
					CallableStatement stmt = cn.conectar().prepareCall(consulta);
					stmt.setInt(1, auto.getId_automovil());
					
					stmt.execute();
					
					stmt.close();
		            			
				} catch (SQLException e) {
					if (e.getSQLState().equals("45000")) {
						
						Alert alert1 = new Alert(AlertType.INFORMATION);
						alert1.setTitle("AVISO");
						alert1.setContentText(e.getMessage());
						alert1.showAndWait();
						
					}else {
						Alert alert2 = new Alert(AlertType.ERROR);
						alert2.setTitle("Error");
						alert2.setHeaderText(e.getMessage());
						alert2.showAndWait();
					}
				}
				
				
			} else {
			    System.out.println("Anny cancelando la accion");
			}
			
		}
		
		
		
	}
	
	
	public static ObservableList<M_automovil> listAuto() {
		D_conexion cn = new D_conexion();
		ObservableList<M_automovil> autos = FXCollections.observableArrayList();
		
		
		String consulta = "CALL mostrar_auto();";
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			ResultSet resultado = stmt.executeQuery();	
			
			while(resultado.next()) {
				M_automovil auto = new M_automovil();
				M_Clientes cliente = new M_Clientes();
				auto.setId_automovil(resultado.getInt(1));
				auto.setMarca(resultado.getString(2));
				auto.setAño(resultado.getString(3));
				auto.setColor(resultado.getString(4));
				auto.setModelo(resultado.getString(5));
				auto.setNro_placa(resultado.getString(6));
				auto.setCliente(resultado.getString(7));
				auto.setId_cliente(resultado.getInt(8));
				
				autos.add(auto);				
				
			}
			
			stmt.close();
            			
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		
		return autos;
	}
	
	public static TableView<M_automovil> llenarTablaAutos(TableColumn<M_automovil, String> colIdAuto, TableColumn<M_automovil, String>colMarcaAuto
			, TableColumn<M_automovil, String> colAño, TableColumn<M_automovil, String> colColor, TableColumn<M_automovil, String> colModelo
			, TableColumn<M_automovil, String> colPlaca, TableColumn<M_automovil, String> colCLiente, TableView<M_automovil> tableAutos
			, ObservableList<M_automovil> autosList) {
    	colIdAuto.setCellValueFactory(new PropertyValueFactory<>("id_automovil"));
    	colMarcaAuto.setCellValueFactory(new PropertyValueFactory<>("marca"));
    	colAño.setCellValueFactory(new PropertyValueFactory<>("año"));
    	colColor.setCellValueFactory(new PropertyValueFactory<>("color"));
    	colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
    	colPlaca.setCellValueFactory(new PropertyValueFactory<>("nro_placa"));
    	colCLiente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
    	
    	autosList = L_auto.listAuto();
    	tableAutos.setItems(autosList);
    	return tableAutos;
    }
	
	
	
	
}

