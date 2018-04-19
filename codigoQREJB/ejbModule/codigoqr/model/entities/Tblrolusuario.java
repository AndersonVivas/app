package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblrolusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Tblrolusuario.findAll", query="SELECT t FROM Tblrolusuario t")
public class Tblrolusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBLROLUSUARIO_IDROLUSUARIO_GENERATOR", sequenceName="TBLROLUSUARIO_ID_ROLUSUARIO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBLROLUSUARIO_IDROLUSUARIO_GENERATOR")
	@Column(name="id_rolusuario")
	private Integer idRolusuario;

	@Column(name="descripcion_rol")
	private String descripcionRol;

	@Column(name="rol_usuario")
	private String rolUsuario;

	//bi-directional many-to-one association to Tblusuario
	@OneToMany(mappedBy="tblrolusuario")
	private List<Tblusuario> tblusuarios;

	public Tblrolusuario() {
	}

	public Integer getIdRolusuario() {
		return this.idRolusuario;
	}

	public void setIdRolusuario(Integer idRolusuario) {
		this.idRolusuario = idRolusuario;
	}

	public String getDescripcionRol() {
		return this.descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public String getRolUsuario() {
		return this.rolUsuario;
	}

	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public List<Tblusuario> getTblusuarios() {
		return this.tblusuarios;
	}

	public void setTblusuarios(List<Tblusuario> tblusuarios) {
		this.tblusuarios = tblusuarios;
	}

	public Tblusuario addTblusuario(Tblusuario tblusuario) {
		getTblusuarios().add(tblusuario);
		tblusuario.setTblrolusuario(this);

		return tblusuario;
	}

	public Tblusuario removeTblusuario(Tblusuario tblusuario) {
		getTblusuarios().remove(tblusuario);
		tblusuario.setTblrolusuario(null);

		return tblusuario;
	}

}