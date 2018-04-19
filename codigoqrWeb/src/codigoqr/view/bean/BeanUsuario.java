package codigoqr.view.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import codigoqr.model.entities.Tblusuario;
import codigoqr.model.manager.ManagerQR;
import codigoqr.model.util.ModelUtil;
import codigoqr.view.bean.util.JSFUtil;

@SuppressWarnings("cdi-not-passivation-capable")
@SessionScoped
@ManagedBean
public class BeanUsuario {

	private String nombreUsuario;
	private String apellidoUsuario;
	private String correoUsuario;
	private String celularUsuario;
	private String claveUsuario;
	private Date fechaNacimientoUsuario;
	private String sexoUsuario;
	// login
	private String correoLogin;
	private String claveLogin;
	private boolean comprobado;
	private Tblusuario u;
	private String ip;
	private String hostname;
	private Integer idevento;
	@EJB
	ManagerQR managerQR;

	@PostConstruct
	public void iniciar() throws IOException {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		hostname = request.getHeader("X-FORWARDED-FOR");
		if (hostname == null) {
			hostname = request.getRemoteAddr();
		}
		URL whatismyip = new URL("http://checkip.amazonaws.com");		
		try (BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()))) {			
			ip = in.readLine();			
		} 
	}

	public void insertarUsuario(){
		claveUsuario = DigestUtils.sha1Hex(claveUsuario);
		managerQR.registrarUsuario(nombreUsuario, 1, apellidoUsuario, correoUsuario, celularUsuario, claveUsuario,
				fechaNacimientoUsuario, sexoUsuario);

	}

	public void insertarOperador(){
		claveUsuario = DigestUtils.sha1Hex(claveUsuario);		
		managerQR.registrarUsuario(nombreUsuario, 2, apellidoUsuario, correoUsuario, celularUsuario, claveUsuario,
				fechaNacimientoUsuario, sexoUsuario);
		managerQR.registrarOperador(idevento, correoUsuario);

	}

	// login

	public void actionLogin() {

		try {
			FacesContext contex = FacesContext.getCurrentInstance();
			u = managerQR.findUsuario(correoLogin);
			comprobado = managerQR.comprobarUsuario(correoLogin, DigestUtils.sha1Hex(claveLogin));
			if (u.getTblrolusuario().getRolUsuario().equals("Administrador")) {
				JSFUtil.crearMensajeInfo("Login correcto");
				managerQR.registrarBitacora("Login", "Ingresa", hostname, u.getIdUsuario(), ip, "");
				contex.getExternalContext().redirect("Crear/ListaEventos.xhtml");
			} else if (u.getTblrolusuario().getRolUsuario().equals("Operador")) {
				managerQR.registrarBitacora("Login", "Ingresa", hostname, u.getIdUsuario(), ip, "");
				contex.getExternalContext().redirect("Operador/ListaEventos.xhtml");
			}
		} catch (Exception e) {
			JSFUtil.crearMensajeError(e.getMessage());
		}

	}

	public String actionSalir() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		JSFUtil.crearMensajeError("Cédula Incorrecta");
		managerQR.registrarBitacora("Login", "Salir", hostname, u.getIdUsuario(), ip, "");
		return "/Login?faces-redirect=true";
	}

	public void actionComprobarLogin() throws IOException {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		String path = ec.getRequestPathInfo();
		String login="/faces/Login.xhtml";
		if (path.equals("/Login.xhtml"))
			return;
		if (ModelUtil.isEmpty(correoLogin))
			ec.redirect(ec.getRequestContextPath() + login);
		if (!comprobado) {
			ec.redirect(ec.getRequestContextPath() + login);
		} else {
			// si hizo login, verificamos que acceda a paginas permitidas:
			if (u.getTblrolusuario().getRolUsuario().equals("Administrador")) {
				if (!path.contains("/Crear/"))
					ec.redirect(ec.getRequestContextPath() + login);
				else
					return;
			}
			if (u.getTblrolusuario().getRolUsuario().equals("Operador")) {
				if (!path.contains("/Operador/"))
					ec.redirect(ec.getRequestContextPath() + login);
				else
					return;
			}

		}

	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getCelularUsuario() {
		return celularUsuario;
	}

	public void setCelularUsuario(String celularUsuario) {
		this.celularUsuario = celularUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public Date getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}

	public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}

	public String getSexoUsuario() {
		return sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

	public String getCorreoLogin() {
		return correoLogin;
	}

	public void setCorreoLogin(String correoLogin) {
		this.correoLogin = correoLogin;
	}

	public String getClaveLogin() {
		return claveLogin;
	}

	public void setClaveLogin(String claveLogin) {
		this.claveLogin = claveLogin;
	}

	public boolean isComprobado() {
		return comprobado;
	}

	public void setComprobado(boolean comprobado) {
		this.comprobado = comprobado;
	}

	public Tblusuario getU() {
		return u;
	}

	public void setU(Tblusuario u) {
		this.u = u;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Integer getIdevento() {
		return idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

}
