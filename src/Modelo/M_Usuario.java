package Modelo;

public class M_Usuario {
	private String nombre_usuario;
	private String contraseña;
	
	
	public M_Usuario() {
		
	}
	
	public M_Usuario(String nombre_usuario, String contraseña) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}

