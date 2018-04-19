package codigoqr.view.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import codigoqr.model.manager.ManagerQR;

@SuppressWarnings("cdi-not-passivation-capable")
@SessionScoped
@ManagedBean
public class BeanOperador {

	private String nombreUsuario;
	private String apellidoUsuario;
	private String correoUsuario;
	private String celularUsuario;
	private String claveUsuario;
	private Date fechaNacimientoUsuario;
	private String sexoUsuario;
	// login
	private Integer idevento;
	@EJB
	ManagerQR managerQR;

	@PostConstruct
	public void iniciar() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String mail = request.getParameter("mail");
		correoUsuario = mail;
		idevento = Integer.parseInt(request.getParameter("idevento"));		
	}

	public void insertarOperador(){
		claveUsuario = DigestUtils.sha1Hex(claveUsuario);		
		managerQR.registrarUsuario(nombreUsuario, 2, apellidoUsuario, correoUsuario, celularUsuario, claveUsuario,
				fechaNacimientoUsuario, sexoUsuario);
		managerQR.registrarOperador(idevento, correoUsuario);

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

	public Integer getIdevento() {
		return idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
	}

}
