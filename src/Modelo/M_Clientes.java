package Modelo;

public class M_Clientes {
	private int id_cliente;
	private String nombre;
	private String tipo_documento;
	private String nro_documento;
	private String correo;
	private String telefono;
	
	public M_Clientes() {
		
	}

	public M_Clientes(int id_cliente, String nombre, String tipo_documento, String nro_documento, String correo,
			String telefono) {
		super();
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.tipo_documento = tipo_documento;
		this.nro_documento = nro_documento;
		this.correo = correo;
		this.telefono = telefono;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
