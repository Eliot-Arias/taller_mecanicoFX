package Logica;

import Modelo.M_automovil;
import javafx.scene.control.TextField;

public class L_auto {
	private static M_automovil auto = new M_automovil();
	
	private static void registrarAuto(TextField txtNroPlaca, TextField txtMarca, TextField txtModelo, TextField txtAño, TextField txtColor, TextField txtGarantia,TextField txtHistorial, TextField txtCliente){
		auto.setNro_placa(txtNroPlaca.getText());
		auto.setMarca(txtMarca.getText());
		auto.setModelo(txtModelo.getText());
		auto.setAño(txtAño.getText());
		auto.setColor(txtColor.getText());
		auto.setId_garantia(Integer.parseInt(txtGarantia.getText()));
		auto.setId_historial(Integer.parseInt(txtHistorial.getText()));
		auto.setId_cliente(Integer.parseInt(txtCliente.getText()));
		
		
	}
	
}

