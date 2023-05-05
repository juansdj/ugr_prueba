package entidades;

public class DetalleAsiento {

	private int codigoasid;
	private double valorasid;
	private String descripasid;
	private int codigoasic;
	private int codigoctac;
	private int codigoapli;
	
	
	
	public DetalleAsiento() {
		super();
	}
	public DetalleAsiento(int codigoasid, double valorasid, String descripasid, int codigoasic, int codigoctac,
			int codigoapli) {
		super();
		this.codigoasid = codigoasid;
		this.valorasid = valorasid;
		this.descripasid = descripasid;
		this.codigoasic = codigoasic;
		this.codigoctac = codigoctac;
		this.codigoapli = codigoapli;
	}
	public int getCodigoasid() {
		return codigoasid;
	}
	public void setCodigoasid(int codigoasid) {
		this.codigoasid = codigoasid;
	}
	public double getValorasid() {
		return valorasid;
	}
	public void setValorasid(double valorasid) {
		this.valorasid = valorasid;
	}
	public String getDescripasid() {
		return descripasid;
	}
	public void setDescripasid(String descripasid) {
		this.descripasid = descripasid;
	}
	public int getCodigoasic() {
		return codigoasic;
	}
	public void setCodigoasic(int codigoasic) {
		this.codigoasic = codigoasic;
	}
	public int getCodigoctac() {
		return codigoctac;
	}
	public void setCodigoctac(int codigoctac) {
		this.codigoctac = codigoctac;
	}
	public int getCodigoapli() {
		return codigoapli;
	}
	public void setCodigoapli(int codigoapli) {
		this.codigoapli = codigoapli;
	}
	
	
	
}
