package entidades;

public class Menu {
	private int codigoMenu;
	private String nombreMenu;
	private int codigoEsta;

	public Menu() {

	}

	public Menu(int codigoMenu, String nombreMenu, int codigoEsta) {
		super();
		this.codigoMenu = codigoMenu;
		this.nombreMenu = nombreMenu;
		this.codigoEsta = codigoEsta;
	}

	public int getCodigoMenu() {
		return codigoMenu;
	}

	public void setCodigoMenu(int codigoMenu) {
		this.codigoMenu = codigoMenu;
	}

	public String getNombreMenu() {
		return nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public int getCodigoEsta() {
		return codigoEsta;
	}

	public void setCodigoEsta(int codigoEsta) {
		this.codigoEsta = codigoEsta;
	}

}
