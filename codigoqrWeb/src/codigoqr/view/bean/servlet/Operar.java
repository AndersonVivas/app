package codigoqr.view.bean.servlet;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import codigoqr.model.entities.Tblusuario;
import codigoqr.model.manager.ManagerQR;

@ManagedBean
@SessionScoped
@WebServlet("/Operar")
public class Operar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Tblusuario u;
	private Integer idevento;
	// Registrar Usuario
	private String nombreUsuario;
	private String apellidoUsuario;
	private String correoUsuario;
	private String celularUsuario;
	private String claveUsuario;
	private Date fechaNacimiento_usuario;
	private String sexoUsuario;
	@EJB
	ManagerQR managerQR;

	public Operar() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mail = request.getParameter("mail");
		idevento = Integer.parseInt(request.getParameter("idevento"));
		setCorreoUsuario(mail);

		FacesContext contex = FacesContext.getCurrentInstance();
		try {
			if (managerQR.comprobarOperador(mail)) {
				contex.getExternalContext()
						.redirect("faces/Registros/RegistroOperador.xhtml?mail=vivas251@gmail.com&idevento=7");
			} else
				managerQR.registrarOperador(idevento, mail);
			contex.getExternalContext().redirect("faces/Comprobado.xhtml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void InsertarOperador() throws Exception {
		claveUsuario = DigestUtils.sha1Hex(claveUsuario);
		System.out.println(claveUsuario + "" + correoUsuario);

	}

	public Tblusuario getU() {
		return u;
	}

	public void setU(Tblusuario u) {
		this.u = u;
	}

	public Integer getIdevento() {
		return idevento;
	}

	public void setIdevento(Integer idevento) {
		this.idevento = idevento;
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

	public Date getFechaNacimiento_usuario() {
		return fechaNacimiento_usuario;
	}

	public void setFechaNacimiento_usuario(Date fechaNacimiento_usuario) {
		this.fechaNacimiento_usuario = fechaNacimiento_usuario;
	}

	public String getSexoUsuario() {
		return sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

}
