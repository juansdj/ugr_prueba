package otramas;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;

import entidades.Asiento;
import entidades.DetalleAsiento;

@ManagedBean(name = "detalleController")
@ViewScoped
public class DetalleController implements Serializable {

    private List<DetalleAsiento> listDetalle;
    private DetalleAsiento nuevoDetalleAsiento = new DetalleAsiento();

    public List<DetalleAsiento> listarDetalles(int id) {
        String sql = "SELECT * FROM conasientod WHERE codigoasic = ?";
        List<DetalleAsiento> listDetalle = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                DetalleAsiento data = new DetalleAsiento();
                data.setCodigoasid(rs.getInt("codigoasid"));
                data.setValorasid(rs.getDouble("valorasid"));
                data.setDescripasid(rs.getString("descripasid"));
                data.setCodigoasic(rs.getInt("codigoasic"));
                data.setCodigoctac(rs.getInt("codigoctac"));
                data.setCodigoapli(rs.getInt("codigoapli"));
                listDetalle.add(data);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDetalle;
    }

    public List<DetalleAsiento> getListDetalle() {
        return listDetalle;
    }

    public void setListDetalle(int id) {
        this.listDetalle = listarDetalles(id);
    }

	public DetalleAsiento getNuevoDetalleAsiento() {
		return nuevoDetalleAsiento;
	}

	public void setNuevoDetalleAsiento(DetalleAsiento nuevoDetalleAsiento) {
		this.nuevoDetalleAsiento = nuevoDetalleAsiento;
	}
    
    
    public void guardarNuevoDetalle(int id) {
        System.out.println("Crear detalle: "+id);
        try (Connection conn = DBUtil.getConnection()) {
            String query = "INSERT INTO conasientod (valorasid, descripasid, codigoasic, codigoctac, codigoapli) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, nuevoDetalleAsiento.getValorasid());
            pstmt.setString(2, nuevoDetalleAsiento.getDescripasid());
            pstmt.setInt(3, id);
            pstmt.setInt(4, nuevoDetalleAsiento.getCodigoctac());
            pstmt.setInt(5, nuevoDetalleAsiento.getCodigoapli());

            pstmt.executeUpdate();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Detalle creado correctamente"));
            PrimeFaces.current().executeScript("PF('modalAgregarDetalle').hide()");
            nuevoDetalleAsiento = new DetalleAsiento(); // Reiniciar objeto para permitir agregar otro detalle
            setListDetalle(id);
        } catch (SQLException e) {
            e.printStackTrace();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear el detalle", "Error al crear el detalle"));
        }
    }
}
