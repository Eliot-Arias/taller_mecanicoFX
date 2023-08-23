package Logica;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.D_conexion;
import Modelo.M_Clientes;
import javafx.scene.control.TextField;

public class L_clientes {
	private static M_Clientes cliente = new M_Clientes();
	
	
	public static void registrarCliente(TextField nombre, TextField tipo_documento, TextField nro_documento, TextField correo, TextField telefono) {
		cliente.setNombre(nombre.getText());
		cliente.setTipo_documento(tipo_documento.getText());
		cliente.setNro_documento(nro_documento.getText());
		cliente.setCorreo(correo.getText());
		cliente.setTelefono(tipo_documento.getText());
		
		D_conexion cn = new D_conexion();
		
		String consulta = "CALL registrar_cliente(?, ?, ?, ?, ?);";
		try {
			CallableStatement stmt = cn.conectar().prepareCall(consulta);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getTipo_documento());
			stmt.setString(3, cliente.getNro_documento());
			stmt.setString(4, cliente.getCorreo());
			stmt.setString(5, cliente.getTelefono());
			ResultSet resultado = stmt.executeQuery();
			//System.out.println(resultado.getString("nombre_usuario"));
			if (resultado.next()) {
				System.out.println("Resultado: " + resultado.getString("contraseña"));				
			}else {
				System.out.println("Contraseña Erronea");
			}
			
			stmt.close();
            			
		} catch (SQLException e) {
			System.out.println("Error: " + e.toString());
		}
		
		
		
	}
	
	
}
