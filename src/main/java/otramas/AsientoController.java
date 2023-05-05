package otramas;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;


import entidades.Asiento;

@ManagedBean
@ViewScoped
public class AsientoController implements Serializable {

	private List<Asiento> listAsientos;
    private Asiento selectedAsiento;
    private Asiento nuevoAsiento = new Asiento();

	@PostConstruct
	public void init() {
		listarAsientos();
	}

	public void listarAsientos() {
		System.out.println("listando asientos");
		listAsientos = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM conasientoc")) {
			while (rs.next()) {
				Asiento data = new Asiento();
				data.setCodigoasic(rs.getInt("codigoasic"));
				data.setNumeroasic(rs.getString("numeroasic"));
				data.setFechaasic(rs.getDate("fechaasic"));
				data.setDescripasic(rs.getString("descripasic"));
				data.setObservasic(rs.getString("observasic"));
				data.setCodigoesta(rs.getInt("codigoesta"));
				data.setCodigocomp(rs.getInt("codigocomp"));
				data.setCodigouarc(rs.getInt("codigouarc"));
				data.setCodigousua(rs.getInt("codigousua"));
				listAsientos.add(data);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void guardarNuevoAsiento() {
		System.out.println("Crear asiento");
	    try (Connection conn = DBUtil.getConnection()) {
	        String query = "INSERT INTO conasientoc (numeroasic, fechaasic, descripasic, observasic, codigoesta, codigocomp, codigouarc, codigousua) "
	                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, nuevoAsiento.getNumeroasic());
//	        pstmt.setDate(2, nuevoAsiento.getFechaasic());
	        pstmt.setDate(2, new java.sql.Date(nuevoAsiento.getFechaasic().getTime()));

//	        pstmt.setString(2, "2022-12-12");
//	        pstmt.setString(3, nuevoAsiento.getDescripasic());
//	        pstmt.setString(4, nuevoAsiento.getObservasic());
//	        pstmt.setInt(5, nuevoAsiento.getCodigoesta());
//	        pstmt.setInt(6, nuevoAsiento.getCodigocomp());
//	        pstmt.setInt(7, nuevoAsiento.getCodigouarc());
//	        pstmt.setInt(8, nuevoAsiento.getCodigousua());
	        pstmt.setString(3, "dess");
	        pstmt.setString(4, "obserrrr");
	        pstmt.setInt(5, 1);
	        pstmt.setInt(6, 1);
	        pstmt.setInt(7, 1);
	        pstmt.setInt(8, 1);
	        pstmt.executeUpdate();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Asiento creado correctamente"));
	        PrimeFaces.current().executeScript("PF('modalAgregar').hide()");

	        nuevoAsiento = new Asiento(); // Reiniciar objeto para permitir agregar otro asiento
	        listarAsientos();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear el asiento", "Error al crear el asiento"));
	    }
	}
	
	public void onRowSelect(SelectEvent event) {
		 Asiento asiento = (Asiento) event.getObject();
	        selectedAsiento = asiento;

	        // Obtener el bean de DetalleController
	        DetalleController detalleController = FacesContext.getCurrentInstance().getApplication().evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{detalleController}", DetalleController.class);

	        // Llamar al método setListDetalle() del bean de DetalleController
	        detalleController.setListDetalle(asiento.getCodigoasic());
    }

	public List<Asiento> getListAsientos() {
		return listAsientos;
	}

	public Asiento getSelectedAsiento() {
		return selectedAsiento;
	}

	public void setSelectedAsiento(Asiento selectedAsiento) {
		this.selectedAsiento = selectedAsiento;
	}
	public Asiento getNuevoAsiento() {
		return nuevoAsiento;
	}

	public void setNuevoAsiento(Asiento nuevoAsiento) {
		this.nuevoAsiento = nuevoAsiento;
	}
	
//	public DetalleController getDetalleController() {
//		return detalleController;
//	}
//
//	public void setDetalleController(DetalleController detalleController) {
//		this.detalleController = detalleController;
//	}
}
