package Recursos;

public class Cliente {
	
	private int id;
	
	private String nCompleto;
	
	private String nCuenta;


	public Cliente(int id, String nCompleto, String nCuenta) {
		this.id = id;
		this.nCompleto = nCompleto;
		this.nCuenta = nCuenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getnCompleto() {
		return nCompleto;
	}

	public void setnCompleto(String nCompleto) {
		this.nCompleto = nCompleto;
	}

	public String getnCuenta() {
		return nCuenta;
	}

	public void setnCuenta(String nCuenta) {
		this.nCuenta = nCuenta;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + id +
				", nCompleto='" + nCompleto + '\'' +
				", nCuenta='" + nCuenta + '\'' +
				'}';
	}
}
