package codigoqr.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblasistentes database table.
 * 
 */
@Entity
@Table(name="tblasistentes")
@NamedQuery(name="Tblasistente.findAll", query="SELECT t FROM Tblasistente t")
public class Tblasistente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cedula_asistente")
	private String cedulaAsistente;

	@Column(name="apellido_asistente")
	private String apellidoAsistente;

	@Column(name="celular_asistente")
	private String celularAsistente;

	@Column(name="correo_asistente")
	private String correoAsistente;

	@Column(name="nombre_asistente")
	private String nombreAsistente;

	//bi-directional many-to-one association to Tblasistencia
	@OneToMany(mappedBy="tblasistente")
	private List<Tblasistencia> tblasistencias;

	//bi-directional many-to-one association to Tblinstitucion
	@ManyToOne
	@JoinColumn(name="id_institucion")
	private Tblinstitucion tblinstitucion;

	//bi-directional many-to-one association to Tbltipoasistente
	@ManyToOne
	@JoinColumn(name="id_tipoasistente")
	private Tbltipoasistente tbltipoasistente;

	public Tblasistente() {
	}

	public String getCedulaAsistente() {
		return this.cedulaAsistente;
	}

	public void setCedulaAsistente(String cedulaAsistente) {
		this.cedulaAsistente = cedulaAsistente;
	}

	public String getApellidoAsistente() {
		return this.apellidoAsistente;
	}

	public void setApellidoAsistente(String apellidoAsistente) {
		this.apellidoAsistente = apellidoAsistente;
	}

	public String getCelularAsistente() {
		return this.celularAsistente;
	}

	public void setCelularAsistente(String celularAsistente) {
		this.celularAsistente = celularAsistente;
	}

	public String getCorreoAsistente() {
		return this.correoAsistente;
	}

	public void setCorreoAsistente(String correoAsistente) {
		this.correoAsistente = correoAsistente;
	}

	public String getNombreAsistente() {
		return this.nombreAsistente;
	}

	public void setNombreAsistente(String nombreAsistente) {
		this.nombreAsistente = nombreAsistente;
	}

	public List<Tblasistencia> getTblasistencias() {
		return this.tblasistencias;
	}

	public void setTblasistencias(List<Tblasistencia> tblasistencias) {
		this.tblasistencias = tblasistencias;
	}

	public Tblasistencia addTblasistencia(Tblasistencia tblasistencia) {
		getTblasistencias().add(tblasistencia);
		tblasistencia.setTblasistente(this);

		return tblasistencia;
	}

	public Tblasistencia removeTblasistencia(Tblasistencia tblasistencia) {
		getTblasistencias().remove(tblasistencia);
		tblasistencia.setTblasistente(null);

		return tblasistencia;
	}

	public Tblinstitucion getTblinstitucion() {
		return this.tblinstitucion;
	}

	public void setTblinstitucion(Tblinstitucion tblinstitucion) {
		this.tblinstitucion = tblinstitucion;
	}

	public Tbltipoasistente getTbltipoasistente() {
		return this.tbltipoasistente;
	}

	public void setTbltipoasistente(Tbltipoasistente tbltipoasistente) {
		this.tbltipoasistente = tbltipoasistente;
	}

}