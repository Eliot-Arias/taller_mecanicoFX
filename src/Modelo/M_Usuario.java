package Modelo;

public class M_Usuario {
	private int id_usuario;
	private int id_empleado;
	private String nombre_usuario;
	private String contraseña;
	
	
	public M_Usuario() {
		
	}
	

	
	public M_Usuario(int id_usuario, int id_empleado, String nombre_usuario, String contraseña) {
		this.id_usuario = id_usuario;
		this.id_empleado = id_empleado;
		this.nombre_usuario = nombre_usuario;
		this.contraseña = contraseña;
	}



	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
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

