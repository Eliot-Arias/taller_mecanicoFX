package Modelo;

public class M_automovil {
	private int id_automovil;
	private int id_cliente;
	private String nro_placa;
	private String marca;
    private String modelo;
    private String año;
    private String color;
    private int id_garantia;
    private int id_historial;
    
    
    public M_automovil() {
    	
    }


	public M_automovil(int id_automovil, int id_cliente, String nro_placa, String marca, String modelo, String año,
			String color, int id_garantia, int id_historial) {
		super();
		this.id_automovil = id_automovil;
		this.id_cliente = id_cliente;
		this.nro_placa = nro_placa;
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.color = color;
		this.id_garantia = id_garantia;
		this.id_historial = id_historial;
	}


	public int getId_automovil() {
		return id_automovil;
	}


	public void setId_automovil(int id_automovil) {
		this.id_automovil = id_automovil;
	}


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNro_placa() {
		return nro_placa;
	}


	public void setNro_placa(String nro_placa) {
		this.nro_placa = nro_placa;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getAño() {
		return año;
	}


	public void setAño(String año) {
		this.año = año;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getId_garantia() {
		return id_garantia;
	}


	public void setId_garantia(int id_garantia) {
		this.id_garantia = id_garantia;
	}


	public int getId_historial() {
		return id_historial;
	}


	public void setId_historial(int id_historial) {
		this.id_historial = id_historial;
	}
    
    
    
}
