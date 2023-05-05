package entidades;

import java.util.Date;
import java.util.List;
import entidades.DetalleAsiento;

public class Asiento {
	private int codigoasic;
	private String numeroasic;
	private Date fechaasic;
	private String descripasic;
	private String observasic;
	private int codigoesta;
	private int codigocomp;
	private int codigouarc;
	private int codigousua;
	private List<DetalleAsiento> detalles;
	
	
	
	public Asiento() {
		super();
	}

	public Asiento(int codigoasic, String numeroasic, Date fechaasic, String descripasic, String observasic,
			int codigoesta, int codigocomp, int codigouarc, int codigousua) {
		super();
		this.codigoasic = codigoasic;
		this.numeroasic = numeroasic;
		this.fechaasic = fechaasic;
		this.descripasic = descripasic;
		this.observasic = observasic;
		this.codigoesta = codigoesta;
		this.codigocomp = codigocomp;
		this.codigouarc = codigouarc;
		this.codigousua = codigousua;
	}
	
	public int getCodigoasic() {
		return codigoasic;
	}
	public void setCodigoasic(int codigoasic) {
		this.codigoasic = codigoasic;
	}
	public String getNumeroasic() {
		return numeroasic;
	}
	public void setNumeroasic(String numeroasic) {
		this.numeroasic = numeroasic;
	}
	public Date getFechaasic() {
		return fechaasic;
	}
	public void setFechaasic(Date fechaasic) {
		this.fechaasic = fechaasic;
	}
	public String getDescripasic() {
		return descripasic;
	}
	public void setDescripasic(String descripasic) {
		this.descripasic = descripasic;
	}
	public String getObservasic() {
		return observasic;
	}
	public void setObservasic(String observasic) {
		this.observasic = observasic;
	}
	public int getCodigoesta() {
		return codigoesta;
	}
	public void setCodigoesta(int codigoesta) {
		this.codigoesta = codigoesta;
	}
	public int getCodigocomp() {
		return codigocomp;
	}
	public void setCodigocomp(int codigocomp) {
		this.codigocomp = codigocomp;
	}
	public int getCodigouarc() {
		return codigouarc;
	}
	public void setCodigouarc(int codigouarc) {
		this.codigouarc = codigouarc;
	}
	public int getCodigousua() {
		return codigousua;
	}
	public void setCodigousua(int codigousua) {
		this.codigousua = codigousua;
	}
	
	public List<DetalleAsiento> getDetalle() {
	    return this.detalles;
	}


}
