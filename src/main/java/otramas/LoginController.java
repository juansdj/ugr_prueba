package otramas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import entidades.Asiento;
import entidades.DetalleAsiento;

@ManagedBean
@SessionScoped
public class LoginController {

    private String username;
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

    public String login2() {
    	System.out.println("en login");
//    	doLogin();
        if ("usuario".equals(username) && "contrasena".equals(password)) {
            return "index";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrectos", null));
            return null;
        }
    }
    
    public String login() {
        String sql = "SELECT * FROM sisusuario WHERE loginusua = ? AND claveusua = ? ";
        String result="";

        try (Connection conn = DBUtil.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	result= "index";
            } else {
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o contraseña incorrectos", null));
                result= null;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}

    // getters y setters para username y password
}
