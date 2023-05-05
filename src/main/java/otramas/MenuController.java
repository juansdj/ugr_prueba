package otramas;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import entidades.Menu;

@ManagedBean
@ViewScoped
public class MenuController implements Serializable{
	
	private List<Menu> listMenu;
//	@PostConstruct
//    public void init() {
//		listMenu = new ArrayList<Menu>();
//		try (Connection conn = DBUtil.getConnection();
//	             Statement stmt = conn.createStatement();
//	             ResultSet rs = stmt.executeQuery("SELECT * FROM sismenu")) {
//	            while (rs.next()) {
//	                Menu menu = new Menu();
//	                menu.setCodigoMenu(rs.getInt("codigomenu"));
//	                menu.setNombreMenu(rs.getString("nombremenu"));
//	                menu.setCodigoEsta(rs.getInt("codigoesta"));
//	                listMenu.add(menu);
//	            }
//	            rs.close();
//	            stmt.close();
//	            conn.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//		
//	}
	 public void listarMenu() {
	        listMenu = new ArrayList<>();
	        try (Connection conn = DBUtil.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM sismenu")) {
	            while (rs.next()) {
	                Menu menu = new Menu();
	                menu.setCodigoMenu(rs.getInt("codigomenu"));
	                menu.setNombreMenu(rs.getString("nombremenu"));
	                menu.setCodigoEsta(rs.getInt("codigoesta"));
	                listMenu.add(menu);
	            }
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	public List<Menu> getListMenu() {
        return listMenu;
    }
}
