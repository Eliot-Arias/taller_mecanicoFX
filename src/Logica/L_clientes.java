package Logica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Datos.D_conexion;
import Modelo.M_Clientes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

public class L_clientes {
	private static M_Clientes cliente = new M_Clientes();
	
	
	public static void registrarCliente(TextField nombre, ComboBox<String> tipo_documento, TextField nro_documento, TextField correo, TextField telefono) {
		cliente.setNombre(nombre.getText());
		cliente.setTipo_documento((String) tipo_documento.getValue());
		cliente.setNro_documento(nro_documento.getText());
		cliente.setCorreo(correo.getText());
		cliente.setTelefono(telefono.getText());
		
		
		System.out.println(cliente.getNombre());
		System.out.println(cliente.getTipo_documento());
		System.out.println(cliente.getNro_documento());
		System.out.println(cliente.getCorreo());
		System.out.println(cliente.getTelefono());
		
		D_conexion cn = new D_conexion();
		
		String consulta = "CALL registrar_cliente(?, ?, ?, ?, ?);";
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getTipo_documento());
			stmt.setString(3, cliente.getNro_documento());
			stmt.setString(4, cliente.getCorreo());
			stmt.setString(5, cliente.getTelefono());
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
	
	public static void actualizarCliente(TextField  id_cliente,TextField nombre, ComboBox<String> tipo_documento, TextField nro_documento, TextField correo, TextField telefono) {
		cliente.setId_cliente(Integer.parseInt(id_cliente.getText()));
		cliente.setNombre(nombre.getText());
		cliente.setTipo_documento((String) tipo_documento.getValue());
		cliente.setNro_documento(nro_documento.getText());
		cliente.setCorreo(correo.getText());
		cliente.setTelefono(telefono.getText());		
		
		System.out.println(cliente.getId_cliente());
		System.out.println(cliente.getNombre());
		System.out.println(cliente.getTipo_documento());
		System.out.println(cliente.getNro_documento());
		System.out.println(cliente.getCorreo());
		System.out.println(cliente.getTelefono());
		
		D_conexion cn = new D_conexion();
		
		String consulta = "CALL editar_cliente(?, ?, ?, ?, ?, ?);";
		
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			stmt.setInt(1, cliente.getId_cliente());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getTipo_documento());
			stmt.setString(4, cliente.getNro_documento());
			stmt.setString(5, cliente.getCorreo());
			stmt.setString(6, cliente.getTelefono());
			stmt.execute();
			
			
			stmt.close();
            			
		} catch (SQLException e) {
			if (e.getSQLState().equals("46000")) {
				
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
	
	
	public static M_Clientes buscarCliente(String nroDocumento) {
		D_conexion cn = new D_conexion();
		String consulta = "CALL consultar_cliente(?)";
		//String consulta = "SELECT * FROM clientes WHERE nro_documento = ?";
		
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			stmt.setString(1, nroDocumento);
			ResultSet resultado = stmt.executeQuery();
			if (resultado.next()) {
				M_Clientes clienteEncontrado = new M_Clientes();
				clienteEncontrado.setNombre(resultado.getString("nombre_o_razon_social"));
				clienteEncontrado.setCorreo(resultado.getString("correo"));
				clienteEncontrado.setTelefono(resultado.getString("telefono"));
				clienteEncontrado.setNro_documento(resultado.getString("nro_documento"));
				clienteEncontrado.setId_cliente(resultado.getInt("id_cliente"));
				
				return clienteEncontrado;
			}
			
			stmt.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		
		return null;	

	}
	
	public static ObservableList<M_Clientes> listClientes() {
		D_conexion cn = new D_conexion();
		ObservableList<M_Clientes> clientes = FXCollections.observableArrayList();
		
		
		String consulta = "SELECT * FROM clientes";
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			ResultSet resultado = stmt.executeQuery();	
			
			while(resultado.next()) {
				M_Clientes cliente = new M_Clientes();
				cliente.setId_cliente(resultado.getInt(1));
				cliente.setNombre(resultado.getString(2));
				cliente.setTipo_documento(resultado.getString(3));
				cliente.setNro_documento(resultado.getString(4));
				cliente.setCorreo(resultado.getString(5));
				cliente.setTelefono(resultado.getString(6));
				
				clientes.add(cliente);
				
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
		
		return clientes;
	}
	
}
