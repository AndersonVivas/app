package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblusuarios database table.
 * 
 */
@Entity
@Table(name="tblusuarios")
@NamedQuery(name="Tblusuario.findAll", query="SELECT t FROM Tblusuario t")
public class Tblusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLUSUARIOS_IDUSUARIO_GENERATOR", sequenceName="TBLUSUARIOS_ID_USUARIO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLUSUARIOS_IDUSUARIO_GENERATOR")
	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="apellido_usuario")
	private String apellidoUsuario;

	@Column(name="celular_usuario")
	private String celularUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="correo_usuario")
	private String correoUsuario;

	@Temporal(TemporalType.DATE)
	@Column(name="\"fechaNacimiento_usuario\"")
	private Date fechaNacimiento_usuario;

	@Column(name="nombre_usario")
	private String nombreUsario;

	@Column(name="sexo_usuario")
	private String sexoUsuario;

	//bi-directional many-to-one association to Tblevento
	@OneToMany(mappedBy="tblusuario")
	private List<Tblevento> tbleventos;

	//bi-directional many-to-one association to Tbloperador
	@OneToMany(mappedBy="tblusuario")
	private List<Tbloperador> tbloperadors;

	//bi-directional many-to-one association to Tblparametrosevnt
	@ManyToOne
	@JoinColumn(name="id_parametro")
	private Tblparametrosevnt tblparametrosevnt;

	//bi-directional many-to-one association to Tblrolusuario
	@ManyToOne
	@JoinColumn(name="id_rolusuario")
	private Tblrolusuario tblrolusuario;

	public Tblusuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidoUsuario() {
		return this.apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCelularUsuario() {
		return this.celularUsuario;
	}

	public void setCelularUsuario(String celularUsuario) {
		this.celularUsuario = celularUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getCorreoUsuario() {
		return this.correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public Date getFechaNacimiento_usuario() {
		return this.fechaNacimiento_usuario;
	}

	public void setFechaNacimiento_usuario(Date fechaNacimiento_usuario) {
		this.fechaNacimiento_usuario = fechaNacimiento_usuario;
	}

	public String getNombreUsario() {
		return this.nombreUsario;
	}

	public void setNombreUsario(String nombreUsario) {
		this.nombreUsario = nombreUsario;
	}

	public String getSexoUsuario() {
		return this.sexoUsuario;
	}

	public void setSexoUsuario(String sexoUsuario) {
		this.sexoUsuario = sexoUsuario;
	}

	public List<Tblevento> getTbleventos() {
		return this.tbleventos;
	}

	public void setTbleventos(List<Tblevento> tbleventos) {
		this.tbleventos = tbleventos;
	}

	public Tblevento addTblevento(Tblevento tblevento) {
		getTbleventos().add(tblevento);
		tblevento.setTblusuario(this);

		return tblevento;
	}

	public Tblevento removeTblevento(Tblevento tblevento) {
		getTbleventos().remove(tblevento);
		tblevento.setTblusuario(null);

		return tblevento;
	}

	public List<Tbloperador> getTbloperadors() {
		return this.tbloperadors;
	}

	public void setTbloperadors(List<Tbloperador> tbloperadors) {
		this.tbloperadors = tbloperadors;
	}

	public Tbloperador addTbloperador(Tbloperador tbloperador) {
		getTbloperadors().add(tbloperador);
		tbloperador.setTblusuario(this);

		return tbloperador;
	}

	public Tbloperador removeTbloperador(Tbloperador tbloperador) {
		getTbloperadors().remove(tbloperador);
		tbloperador.setTblusuario(null);

		return tbloperador;
	}

	public Tblparametrosevnt getTblparametrosevnt() {
		return this.tblparametrosevnt;
	}

	public void setTblparametrosevnt(Tblparametrosevnt tblparametrosevnt) {
		this.tblparametrosevnt = tblparametrosevnt;
	}

	public Tblrolusuario getTblrolusuario() {
		return this.tblrolusuario;
	}

	public void setTblrolusuario(Tblrolusuario tblrolusuario) {
		this.tblrolusuario = tblrolusuario;
	}

}