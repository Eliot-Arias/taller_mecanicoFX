package Modelo;

public class M_Comprobante {
	private int id_comprobante;
	private int id_usuario;
	private String nro_ticket;
	private String tipo_documento;
	private String nro_documento;
	
	public M_Comprobante() {
		
	}

	public M_Comprobante(int id_comprobante, int id_usuario, String nro_ticket, String tipo_documento,
			String nro_documento) {
		super();
		this.id_comprobante = id_comprobante;
		this.id_usuario = id_usuario;
		this.nro_ticket = nro_ticket;
		this.tipo_documento = tipo_documento;
		this.nro_documento = nro_documento;
	}

	public int getId_comprobante() {
		return id_comprobante;
	}

	public void setId_comprobante(int id_comprobante) {
		this.id_comprobante = id_comprobante;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNro_ticket() {
		return nro_ticket;
	}

	public void setNro_ticket(String nro_ticket) {
		this.nro_ticket = nro_ticket;
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
	
	
}
