//	package otramas;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.faces.context.FacesContext;
//import javax.inject.Named;
//
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import entidades.Menu;
//
//
//
//@ManagedBean
//@SessionScoped
//@Named("miControlador")
//public class LoginControllerDos implements Serializable{
//	private String username;
//    private String password;
//    private List<Menu> listMenu;
//    
//
//    public void login() {
//    	try {
//			Connection conn = DBUtil.getConnection();
//			System.out.println("conexion establecida: "+conn);
//		} catch (SQLException e) {
//			System.out.println("conexion fallida: "+e);
//
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println("saludos desde login");
////    	return "holA MUNDO";
////        if ("admin".equals(username) && "password".equals(password)) {
////            return "welcome.xhtml";
////        } else {
////            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Login!", ""));
////            return null;
////        }
//    }
//    public List<Menu> getMenu() {
//    	System.out.println("Menu: ");
//         listMenu = new ArrayList<>();
//        try (Connection conn = DBUtil.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM sismenu")) {
//            while (rs.next()) {
//                Menu menu = new Menu();
//                menu.setCodigoMenu(rs.getInt("codigomenu"));
//                menu.setNombreMenu(rs.getString("nombremenu"));
//                menu.setCodigoEsta(rs.getInt("codigoesta"));
//                listMenu.add(menu);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return listMenu;
//    }
//
//}
