package Logica;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.D_conexion;
import Modelo.M_Clientes;
import Modelo.M_automovil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class L_auto {
	private static M_automovil auto = new M_automovil();
	
	public static void registrarAuto(M_Clientes cliente ,TextField txtNroPlaca, TextField txtMarca, TextField txtModelo, TextField txtAño, TextField txtColor, TextField txtGarantia,TextField txtHistorial, TextField txtCliente){
		auto.setId_cliente(cliente.getId_cliente());
		auto.setNro_placa(txtNroPlaca.getText());
		auto.setMarca(txtMarca.getText());
		auto.setModelo(txtModelo.getText());
		auto.setAño(txtAño.getText());
		auto.setColor(txtColor.getText());
		auto.setId_garantia(Integer.parseInt(txtGarantia.getText()));
		
		D_conexion cn = new D_conexion();
		
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
				
				System.out.println(resultado.getInt(1));
				System.out.println(resultado.getString(2));
				System.out.println(resultado.getString(3));
				System.out.println(resultado.getString(4));
				System.out.println(resultado.getString(5));
				
			}
			
			stmt.close();
            			
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		
		return autos;
	}
	
	
	
}

